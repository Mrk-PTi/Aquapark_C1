package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Watch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
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
    public void update(Watch original, Watch updated) {
        hu.uni.eku.afpc1.dao.entity.Watch toUpdate = repository.findById(original.getId());
        toUpdate.setwatch_id(updated.getwatch_id());
        repository.save(toUpdate);
    }

    @Override
    public void delete(Watch watch) {
        repository.deleteById(watch.getId());
    }

    private static class WatchEntityModelConverter{

        private static Watch entity2model(hu.uni.eku.afpc1.dao.entity.Watch entity){
            return new Watch(entity.getwatch_id());
        }

        private static hu.uni.eku.afpc1.dao.entity.Watch model2entity(Watch model){
            return hu.uni.eku.afpc1.dao.entity.Watch.builder()
                    .watch_id(model.getwatch_id())
                    .build();
        }

    }
}