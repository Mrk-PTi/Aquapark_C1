package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Pay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class PayDaoImpl implements PayDao {

    private final PayRepository repository;

    @Override
    public void create(Pay pay) {
        repository.save(PayEntityModelConverter.model2entity(pay));
    }

    @Override
    public Collection<Pay> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> PayEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int pay_id, Pay updated) {
        hu.uni.eku.afpc1.dao.entity.Pay temp = repository.findByPay_id(pay_id);
        temp.setPay_id(updated.getPay_id());
        repository.save(temp);
    }

    @Override
    public void delete(int pay_id) {
        hu.uni.eku.afpc1.dao.entity.Pay temp = repository.findByPay_id(pay_id);
        if(temp != null)
            repository.delete(temp);
    }

    private static class PayEntityModelConverter{

        private static Pay entity2model(hu.uni.eku.afpc1.dao.entity.Pay entity){
            return new Pay(entity.getPay_id());
        }

        private static hu.uni.eku.afpc1.dao.entity.Pay model2entity(Pay model){
            return hu.uni.eku.afpc1.dao.entity.Pay.builder()
                    .pay_id(model.getPay_id())
                    .build();
        }

    }
}