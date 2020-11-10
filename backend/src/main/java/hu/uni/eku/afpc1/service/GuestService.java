package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.Guest;
import hu.uni.eku.afpc1.service.exceptions.GuestAlreadyExistsException;

import java.util.Collection;

public interface GuestService {

    void record(Guest guest) throws GuestAlreadyExistsException;

    Collection<Guest> readAll();
}
