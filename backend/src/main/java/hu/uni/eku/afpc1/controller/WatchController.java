package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.WatchDTO;
import hu.uni.eku.afpc1.controller.dto.WatchCreateRequestDTO;
import hu.uni.eku.afpc1.model.Watch;
import hu.uni.eku.afpc1.service.WatchService;
import hu.uni.eku.afpc1.service.exceptions.NotFoundException;
import hu.uni.eku.afpc1.service.exceptions.WatchAlreadyExistsException;
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
@RequestMapping(value = "/Watch")
@RequiredArgsConstructor
@Api(tags = "Watch")
@Slf4j
public class WatchController {

    private final WatchService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    WatchCreateRequestDTO request
    ) {
        log.info("Recording of Watch ({})", request.getWatchId());
        try {
            service.record(new Watch(request.getWatchId()));
        } catch (WatchAlreadyExistsException e) {
            log.info("Watch ({}) is already exists! Message: {}", request.getWatchId(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Query Watches")
    public Collection<WatchDTO> query() {
        return service.readAll().stream().map(model ->
                WatchDTO.builder()
                        .watchId(model.getWatchId())
                        .build()
        ).collect(Collectors.toList());
    }

    @DeleteMapping(value = {"/{watchId}"})
    @ApiOperation(value = "Delete a watch")
    public void delete(@PathVariable Integer watchId) {
        try {
            service.delete(watchId);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }
}
