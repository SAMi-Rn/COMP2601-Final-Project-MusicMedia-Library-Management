package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The AirPlane class that extends the PassengerVehicle and implements Bookable
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class AirPlane extends PassengerVehicle implements Bookable {
    private String flightDest;
    private String headPilot;

    /**
     * main constructor
     * @param vehicleCode String for the vehicle code
     * @param make string for the make of the vehicle
     * @param model string for the model of the vehicle
     * @param capacity int for the capacity of the vehicle
     * @param flightDest String for the flight Destination
     * @param headPilot String for the flight headPilot name
     */
    public AirPlane(final String vehicleCode,
                    final String make,
                    final String model,
                    final int capacity,
                    final String flightDest,
                    final String headPilot) {
        super(vehicleCode, make, model, capacity);
        this.flightDest = StringValidator.validString(flightDest);
        this.headPilot  = StringValidator.validString(headPilot);
    }

    /**
     * getter for the flightDest
     * @return flightDest
     */
    public String getFlightDest() {
        return flightDest;
    }

    /**
     * setter for the flightDest
     * @param flightDest
     */
    public void setFlightDest(String flightDest) {
        this.flightDest = StringValidator.validString(flightDest);
    }
    /**
     * getter for the headPilot
     * @return headPilot
     */
    public String getHeadPilot() {
        return headPilot;
    }
    /**
     * setter for the headPilot
     * @param headPilot
     */
    public void setHeadPilot(String headPilot) {
        this.headPilot = headPilot;
    }

    @Override
    public String book(String fullName) {
        return fullName + " is booked for " + getVehicleCode();
    }

    @Override
    public String destination() {
        return "Flying to " + flightDest;
    }

    @Override
    public String toString() {
        return super.toString() + '|' + flightDest + '|' + headPilot;
    }
}

