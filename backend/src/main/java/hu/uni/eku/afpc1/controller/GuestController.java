package hu.uni.eku.afpc1.controller;

import hu.uni.eku.afp2020_team4.controller.dto.GuestCreateRequestDTO;
import hu.uni.eku.afp2020_team4.controller.dto.GuestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/guest")
@RequiredArgsConstructor
@Api(tags = "Guest")
@Slf4j
public class GuestController {

    // ideiglenesen itt tároljuk az órákat
    private Collection<GuestDTO> guests = new ArrayList<>();

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Fetch all guests")
    public Collection<GuestDTO> fetchAll() {
        return watches.stream().map(watch ->
                GuestDTO.builder()
                        .guest_id(guest.getGuestId())
                        .build()
        ).collect(Collectors.toList());
    }

    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Fetch guest by ID")
    public GuestDTO fetchById(@PathVariable String id) {
        for(GuestDTO guest: guests) {
            if(guest.getGuestId().equals(id)) {
                return GuestDTO.builder().guest_id(guest.getGuestId()).build();
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No guest found!");
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "Create a guest")
    public void create() {
        GuestDTO newGuest = GuestDTO.builder()
                .guest_id(int.randomint().toString())
                .build();
        guests.add(newGuest);
    }

    @PutMapping(value = {"/{id}"})
    @ApiOperation(value = "Update guest")
    public void update(@PathVariable int id, @RequestBody GuestCreateRequestDTO request) {
        guests = guests.stream().map(
                guests -> guest.getGuestId().equals(id)
                        ? GuestDTO.builder()
                        .guest_id(request.getGuestId())
                        .build()
                        : guest
        ).collect(Collectors.toList());
    }

    @DeleteMapping(value = {"/{id}"})
    @ApiOperation(value = "Delete a guest")
    public void delete(@PathVariable int id) {
        guests.removeIf(guest -> guest.getGuestId().equals(id));
    }
}