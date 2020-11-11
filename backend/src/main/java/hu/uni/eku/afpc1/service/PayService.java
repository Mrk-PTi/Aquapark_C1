package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.Pay;
import hu.uni.eku.afpc1.service.exceptions.PayAlreadyExistsException;

import java.util.Collection;

public interface PayService {

    void record(Pay pay) throws PayAlreadyExistsException;

    Collection<Pay> readAll();
}