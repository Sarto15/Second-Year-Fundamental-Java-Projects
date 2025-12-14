/**
 *
 * @author Samuil Halachev
 * @studentID 501315102
 */

package coe318.lab7;


public class Car extends Vehicle {
    private boolean automatic;

    public Car(String plateNumber, String model, int year, boolean automatic) {
        super(plateNumber, model, year);
        this.automatic = automatic;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Car: " + super.toString() +
               (automatic ? " [Automatic]" : " [Manual]");
    }

    
    @Override
    public double calculateRentalPrice(int days) 
    {
        double dailyRate = automatic ? 65.0 : 55.0;
        return dailyRate * days;
    }

  
    @Override
    public double calculateInsurancePremium(int days) 
    {
        return getBaseInsuranceRate() * 1.1 * days;
    }


    // Overloaded version with GPS option
    public double calculateRentalPrice(int days, boolean gpsIncluded) {
        double base = calculateRentalPrice(days);
        if (gpsIncluded) {
            base += 10.0 * days; // GPS daily fee
        }
        return base;
    }

    // Static method HIDING superclass static method
    public static void printVehicleType() {
        System.out.println("Car");
    }
    
}
