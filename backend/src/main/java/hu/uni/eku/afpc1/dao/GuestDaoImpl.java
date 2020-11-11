package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class GuestDaoImpl implements GuestDao {

    private final GuestRepository repository;

    @Override
    public void create(Guest guest) {
        repository.save(GuestEntityModelConverter.model2entity(guest));
    }

    @Override
    public Collection<Guest> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> GuestEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int guest_id, Guest updated) {
        hu.uni.eku.afpc1.dao.entity.Guest temp = repository.findByGuest_id(guest_id);
        temp.setGuest_id(updated.getGuest_id());
        repository.save(temp);
    }

    @Override
    public void delete(int guest_id) {
        hu.uni.eku.afpc1.dao.entity.Guest temp = repository.findByGuest_id(guest_id);
        if(temp != null)
            repository.delete(temp);
    }

    private static class GuestEntityModelConverter{

        private static Guest entity2model(hu.uni.eku.afpc1.dao.entity.Guest entity){
            return new Guest(entity.getGuest_id(), entity.getArrivalDateTime());
        }

        private static hu.uni.eku.afpc1.dao.entity.Guest model2entity(Guest model){
            return hu.uni.eku.afpc1.dao.entity.Guest.builder()
                    .guest_id(model.getGuest_id())
                    .arrivalDateTime(model.getArrivalDateTime())
                    .build();
        }

    }
}