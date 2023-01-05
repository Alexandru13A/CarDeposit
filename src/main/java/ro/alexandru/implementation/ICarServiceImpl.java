package ro.alexandru.implementation;

import java.sql.SQLException;
import java.util.Scanner;

public interface ICarServiceImpl {
    void addCar(Scanner sc) throws SQLException, ClassNotFoundException;
    void searchCarById(Scanner sc) throws ClassNotFoundException;
    void deleteCar(Scanner sc) throws ClassNotFoundException;
    void updateCar(Scanner sc) throws ClassNotFoundException;
    void selectAllCars(Scanner sc) throws ClassNotFoundException;


}
