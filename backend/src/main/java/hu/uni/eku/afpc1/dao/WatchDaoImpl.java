package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class WatchDaoImpl implements WatchDao {

    private final WatchRepository repository;

    @Override
    public void create(Watch watch) {
        repository.save(WatchEntityModelConverter.model2entity(watch));
    }

    @Override
    public Collection<Watch> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> WatchEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer watchId, Watch updated) {
        hu.uni.eku.afpc1.dao.entity.Watch temp = repository.findByWatchId(watchId);
        temp.setWatchId(updated.getWatchId());
        repository.save(temp);
    }

    @Override
    public void delete(Integer watchId) {
        hu.uni.eku.afpc1.dao.entity.Watch temp = repository.findByWatchId(watchId);
        if(temp != null)
            repository.delete(temp);
    }

    private static class WatchEntityModelConverter{

        private static Watch entity2model(hu.uni.eku.afpc1.dao.entity.Watch entity){
            return new Watch(entity.getWatchId());
        }

        private static hu.uni.eku.afpc1.dao.entity.Watch model2entity(Watch model){
            return hu.uni.eku.afpc1.dao.entity.Watch.builder()
                    .watchId(model.getWatchId())
                    .build();
        }

    }
}