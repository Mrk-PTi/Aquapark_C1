package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afpc1.controller.dto.SlideDTO;
import hu.uni.eku.afpc1.controller.dto.SlideCreateRequestDTO;
import hu.uni.eku.afpc1.model.Slide;
import hu.uni.eku.afpc1.service.SlideService;
import hu.uni.eku.afpc1.service.exceptions.SlideAlreadyExistsException;
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
@RequestMapping(value = "/Slide")
@RequiredArgsConstructor
@Api(tags = "Slides")
@Slf4j
public class SlideController {

    private final SlideService service;

    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
                    SlideCreateRequestDTO request
    ){
        log.info("Recording of Slide ({},{})",request.getSlideId(), request.getSlideExpenses());
        try {
            service.record(new Slide(request.getSlideId(), request.getSlideExpenses()));
        } catch (SlideAlreadyExistsException e) {
            log.info("Slide ({},{}) is already exists! Message: {}", request.getSlideId(), request.getSlideExpenses(), e.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    e.getMessage()
            );
        }
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Slides")
    public Collection<SlideDTO> query(){
        return service.readAll().stream().map(model ->
                SlideDTO.builder()
                        .slideId(model.getSlideId())
                        .slideExpense(model.getSlideExpense())
                        .build()
        ).collect(Collectors.toList());
    }

}