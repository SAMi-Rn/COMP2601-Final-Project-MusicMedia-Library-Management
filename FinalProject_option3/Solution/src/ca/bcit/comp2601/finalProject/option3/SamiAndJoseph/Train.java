package ca.bcit.comp2601.assignment2.option3.samAndJoseph;
/**
 * The Bus class that extends the PassengerVehicle and implements Bookable
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class Train extends PassengerVehicle implements Bookable
{
    private final String  railWayCompany;
    private final Boolean isHighSpeed;
    private String  cityDest;
    private String  trainDriver;

    /**
     * main constructor
     * @param vehicleCode String for the vehicle code
     * @param make string for the make of the vehicle
     * @param model string for the model of the vehicle
     * @param capacity int for the capacity of the vehicle
     * @param railWayCompany  String for a railWayCompany
     * @param isHighSpeed boolean to see if the train is high speed
     * @param cityDest String for the city destination
     * @param trainDriver String for the trainDriver name
     */
    public Train(String vehicleCode,
                 String make,
                 String model,
                 int capacity,
                 String railWayCompany,
                 Boolean isHighSpeed,
                 String cityDest,
                 String trainDriver) {
        super(vehicleCode, make, model, capacity);
        this.cityDest = StringValidator.validString(cityDest);
        this.isHighSpeed = isHighSpeed;
        this.trainDriver = StringValidator.validString(trainDriver);
        this.railWayCompany = StringValidator.validString(railWayCompany);
    }

    /**
     * getter for the railWayCompany
     * @return railWayCompany
     */
    public String getRailWayCompany() {
        return railWayCompany;
    }
    /**
     * getter for the isHighSpeed
     * @return isHighSpeed
     */
    public Boolean getHighSpeed() {
        return isHighSpeed;
    }
    /**
     * getter for the cityDest
     * @return cityDest
     */
    public String getCityDest() {
        return cityDest;
    }

    /**
     * setter for the cityDest
     * @param cityDest
     */
    public void setCityDest(String cityDest) {
        this.cityDest = StringValidator.validString(cityDest);
    }
    /**
     * getter for the trainDriver
     * @return trainDriver
     */
    public String getTrainDriver() {
        return trainDriver;
    }
    /**
     * setter for the trainDriver
     * @param trainDriver
     */
    public void setTrainDriver(String trainDriver) {
        this.trainDriver = trainDriver;
    }


    @Override
    public String book(String fullName) {
        if (isHighSpeed) {
            return fullName + " is booked for a high-speed train";
        }
        else {
            return fullName + " is booked for a regular train";
        }

    }

    @Override
    public String destination() {
        return "Riding train to " + cityDest;
    }

    @Override
    public String toString() {
        return super.toString() + '|' + railWayCompany + '|' + isHighSpeed + '|' + cityDest + '|' + trainDriver;
    }
}
