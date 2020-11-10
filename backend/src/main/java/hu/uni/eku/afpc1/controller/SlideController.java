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
        log.info("Recording of Slide ({},{})",request.getSlide_id(), request.getSlide_expenses());
        try {
            service.record(new Slide(request.getSlide_id(), request.getSlide_expenses()));
        } catch (SlideAlreadyExistsException e) {
            log.info("Slide ({},{}) is already exists! Message: {}", request.getSlide_id(), request.getSlide_expenses(), e.getMessage());
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
                        .slide_id(model.getSlide_id())
                        .slide_expense(model.getSlide_expense())
                        .build()
        ).collect(Collectors.toList());
    }

}