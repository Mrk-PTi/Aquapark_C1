package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Slide;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class SlideDaoImpl implements SlideDao {

    private final SlideRepository repository;

    @Override
    public void create(Slide slide) {
        repository.save(SlideEntityModelConverter.model2entity(slide));
    }

    @Override
    public Collection<Slide> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> SlideEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Slide original, Slide updated) {

    }

    @Override
    public void delete(Slide complexNumber) {

    }

    private static class SlideEntityModelConverter{

        private static Slide entity2model(hu.uni.eku.afpc1.dao.entity.ComplexNumber entity){
            return new Slide(
                    entity.getRealPart(),
                    entity.getImaginaryPart()
            );
        }

        private static hu.uni.eku.afpc1.dao.entity.Slide model2entity(ComplexNumber model){
            return hu.uni.eku.afpc1.dao.entity.Slide.builder()
                    .realPart(model.getReal())
                    .imaginaryPart(model.getImaginary())
                    .build();
        }

    }
}
