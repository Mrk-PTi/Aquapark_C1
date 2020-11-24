package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.Slide;
import hu.uni.eku.afpc1.service.exceptions.NotFoundException;
import hu.uni.eku.afpc1.service.exceptions.SlideAlreadyExistsException;

import java.util.Collection;

public interface SlideService {

    void record(Slide slide) throws SlideAlreadyExistsException;

    void delete(Integer watchId) throws NotFoundException;

    Collection<Slide> readAll();
}