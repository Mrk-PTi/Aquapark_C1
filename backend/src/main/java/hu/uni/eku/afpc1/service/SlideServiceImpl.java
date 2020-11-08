package hu.uni.eku.afpc1.service;

import hu.uni.eku.afpc1.dao.SlideDao;
import hu.uni.eku.afpc1.model.Slide;
import hu.uni.eku.afpc1.service.exceptions.SlideAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Service
public class SlideServiceImpl implements SlideService {

    private final SlideDao dao;

    @Override
    public void record(Slide slide) throws SlideAlreadyExistsException {
        final boolean isAlreadyRecorded = dao.readAll()
                .stream()
                .anyMatch( s ->
                        s.getReal() == slide.getReal()
                                &&
                                s.getImaginary() == slide.getImaginary());
        if(isAlreadyRecorded){
            log.info("This slide {} is already recorded!", slide);
            throw new SlideAlreadyExistsException(String.format("This slide (%s) already exists!", slide.toString()));

        }
        dao.create(slide);
    }

    @Override
    public Collection<Slide> readAll() {
        return dao.readAll();
    }
}
