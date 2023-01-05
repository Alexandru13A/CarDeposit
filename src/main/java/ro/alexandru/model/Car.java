package ro.alexandru.model;

import lombok.*;

import javax.persistence.*;


public class Car {


    private Long id;
    private String producer;
    private String model;
    private int capacity;

    public Car() {
        super();
    }

    public Car(Long id,String producer, String model, int capacity) {
        this.id=id;
        this.producer = producer;
        this.model = model;
        this.capacity = capacity;
    }



    public Long getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
