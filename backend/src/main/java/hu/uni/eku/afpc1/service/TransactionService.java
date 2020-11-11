package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.Transaction;
import hu.uni.eku.afpc1.service.exceptions.TransactionAlreadyExistsException;

import java.util.Collection;

public interface TransactionService {

    void record(Transaction transaction) throws TransactionAlreadyExistsException;

    Collection<Transaction> readAll();
}