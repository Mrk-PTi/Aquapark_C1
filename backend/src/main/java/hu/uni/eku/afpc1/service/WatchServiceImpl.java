package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.dao.WatchDao;
import hu.uni.eku.afpc1.model.Watch;
import hu.uni.eku.afpc1.service.exceptions.NotFoundException;
import hu.uni.eku.afpc1.service.exceptions.WatchAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class WatchServiceImpl implements WatchService {

    private final WatchDao dao;

    @Override
    public void record(Watch watch) throws WatchAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( w -> w.getWatchId() == watch.getWatchId());
        if(isAlreadyRecorded){
            log.info("Watch {} is already recorded!", watch);
            throw new WatchAlreadyExistsException(String.format("Watch (%s) already exists!", watch.toString()));

        }
        dao.create(watch);
    }

    @Override
    public Collection<Watch> readAll() {
        return dao.readAll();
    }

    @Override
    public void delete(Integer watchId) throws NotFoundException {
        dao.delete(watchId);
    }
}