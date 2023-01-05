package ro.alexandru.implementation;

import ro.alexandru.model.Car;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICarService {

    ArrayList<Car> getAllCars() throws ClassNotFoundException;
    Car selectCarById(Long id) throws ClassNotFoundException;

    void insertCar(Car car) throws ClassNotFoundException, SQLException;

    void updateCar(Car car) throws ClassNotFoundException;

    void deleteCarById(Long id) throws ClassNotFoundException;


}
