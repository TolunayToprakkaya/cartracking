package com.car.tracking.system.controllers;

import com.car.tracking.system.models.Car;
import com.car.tracking.system.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    @Qualifier("carService")
    private CarService carService;

    //FindAll
    @RequestMapping(method = RequestMethod.GET)
    public List<Car> findAll() {
        return carService.findAll();
    }

    //View
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Car> view(@PathVariable String id) {
        return carService.findOneById(id);
    }

    //Save
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody Car car) {
        carService.save(car);
    }

    //Update
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Car car) {
        carService.update(car);
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        carService.delete(id);
    }

}
