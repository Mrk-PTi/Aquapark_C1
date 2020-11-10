package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Watch;
import org.springframework.data.repository.CrudRepository;

public interface WatchRepository extends CrudRepository<Watch, Integer> {
    Watch findByWatch_id(int watch_id);
}