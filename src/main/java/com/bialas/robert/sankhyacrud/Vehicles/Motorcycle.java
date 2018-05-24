package com.bialas.robert.sankhyacrud.Vehicles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Motorcycle extends Vehicle{

    public Motorcycle(){

    }

    public Motorcycle(String make, String model, String color, double mileage, double motor){
    super(make, model, color, mileage, motor);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public String getMake() {
        return super.getMake();
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public void setMake(String make) {
        super.setMake(make);
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public void setMileage(double mileage) {
        super.setMileage(mileage);
    }

    @Override
    public void setMotor(double motor) {
        super.setMotor(motor);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public double getMileage() {
        return super.getMileage();
    }

    @Override
    public double getMotor() {
        return super.getMotor();
    }
}
