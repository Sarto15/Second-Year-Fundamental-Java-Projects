/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */

package coe318.lab7;


public class Truck  extends Vehicle {
    private double loadCapacityInTons;

    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
        super(plateNumber, model, year);
        this.loadCapacityInTons = loadCapacityInTons;
    }

    public double getLoadCapacityInTons() 
    {
        return loadCapacityInTons;
    }

    @Override
    public String toString() 
    {
        return "Truck: " + super.toString() +
               " [Capacity: " + loadCapacityInTons + " tons]";
    }

    @Override
    public double calculateRentalPrice(int days) 
    {
        double dailyRate = 150.0 + 5.0 * loadCapacityInTons;
        return dailyRate * days;
    }

    @Override
    public double calculateInsurancePremium(int days) 
    {
        return getBaseInsuranceRate() * 2.0 * days;
    }

    public static void printVehicleType() {
        System.out.println("Truck");
    }
    
}
