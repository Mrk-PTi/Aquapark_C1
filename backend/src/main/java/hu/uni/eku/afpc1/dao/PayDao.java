package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.model.Pay;

import java.util.Collection;

public interface PayDao {

    void create(Pay pay);

    Collection<Pay> readAll();

    void update(int pay_id, Pay updated);

    void delete(int pay_id);
}