package com.bialas.robert.sankhyacrud.Vehicles;

import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    private String make;
    private String model;
    private String color;
    private double mileage;
    private double motor;

    public Vehicle(){

    }

    public Vehicle(String make, String model, String color, double mileage, double motor){
        this.make = make;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.motor = motor;
    }

    public long getId() {
        return id;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "color")
    public String getColor() {
        return color;
    }
    @Access(AccessType.PROPERTY)
    @Column(name = "mileage")
    public double getMileage() {
        return mileage;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "motor")
    public double getMotor() {
        return motor;
    }


}
