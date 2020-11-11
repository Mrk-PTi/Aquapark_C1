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
    public void update(int watch_id, Watch updated) {
        hu.uni.eku.afpc1.dao.entity.Watch temp = repository.findByWatch_id(watch_id);
        temp.setWatch_id(updated.getWatch_id());
        repository.save(temp);
    }

    @Override
    public void delete(int watch_id) {
        hu.uni.eku.afpc1.dao.entity.Watch temp = repository.findByWatch_id(watch_id);
        if(temp != null)
            repository.delete(temp);
    }

    private static class WatchEntityModelConverter{

        private static Watch entity2model(hu.uni.eku.afpc1.dao.entity.Watch entity){
            return new Watch(entity.getWatch_id());
        }

        private static hu.uni.eku.afpc1.dao.entity.Watch model2entity(Watch model){
            return hu.uni.eku.afpc1.dao.entity.Watch.builder()
                    .watch_id(model.getWatch_id())
                    .build();
        }

    }
}