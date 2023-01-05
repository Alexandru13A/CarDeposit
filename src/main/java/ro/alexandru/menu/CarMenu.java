package ro.alexandru.menu;

import ro.alexandru.implementation.ICarServiceImpl;
import ro.alexandru.service.CarService;
import ro.alexandru.service.CarServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class CarMenu {

    private ICarServiceImpl iCarServiceImpl;

    public CarMenu(ICarServiceImpl iCarServiceImpl) {
        this.iCarServiceImpl = iCarServiceImpl;
    }

    public void run(Scanner sc) throws ClassNotFoundException, SQLException {
        boolean flag = true;
        String str = "1.add car 2.Find by id , 3.delete car , 4.update car , 5.find all cars ,6. back";
        int menu;
        while (flag) {
            System.out.println(str);
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    iCarServiceImpl.addCar(sc);
                    break;
                case 2:
                    iCarServiceImpl.searchCarById(sc);
                    break;
                case 3:
                    iCarServiceImpl.deleteCar(sc);
                    break;
                case 4:
                    iCarServiceImpl.updateCar(sc);
                    break;
                case 5:
                    iCarServiceImpl.selectAllCars(sc);
                    break;
                case 6:
                    flag = false;


            }
        }

    }
}
