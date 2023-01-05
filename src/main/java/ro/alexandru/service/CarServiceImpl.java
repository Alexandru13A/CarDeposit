package ro.alexandru.service;

import ro.alexandru.implementation.ICarService;
import ro.alexandru.implementation.ICarServiceImpl;
import ro.alexandru.model.Car;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarServiceImpl implements ICarServiceImpl {
    private ICarService iCarService;




    public  CarServiceImpl(ICarService iCarService) {
        this.iCarService = iCarService;
    }

    @Override
    public void addCar(Scanner sc) throws SQLException, ClassNotFoundException {
        Car car = new Car();
        System.out.println("Producer:");
        car.setProducer(sc.next());
        System.out.println("Model:");
        car.setModel(sc.next());
        System.out.println("Engine Capacity");
        car.setCapacity(sc.nextInt());
        iCarService.insertCar(car);

    }

    @Override
    public void searchCarById(Scanner sc) throws ClassNotFoundException {
        System.out.println("Insert the car id:");
        Long num = sc.nextLong();
        Car car;
        if ((car = iCarService.selectCarById(num)) != null) {
            System.out.println(car.getId() + "\t" + car.getProducer() + "\t" + car.getModel() + "\t" + car.getCapacity());

        } else {
            System.out.println("The car with this id doesn't exist");
        }

    }

    @Override
    public void deleteCar(Scanner sc) throws ClassNotFoundException {
        System.out.println("Insert the id of the car to delete");
        Long num = sc.nextLong();
        if(iCarService.selectCarById(num) != null){
            iCarService.deleteCarById(num);
        }else {
            System.out.println("Car with this id %s doesn't exist");
        }

    }

    @Override
    public void updateCar(Scanner sc) throws ClassNotFoundException {
        Car car = null;
        System.out.println("Insert the id of the car you want to update");
        Long num= sc.nextLong();
        car=iCarService.selectCarById(num);
        if(car == null){
            System.out.println("The car with this id don't exist");

        }else{
            System.out.println("Change the car information");
            System.out.println("The producer:");
            car.setProducer(sc.next());
            System.out.println("The model:");
            car.setModel(sc.next());
            System.out.println("The capacity of the car:");
            car.setCapacity(sc.nextInt());
            iCarService.updateCar(car);
        }

    }

    @Override
    public void selectAllCars(Scanner sc) throws ClassNotFoundException {
        ArrayList<Car> list = iCarService.getAllCars();
        System.out.println();
        for(Car car : list){
            System.out.println(car.getId()+"\t"+car.getProducer()+"\t"+car.getModel()+"\t"+car.getCapacity());
        }

    }
}
