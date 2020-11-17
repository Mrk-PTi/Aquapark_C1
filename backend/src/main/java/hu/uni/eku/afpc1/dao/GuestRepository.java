package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, String> {
    Guest findByGuestName(String guestName);
}
