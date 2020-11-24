package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.dao.PayDao;
import hu.uni.eku.afpc1.model.Pay;
import hu.uni.eku.afpc1.service.exceptions.NotFoundException;
import hu.uni.eku.afpc1.service.exceptions.PayAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class PayServiceImpl implements PayService {

    private final PayDao dao;

    @Override
    public void record(Pay Pay) throws PayAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( p -> p.getPayId() == Pay.getPayId());
        if(isAlreadyRecorded){
            log.info("Pay {} is already recorded!", Pay);
            throw new PayAlreadyExistsException(String.format("Pay (%s) already exists!", Pay.toString()));

        }
        dao.create(Pay);
    }

    @Override
    public Collection<Pay> readAll() {
        return dao.readAll();
    }

    @Override
    public void delete(Integer payId) throws NotFoundException {
        dao.delete(payId);
    }
}