package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Transaction;

import java.util.Collection;

public interface TransactionDao {

    void create(Transaction transaction);

    Collection<Transaction> readAll();

    void update(int transaction_id, Transaction updated);

    void delete(int transaction_id);
}