package ro.alexandru.service;

import ro.alexandru.DBconnection.DB;
import ro.alexandru.implementation.ICarService;
import ro.alexandru.model.Car;

import java.sql.*;
import java.util.ArrayList;

public class CarService implements ICarService {

    private DB db;

    public void CarService() {

    }

    @Override
    public ArrayList<Car> getAllCars() throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM cars";
        ArrayList<Car> list = new ArrayList<Car>();
        try {
            conn = DB.connectToDatabase();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong(1);
                String producer = rs.getString(2);
                String model = rs.getString(3);
                int capacity = rs.getInt(4);
                Car car = new Car(id,producer, model, capacity);
                list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Car selectCarById(Long id) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Car car = null;

        String sql =  "SELECT * FROM `cardeposit`.`cars`  WHERE car_id = ?";

        try {
            conn = DB.connectToDatabase();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                car = new Car(rs.getLong(1),rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }


    @Override
    public void insertCar(Car car) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO `cardeposit`.`cars` (`car_producer`, `car_model`, `car_capacity`) VALUES (?,?,?);";
        try {
            conn = DB.connectToDatabase();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, car.getProducer());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getCapacity());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stmt.close();
        conn.close();

    }

    @Override
    public void updateCar(Car car) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;


        String sql = "UPDATE cars SET car_producer =?, car_model=?, car_capacity=? WHERE car_id = ?";

        try {
            conn = DB.connectToDatabase();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, car.getProducer());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getCapacity());
            stmt.setLong(4,car.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCarById(Long id) throws ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM cars WHERE car_id = ?";
        try {
            conn = DB.connectToDatabase();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
