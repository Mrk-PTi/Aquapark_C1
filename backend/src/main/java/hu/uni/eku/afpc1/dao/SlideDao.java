package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Slide;

import java.util.Collection;

public interface SlideDao {

    void create(Slide slide);

    Collection<Slide> readAll();

    void update(int slide_id, Slide updated);

    void delete(int slide_id);
}