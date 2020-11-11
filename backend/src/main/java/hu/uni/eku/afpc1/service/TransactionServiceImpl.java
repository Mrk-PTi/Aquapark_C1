package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.dao.TransactionDao;
import hu.uni.eku.afpc1.model.Transaction;
import hu.uni.eku.afpc1.service.exceptions.TransactionAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionDao dao;

    @Override
    public void record(Transaction Transaction) throws TransactionAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( w -> w.getTransaction_id() == Transaction.getTransaction_id());
        if(isAlreadyRecorded){
            log.info("Transaction {} is already recorded!", Transaction);
            throw new TransactionAlreadyExistsException(String.format("Transaction (%s) already exists!", Transaction.toString()));

        }
        dao.create(Transaction);
    }

    @Override
    public Collection<Transaction> readAll() {
        return dao.readAll();
    }
}