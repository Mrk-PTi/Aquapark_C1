package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.ComplexNumber;

import java.util.Collection;

public interface ComplexNumberDao {

    void create(ComplexNumber complexNumber);

    Collection<ComplexNumber> readAll();

    void update(ComplexNumber original, ComplexNumber updated);

    void delete(ComplexNumber complexNumber);
}
