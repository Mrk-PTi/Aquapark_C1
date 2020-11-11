package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    Transaction findByTransaction_id(int transaction_id);
}