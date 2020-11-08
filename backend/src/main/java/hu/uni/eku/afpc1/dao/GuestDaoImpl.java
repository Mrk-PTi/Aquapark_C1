package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
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
    public void update(Guest original, Guest updated) {

    }

    @Override
    public void delete(Guest guest) {

    }

    private static class GuestEntityModelConverter{

        private static Guest entity2model(hu.uni.eku.afpc1.dao.entity.Guest entity){
            return new Guest(
                    entity.getRealPart(),
                    entity.getImaginaryPart()
            );
        }

        private static hu.uni.eku.afpc1.dao.entity.Guest model2entity(Guest model){
            return hu.uni.eku.afpc1.dao.entity.Guest.builder()
                    .realPart(model.getReal())
                    .imaginaryPart(model.getImaginary())
                    .build();
        }

    }
}
