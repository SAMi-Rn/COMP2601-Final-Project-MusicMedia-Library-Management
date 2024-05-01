package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The PassengerVehicle class
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public abstract class PassengerVehicle
{
    private String vehicleCode;
    private String make;
    private String model;
    private int capacity;

    /**
     * main constructor
     * @param vehicleCode String for the vehicle code
     * @param make string for the make of the vehicle
     * @param model string for the model of the vehicle
     * @param capacity int for the capacity of the vehicle
     */
    public PassengerVehicle(final String vehicleCode,
                            final String make,
                            final String model,
                            final int capacity) {
        validCapacity(capacity);
        this.make  = StringValidator.validString(make);
        this.model = StringValidator.validString(model);
        this.capacity    = capacity;
        this.vehicleCode = StringValidator.validString(vehicleCode);
    }

    /**
     * validation for the Capacity of the vehicle
     * @param capacity
     */
    public static void validCapacity (final int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity!");
        }
    }

    /**
     * abstract method for the destination of the vehicle
     * @return String that explain where the vehicle is going to
     */
    public abstract String destination();

    /**
     * getter for the vehicleCode
     * @return vehicleCode
     */
    public String getVehicleCode() {
        return vehicleCode;
    }
    /**
     * getter for the make
     * @return make
     */
    public String getMake() {
        return make;
    }
    /**
     * getter for the model
     * @return model
     */
    public String getModel() {
        return model;
    }
    /**
     * getter for the capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return vehicleCode + '|' + make + '|' + model + '|' + capacity;
    }
}
