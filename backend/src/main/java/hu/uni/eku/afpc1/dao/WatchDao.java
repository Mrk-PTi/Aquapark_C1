package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Watch;

import java.util.Collection;

public interface Watch {

    void create(Watch watch);

    Collection<Watch> readAll();

    void update(Watch original, Watch updated);

    void delete(Watch watch);
}