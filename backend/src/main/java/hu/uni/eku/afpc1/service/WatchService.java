package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.Watch;
import hu.uni.eku.afpc1.service.exceptions.WatchAlreadyExistsException;

import java.util.Collection;

public interface WatchService {

    void record(Watch watch) throws WatchAlreadyExistsException;

    Collection<Watch> readAll();
}