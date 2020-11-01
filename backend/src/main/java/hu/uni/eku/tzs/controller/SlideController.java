package hu.uni.eku.tzs.controller;
import hu.uni.eku.tzs.controller.dto.SlideDTO;
import hu.uni.eku.tzs.controller.dto.SlideCreateRequestDTO;
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
@RequestMapping(value = "/slide")
@RequiredArgsConstructor
@Api(tags = "Slide")
@Slf4j
public class SlideController {


    @PostMapping("/record")
    @ApiOperation(value = "Record")
    public void record(
            @RequestBody
            SlideRecordRequestDto request
    ){
        log.info("Recording of Slide {}",request.getSlide());
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value= "Query Slide")
    public Collection<SlideDto> query(){
        return service.readAll().stream().map(model ->
                SlideDto.builder()
                .slide(model.getSlide())
                .build()
        ).collect(Collectors.toList());
    }

}

