package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Guest;

import java.util.Collection;

public interface GuestDao {

    void create(Guest guest);

    Collection<Guest> readAll();

    void update(String guestName, Guest updated);

    void delete(String guestName);
}
