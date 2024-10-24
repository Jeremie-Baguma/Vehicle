// Vehicle Interface
public interface Vehicle {
    String getLicensePlate();
    String getVehicleType();
    double getRentalPricePerDay();
    void printVehicleDetails();
    void printRentedBy();
    void rentVehicle(Customer customer);
    void returnVehicle(Customer customer);
}
