package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Slide;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public void update(Integer slideId, Slide updated) {
        hu.uni.eku.afpc1.dao.entity.Slide temp = repository.findBySlideId(slideId);
        temp.setSlideId(updated.getSlideId());
        temp.setSlideExpenses(updated.getSlideExpense());
        repository.save(temp);
    }

    @Override
    public void delete(Integer slideId) {
        hu.uni.eku.afpc1.dao.entity.Slide result = repository.findBySlideId(slideId);
        if(result != null)
            repository.delete(result);
    }

    private static class SlideEntityModelConverter{

        private static Slide entity2model(hu.uni.eku.afpc1.dao.entity.Slide entity){
            return new Slide(
                    entity.getSlideExpenses(),
                    entity.getSlideId()
            );
        }

        private static hu.uni.eku.afpc1.dao.entity.Slide model2entity(Slide model){
            return hu.uni.eku.afpc1.dao.entity.Slide.builder()
                    .slideExpenses(model.getSlideExpense())
                    .slideId(model.getSlideId())
                    .build();
        }

    }
}
