package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.TransactionDTO;
import hu.uni.eku.afpc1.controller.dto.TransactionRequestDTO;
import hu.uni.eku.afpc1.model.Transaction;
import hu.uni.eku.afpc1.service.TransactionService;
import hu.uni.eku.afpc1.service.exceptions.TransactionAlreadyExistsException;
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
@RequestMapping(value = "/Transaction")
@RequiredArgsConstructor
@Api(tags = "Transactiones")
@Slf4j
public class TransactionController {

    private final TransactionService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            TransactionRequestDTO request
    ){
        log.info("Recording of Transaction ({})",request.getTransaction_id());
        try {
            service.record(new Transaction(request.getTransaction_id()));
        } catch (TransactionAlreadyExistsException e) {
            log.info("Transaction ({}) is already exists! Message: {}", request.getTransaction_id(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Transactiones")
    public Collection<TransactionDTO> query(){
        return service.readAll().stream().map(model ->
                TransactionDTO.builder()
                .transaction_id(model.getTransaction_id())
                .build()
        ).collect(Collectors.toList());
    }

}