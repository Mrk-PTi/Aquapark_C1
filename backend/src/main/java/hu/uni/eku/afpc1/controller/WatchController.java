package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.WatchDTO;
import hu.uni.eku.afpc1.controller.dto.WatchCreateRequestDTO;
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
@Api(tags = "Watch")
@Slf4j
public class WatchController {

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            WatchCreateRequestDTO request
    ){
        log.info("Recording of Watch {}",request.getWatch());
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Watch")
    public Collection<WatchDTO> query(){
        return service.readAll().stream().map(model ->
                WatchDTO.builder()
                .Watch(model.getWatch())
                .build()
        ).collect(Collectors.toList());
    }

}