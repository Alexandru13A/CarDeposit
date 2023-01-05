package ro.alexandru;

import ro.alexandru.implementation.ICarService;
import ro.alexandru.implementation.ICarServiceImpl;
import ro.alexandru.menu.CarMenu;
import ro.alexandru.service.CarService;
import ro.alexandru.service.CarServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ICarService Dao = new CarService();
        ICarServiceImpl service = new CarServiceImpl(Dao);
        Scanner sc = new Scanner(System.in);
        CarMenu menu = new CarMenu(service);

        menu.run(sc);


    }

}