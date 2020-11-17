package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.dao.GuestDao;
import hu.uni.eku.afpc1.model.Guest;
import hu.uni.eku.afpc1.service.exceptions.GuestAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestDao dao;

    @Override
    public void record(Guest guest) throws GuestAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( g ->
                        g.getGuestId() == guest.getGuestId()
                                &&
                                g.getArrivalDateTime() == guest.getArrivalDateTime());
        if(isAlreadyRecorded){
            log.info("Guest {} is already recorded!", guest);
            throw new GuestAlreadyExistsException(String.format("Guest (%s) already exists!", guest.toString()));

        }
        dao.create(guest);
    }

    @Override
    public Collection<Guest> readAll() {
        return dao.readAll();
    }
}
