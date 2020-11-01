package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.GuestDTO;
import hu.uni.eku.afpc1.controller.dto.GuestCreateRequestDTO;
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
@RequestMapping(value= "/guest")
@RequiredArgsConstructor
@Api(tags = "Guest")
@Slf4j

public class GuestController {

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            GuestCreateRequestDTO request
    ){
        log.info("Recording Guest {}",request.getGuest());
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Guest")
    public Collection<GuestDTO> query(){
        return service.readAll().stream().map(model ->
                GuestDTO.builder()
                .Guest(model.getGuest())
                .build()
        ).collect(Collectors.toList());
    }
}





