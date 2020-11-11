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
    public void update(int slide_id, Slide updated) {
        hu.uni.eku.afpc1.dao.entity.Slide temp = repository.findBySlide_id(slide_id);
        temp.setSlide_id(updated.getSlide_id());
        temp.setSlide_expenses(updated.getSlide_expense());
        repository.save(temp);
    }

    @Override
    public void delete(int slide_id) {
        hu.uni.eku.afpc1.dao.entity.Slide result = repository.findBySlide_id(slide_id);
        if(result != null)
            repository.delete(result);
    }

    private static class SlideEntityModelConverter{

        private static Slide entity2model(hu.uni.eku.afpc1.dao.entity.Slide entity){
            return new Slide(
                    entity.getSlide_expenses(),
                    entity.getSlide_id()
            );
        }

        private static hu.uni.eku.afpc1.dao.entity.Slide model2entity(Slide model){
            return hu.uni.eku.afpc1.dao.entity.Slide.builder()
                    .slide_expenses(model.getSlide_expense())
                    .slide_id(model.getSlide_id())
                    .build();
        }

    }
}
