package com.car.tracking.system.services.impl;

import com.car.tracking.system.models.Car;
import com.car.tracking.system.repostories.CarRepository;
import com.car.tracking.system.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public Optional<Car> findOneById(String id) {
        return this.carRepository.findById(id);
    }

    @Transactional
    @Override
    public Car save(Car car) {
        return this.carRepository.save(car);
    }

    @Transactional
    @Override
    public Car update(Car car) {
        return this.carRepository.save(car);
    }

    @Transactional
    @Override
    public void delete(String id) {
        carRepository.deleteById(id);
    }

}
