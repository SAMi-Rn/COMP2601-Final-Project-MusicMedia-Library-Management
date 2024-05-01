package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The Bus class that extends the PassengerVehicle and implements Bookable
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class Bus extends PassengerVehicle implements Bookable
{
    private final String busLiner;
    private final String busType;
    private String route;
    private String busDriver;

    /**
     * main constructor
     * @param vehicleCode String for the vehicle code
     * @param make string for the make of the vehicle
     * @param model string for the model of the vehicle
     * @param capacity int for the capacity of the vehicle
     * @param busLiner string for the busLiner
     * @param busType string for the busType
     * @param route string for the route
     * @param busDriver string for the busDriver name
     */
    public Bus(String vehicleCode,
               String make,
               String model,
               int capacity,
               String busLiner,
               String busType,
               String route,
               String busDriver) {
        super(vehicleCode, make, model, capacity);

        this.route = StringValidator.validString(route);
        this.busLiner  = StringValidator.validString(busLiner);
        this.busType   = StringValidator.validString(busType);
        this.busDriver = StringValidator.validString(busDriver);
    }

    /**
     * getter for the busLiner
     * @return busLiner
     */
    public String getBusLiner() {
        return busLiner;
    }
    /**
     * getter for the busType
     * @return busType
     */
    public String getBusType() {
        return busType;
    }
    /**
     * getter for the route
     * @return route
     */
    public String getRoute() {
        return route;
    }

    /**
     * setter for the route
     * @param route
     */
    public void setRoute(String route) {
        this.route = StringValidator.validString(route);
    }
    /**
     * getter for the busDriver
     * @return busDriver
     */
    public String getBusDriver() {
        return busDriver;
    }
    /**
     * setter for the busDriver
     * @param busDriver
     */
    public void setBusDriver(String busDriver) {
        this.busDriver = busDriver;
    }

    @Override
    public String book(String fullName) {
        return fullName + " is booked route going t0 " + route;
    }

    @Override
    public String destination() {
        return "Riding bus to " + route;
    }

    @Override
    public String toString() {
        return super.toString() + '|' + busLiner + '|' + busType + '|' + route + '|' + busDriver;
    }
}
