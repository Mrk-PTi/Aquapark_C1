package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class TransactionDaoImpl implements TransactionDao {

    private final TransactionRepository repository;

    @Override
    public void create(Transaction transaction) {
        repository.save(TransactionEntityModelConverter.model2entity(transaction));
    }

    @Override
    public Collection<Transaction> readAll() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(entity -> TransactionEntityModelConverter.entity2model(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void update(int transaction_id, Transaction updated) {
        hu.uni.eku.afpc1.dao.entity.Transaction temp = repository.findByTransaction_id(transaction_id);
        temp.setTransaction_id(updated.getTransaction_id());
        repository.save(temp);
    }

    @Override
    public void delete(int transaction_id) {
        hu.uni.eku.afpc1.dao.entity.Transaction temp = repository.findByTransaction_id(transaction_id);
        if(temp != null)
            repository.delete(temp);
    }

    private static class TransactionEntityModelConverter{

        private static Transaction entity2model(hu.uni.eku.afpc1.dao.entity.Transaction entity){
            return new Transaction(entity.getTransaction_id());
        }

        private static hu.uni.eku.afpc1.dao.entity.Transaction model2entity(Transaction model){
            return hu.uni.eku.afpc1.dao.entity.Transaction.builder()
                    .transaction_id(model.getTransaction_id())
                    .build();
        }

    }
}