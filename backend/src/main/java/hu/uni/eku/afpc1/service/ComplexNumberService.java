package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.model.ComplexNumber;
import hu.uni.eku.afpc1.service.exceptions.ComplexNumberAlreadyExistsException;

import java.util.Collection;

public interface ComplexNumberService {

    void record(ComplexNumber complexNumber) throws ComplexNumberAlreadyExistsException;

    Collection<ComplexNumber> readAll();
}
