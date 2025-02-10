
abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public int getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }

    public abstract double calculateFare(double distance);
}


interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}


class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

  
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

  
   public String getCurrentLocation() {
        return currentLocation;
    }

  
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; 
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

   
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

  
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; 
    }

   
    public String getCurrentLocation() {
        return currentLocation;
    }

   
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(201, "John", 10),
            new Bike(202, "Mike", 5),
            new Auto(203, "Raj", 8)
        };

        double distance = 15; 
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
           
        }
    }
}

