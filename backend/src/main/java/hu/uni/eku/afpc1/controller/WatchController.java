package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.WatchDTO;
import hu.uni.eku.afpc1.controller.dto.WatchCreateRequestDTO;
import hu.uni.eku.afpc1.model.Watch;
import hu.uni.eku.afpc1.service.WatchService;
import hu.uni.eku.afpc1.service.exceptions.WatchAlreadyExistsException;
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
@RequestMapping(value = "/Watch")
@RequiredArgsConstructor
@Api(tags = "Watches")
@Slf4j
public class WatchController {

    private final WatchService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            WatchCreateRequestDTO request
    ){
        log.info("Recording of Watch ({})",request.getwatch_id());
        try {
            service.record(new Watch(request.getwatch_id()));
        } catch (WatchAlreadyExistsException e) {
            log.info("Watch ({}) is already exists! Message: {}", request.getwatch_id(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Watches")
    public Collection<WatchDTO> query(){
        return service.readAll().stream().map(model ->
                WatchDTO.builder()
                .watch_id(model.getwatch_id())
                .build()
        ).collect(Collectors.toList());
    }

}