package hu.uni.eku.afpc1.dao;

import hu.uni.eku.afpc1.dao.entity.Pay;
import org.springframework.data.repository.CrudRepository;

public interface PayRepository extends CrudRepository<Pay, Integer> {
    Pay findByPay_id(int pay_id);
}