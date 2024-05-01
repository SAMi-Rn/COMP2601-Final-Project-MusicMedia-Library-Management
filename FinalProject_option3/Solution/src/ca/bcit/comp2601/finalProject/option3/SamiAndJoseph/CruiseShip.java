package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The CruiseShip class that extends the PassengerVehicle and implements Bookable
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class CruiseShip extends PassengerVehicle implements Bookable{
    private final  String cruiseLiner;
    private String route;
    private String shipCaptain;

    /**
     * main constructor
     * @param vehicleCode String for the vehicle code
     * @param make string for the make of the vehicle
     * @param model string for the model of the vehicle
     * @param capacity int for the capacity of the vehicle
     * @param cruiseLiner String for the cruiseLiner
     * @param route  String for the route
     * @param shipCaptain  String for the shipCaptain name
     */
    public CruiseShip(String vehicleCode,
                      String make,
                      String model,
                      int capacity,
                      String cruiseLiner,
                      String route,
                      String shipCaptain) {
        super(vehicleCode, make, model, capacity);

        this.route = StringValidator.validString(route);
        this.cruiseLiner = StringValidator.validString(cruiseLiner);
        this.shipCaptain = StringValidator.validString(shipCaptain);
    }

    /**
     * getter for the cruiseLiner
     * @return cruiseLiner
     */
    public String getCruiseLiner() {
        return cruiseLiner;
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
     * getter for the shipCaptain
     * @return shipCaptain
     */
    public String getShipCaptain() {
        return shipCaptain;
    }
    /**
     * setter for the shipCaptain
     * @param shipCaptain
     */
    public void setShipCaptain(String shipCaptain) {
        this.shipCaptain = shipCaptain;
    }

    @Override
    public String book(String fullName) {
        return fullName + " is booked for room in " + cruiseLiner;
    }

    @Override
    public String destination() {
        return "Shipping to " + route;
    }

    @Override
    public String toString() {
        return super.toString() + '|' + cruiseLiner + '|' + route + '|' + shipCaptain;
    }
}
