package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Integer> {
    Guest findByGuest_id(int guest_id);
}
