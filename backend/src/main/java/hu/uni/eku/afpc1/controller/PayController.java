package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.PayDTO;
import hu.uni.eku.afpc1.controller.dto.PayRequestDTO;
import hu.uni.eku.afpc1.model.Pay;
import hu.uni.eku.afpc1.service.PayService;
import hu.uni.eku.afpc1.service.exceptions.NotFoundException;
import hu.uni.eku.afpc1.service.exceptions.PayAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/Pay")
@RequiredArgsConstructor
@Api(tags = "Pay")
@Slf4j
public class PayController {

    private final PayService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            PayRequestDTO request
    ){
        log.info("Recording of Pay ({},{})",request.getPayId(),request.getExpense());
        try {
            service.record(new Pay(request.getPayId(),request.getExpense()));
        } catch (PayAlreadyExistsException e) {
            log.info("Pay ({},{}) is already exists! Message: {}", request.getPayId(), request.getExpense(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Pays")
    public Collection<PayDTO> query(){
        return service.readAll().stream().map(model ->
                PayDTO.builder()
                .payId(model.getPayId())
                        .expense(model.getExpense())
                .build()
        ).collect(Collectors.toList());
    }

    @DeleteMapping(value = {"/{payId}"})
    @ApiOperation(value = "Delete a Payment")
    public void delete(@PathVariable Integer payId) {
        try {
            service.delete(payId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

}