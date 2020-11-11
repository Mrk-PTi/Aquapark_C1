package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Watch;

import java.util.Collection;

public interface WatchDao {

    void create(Watch watch);

    Collection<Watch> readAll();

    void update(int watch_id, Watch updated);

    void delete(int watch_id);
}