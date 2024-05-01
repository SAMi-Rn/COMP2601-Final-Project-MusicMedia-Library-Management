package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * The TravelAgency class
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class TravelAgency {
    private final String name;
    private final Map<String, Person>    passengerDB;
    private final List<PassengerVehicle> vehicleDB;

    /**
     * main constructor
     * @param name String name of the travelAgency
     */
    public TravelAgency(final String name) {
        this.name = StringValidator.validString(name);
        passengerDB = new HashMap<>();
        vehicleDB = new ArrayList<>();
    }

    /**
     * getter for the name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * getter for the passengerDB
     * @return passengerDB
     */
    public Map<String, Person> getTravellerDB() {
        return passengerDB;
    }
    /**
     * getter for the vehicleDB
     * @return vehicleDB
     */
    public List<PassengerVehicle> getVehicleDB() {
        return vehicleDB;
    }

    /**
     * adding passenger to the passengerDB map
     * @param vehicleCode for the map key
     * @param passenger for the mape value
     */
    public void addPassenger (final String vehicleCode,
                              final Person passenger)
    {
        passengerDB.put(vehicleCode, passenger);
    }

    /**
     * adding passenger to the vehicleDB list
     * @param vehicle to be added to the list
     */
    public void addVehicleDB (final PassengerVehicle vehicle)
    {
        vehicleDB.add(vehicle);
    }
}