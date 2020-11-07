package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.TransactionDTO;
import hu.uni.eku.afpc1.controller.dto.TransactionRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value= "/transaction")
@RequiredArgsConstructor
@Api(tags = "Transaction")
@Slf4j

public class TransactionController {

    @PostMapping("/transaction")
    @ApiOperation(value = "Transaction")
    public void transaction(
            @RequestBody
            TransactionRequestDTO request
    )

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Transaction")
    public Collection<TransactionDTO> query(){
        return service.readAll().stream().map(model ->
                TransactionDTO.builder()
                .Transaction(model.getTransaction())
                .build()
        ).collect(Collectors.toList());
    }
}