package com.car.tracking.system.models;

import com.car.tracking.system.models.seedwork.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_CAR")
public class Car extends AbstractEntity {

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "problem")
    private String problem;

    @Column(name = "done")
    private String done;

    @Column(name = "car_part")
    private String carPart;

    @Column(name = "price")
    private Integer price;

    @Column(name = "arrival_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date arrivalDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getLicencePlate() {
        return licencePlate;
    }
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getProblem() {
        return problem;
    }
    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDone() {
        return done;
    }
    public void setDone(String done) {
        this.done = done;
    }

    public String getCarPart() {
        return carPart;
    }
    public void setCarPart(String carPart) {
        this.carPart = carPart;
    }

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Transient
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
