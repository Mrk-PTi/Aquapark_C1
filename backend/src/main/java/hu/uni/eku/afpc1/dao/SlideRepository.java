package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Slide;
import hu.uni.eku.afpc1.dao.entity.Watch;
import org.springframework.data.repository.CrudRepository;

public interface SlideRepository extends CrudRepository<Slide, Integer> {
    Slide findBySlide_id(int slide_id);
}