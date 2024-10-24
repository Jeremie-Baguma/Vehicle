//Problem:
//You are tasked with designing a vehicle rental system. The system will manage different types of vehicles (cars and motorcycles) and customers who can rent these vehicles. You will need to implement:
//Vehicle Interface:
//
//Define a Vehicle interface with the following methods:
//String getLicensePlate()
//String getVehicleType()
//double getRentalPricePerDay()
//void printVehicleDetails()
//void printRentedBy()
//void rentVehicle(Customer customer)
//void returnVehicle(Customer customer)
//Car and Motorcycle Classes:
//Create two abstract classes, Car and Motorcycle, that implement the Vehicle interface. These classes should:
//Implement the necessary methods from the Vehicle interface.
//Store basic vehicle-related information such as license plate, vehicle type, and rental price.
//Maintain a list of customers who have rented the vehicles using an array or ArrayList.
//Customer Class:
//Define a Customer class to store basic customer information such as name, age, and customer ID.
//Vehicle Implementations:
//Create two concrete classes:
//Sedan, which extends Car.
//SportBike, which extends Motorcycle.
//Each class should define specific vehicle-related fields and implement any abstract methods.

import java.util.ArrayList;

// Car Abstract Class
abstract class Car implements Vehicle {
    protected String licensePlate;
    protected String vehicleType;
    protected double rentalPrice;
    protected ArrayList<Customer> rentedBy = new ArrayList<>();

    public Car(String licensePlate, double rentalPrice) {
        this.licensePlate = licensePlate;
        this.vehicleType = "Car";
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public double getRentalPricePerDay() {
        return rentalPrice;
    }

    @Override
    public void printVehicleDetails() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price per Day: $" + rentalPrice);
    }

    @Override
    public void printRentedBy() {
        if (rentedBy.isEmpty()) {
            System.out.println("No customers have rented this vehicle.");
        } else {
            System.out.println("Rented by:");
            for (Customer customer : rentedBy) {
                System.out.println(customer.getCustomerName());
            }
        }
    }

    @Override
    public void rentVehicle(Customer customer) {
        rentedBy.add(customer);
    }

    @Override
    public void returnVehicle(Customer customer) {
        rentedBy.remove(customer);
    }
}

// Motorcycle Abstract Class
abstract class Motorcycle implements Vehicle {
    protected String licensePlate;
    protected String vehicleType;
    protected double rentalPrice;
    protected ArrayList<Customer> rentedBy = new ArrayList<>();

    public Motorcycle(String licensePlate, double rentalPrice) {
        this.licensePlate = licensePlate;
        this.vehicleType = "Motorcycle";
        this.rentalPrice = rentalPrice;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public double getRentalPricePerDay() {
        return rentalPrice;
    }

    @Override
    public void printVehicleDetails() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Price per Day: $" + rentalPrice);
    }

    @Override
    public void printRentedBy() {
        if (rentedBy.isEmpty()) {
            System.out.println("No customers have rented this vehicle.");
        } else {
            System.out.println("Rented by:");
            for (Customer customer : rentedBy) {
                System.out.println(customer.getCustomerName());
            }
        }
    }

    @Override
    public void rentVehicle(Customer customer) {
        rentedBy.add(customer);
    }

    @Override
    public void returnVehicle(Customer customer) {
        rentedBy.remove(customer);
    }
}

// Concrete Sedan Class
class Sedan extends Car {
    public Sedan(String licensePlate, double rentalPrice) {
        super(licensePlate, rentalPrice);
    }
}

// Concrete SportBike Class
class SportBike extends Motorcycle {
    public SportBike(String licensePlate, double rentalPrice) {
        super(licensePlate, rentalPrice);
    }
}

// Customer Class
class Customer {
    private String customerName;
    private int age;
    private String customerId;

    public Customer(String customerName, int age, String customerId) {
        this.customerName = customerName;
        this.age = age;
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAge() {
        return age;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// Main Class to Test the System
public class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("John Doe", 30, "C001");
        Customer customer2 = new Customer("Jane Smith", 25, "C002");

        // Create vehicles
        Vehicle sedan = new Sedan("ABC123", 50.0);
        Vehicle bike = new SportBike("XYZ789", 30.0);

        // Print vehicle details
        System.out.println("Sedan Details:");
        sedan.printVehicleDetails();
        sedan.rentVehicle(customer1); // Rent the sedan to customer1
        sedan.printRentedBy();

        System.out.println("\nSportBike Details:");
        bike.printVehicleDetails();
        bike.rentVehicle(customer2); // Rent the bike to customer2
        bike.printRentedBy();

        // Return the vehicles
        sedan.returnVehicle(customer1);
        bike.returnVehicle(customer2);
        System.out.println("\nAfter Returning Vehicles:");
        sedan.printRentedBy();
        bike.printRentedBy();
    }
}
