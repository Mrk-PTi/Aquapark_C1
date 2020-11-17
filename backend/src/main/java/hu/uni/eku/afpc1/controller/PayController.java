package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.PayDTO;
import hu.uni.eku.afpc1.controller.dto.PayRequestDTO;
import hu.uni.eku.afpc1.model.Pay;
import hu.uni.eku.afpc1.service.PayService;
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
@Api(tags = "Pays")
@Slf4j
public class PayController {

    private final PayService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            PayRequestDTO request
    ){
        log.info("Recording of Pay ({})",request.getPayId());
        try {
            service.record(new Pay(request.getPayId()));
        } catch (PayAlreadyExistsException e) {
            log.info("Pay ({}) is already exists! Message: {}", request.getPayId(), e.getMessage());
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
                .build()
        ).collect(Collectors.toList());
    }

}