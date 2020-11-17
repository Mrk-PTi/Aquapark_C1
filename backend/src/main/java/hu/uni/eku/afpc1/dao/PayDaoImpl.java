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
    public void update(Integer payId, Pay updated) {
        hu.uni.eku.afpc1.dao.entity.Pay temp = repository.findByPayId(payId);
        temp.setPayId(updated.getPayId());
        temp.setExpense(updated.getExpense());
        repository.save(temp);
    }

    @Override
    public void delete(Integer payId) {
        hu.uni.eku.afpc1.dao.entity.Pay temp = repository.findByPayId(payId);
        if(temp != null)
            repository.delete(temp);
    }

    private static class PayEntityModelConverter{

        private static Pay entity2model(hu.uni.eku.afpc1.dao.entity.Pay entity){
            return new Pay(entity.getPayId(),entity.getExpense());
        }

        private static hu.uni.eku.afpc1.dao.entity.Pay model2entity(Pay model){
            return hu.uni.eku.afpc1.dao.entity.Pay.builder()
                    .payId(model.getPayId())
                    .expense(model.getExpense())
                    .build();
        }

    }
}