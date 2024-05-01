import ca.bcit.comp2601.assignment2.option3.samAndJoseph.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * The TravelAgencyTest class
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class TravelAgencyTest
{
    /**
     * test the name of the travelAgency
     * @throws IllegalArgumentException
     */
    @Test
    void testGoodName()
    {
        TravelAgency t;

        t = new TravelAgency("VanCity");
        assertThat(t.getName(),equalTo("VanCity"));

    }

    /**
     * test the exception for travelAgency name
     */
    @Test
    void testBadName()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->{
            TravelAgency  t = new TravelAgency(null);
        });
        assertTrue(ex.getMessage().equals("Invalid Input!"));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            TravelAgency  t = new TravelAgency("");
        });
        assertTrue(ex.getMessage().equals("Invalid Input!"));

    }

    /**
     * test the PassengerDB Map
     */
    @Test
    void testGoodPassengerDB()
    {
        TravelAgency t;
        t = new TravelAgency("VanCity");
        Person p  = new Person("Jason", "Wilder","adult");
        t.addPassenger("AP-0001",p);
        assertTrue(t.getTravellerDB().containsKey("AP-0001") && t.getTravellerDB().get("AP-0001") != null);

    }

    /**
     * test the vehicleDB list
     */
    @Test
    void testGoodVehicleDB()
    {

        TravelAgency t;
        t = new TravelAgency("VanCity");
        AirPlane a = new AirPlane("AP-0001", "Boeing", "37-MAX",100,"YVR",
                "Jason Wilder");
        t.addVehicleDB(a);

        assertTrue(String.valueOf(t.getVehicleDB()).equals("[AP-0001|Boeing|37-MAX|100|YVR|Jason Wilder]"));
    }

    /**
     * test the Person constructor
     */
    @Test
    void testGoodPerson()
    {
        Person p  = new Person("Jason", "Wilder","adult");
        assertThat(p.getFirstName(),equalTo("Jason"));
        assertThat(p.getLastName(),equalTo("Wilder"));
        assertThat(p.getAgeGroup(),equalTo("adult"));
    }

    /**
     * test the Person exception for the arguments
     */
    @Test
    void testBadPerson()
    {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p1 = new Person("", "Wilder","adult");
        });
        assertTrue(ex1.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p2 = new Person(null, "Wilder","adult");
        });
        assertTrue(ex2.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p3 = new Person("Jason", "","adult");
        });
        assertTrue(ex3.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p4 = new Person("Jason", null,"adult");
        });
        assertTrue(ex4.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex5 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p5 = new Person("Jason", "Wilder","");
        });
        assertTrue(ex5.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex6 = assertThrows(IllegalArgumentException.class, ()->{
            Person  p6= new Person("Jason", "Wilder",null);
        });
        assertTrue(ex6.getMessage().equals("Invalid Input!"));
    }

    /**
     * test the Airplane constructor
     */
    @Test
    void testGoodAirplane()
    {

        AirPlane a = new AirPlane("AP-0001", "Boeing", "37-MAX",100,"YVR","Jason Wilder");
        assertThat(a.getVehicleCode(),equalTo("AP-0001"));
        assertThat(a.getMake(),equalTo("Boeing"));
        assertThat(a.getModel(),equalTo("37-MAX"));
        assertThat(a.getCapacity(),equalTo(100));
        assertThat(a.getFlightDest(),equalTo("YVR"));
        assertThat(a.getHeadPilot(),equalTo("Jason Wilder"));
    }
    /**
     * test the Airplane exception for the arguments
     */
    @Test
    void testBadPassengerVehicleAndAirplane()
    {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a1 = new AirPlane("", "Boeing", "37-MAX",100,"YVR","Jason Wilder");
        });
        assertTrue(ex1.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a2 = new AirPlane(null, "Boeing", "37-MAX",100,"YVR","Jason Wilder");
        });
        assertTrue(ex2.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a3 = new AirPlane("AP-0001", "", "37-MAX",100,"YVR","Jason Wilder");
        });
        assertTrue(ex3.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a4 = new AirPlane("AP-0001", null, "37-MAX",100,"YVR","Jason Wilder");
        });
        assertTrue(ex4.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex5 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a5 = new AirPlane("AP-0001", "Boeing", "",100,"YVR","Jason Wilder");
        });
        assertTrue(ex5.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex6 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a6 = new AirPlane("AP-0001", "Boeing", null,100,"YVR","Jason Wilder");
        });
        assertTrue(ex6.getMessage().equals("Invalid Input!"));
        IllegalArgumentException ex7 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a7 = new AirPlane("AP-0001", "Boeing", "37-MAX",-100,"YVR","Jason Wilder");
        });
        assertTrue(ex7.getMessage().equals("Invalid Capacity!"));
        IllegalArgumentException ex8 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a8 = new AirPlane("AP-0001", "Boeing", "37-MAX",100,"","Jason Wilder");
        });
        assertTrue(ex8.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex9 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a9 = new AirPlane("AP-0001", "Boeing", "37-MAX",100,null,"Jason Wilder");
        });
        assertTrue(ex9.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex10 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a10 = new AirPlane("AP-0001", "Boeing", "37-MAX",100,"YVR","");
        });
        assertTrue(ex10.getMessage().equals("Invalid Input!"));
        IllegalArgumentException ex11 = assertThrows(IllegalArgumentException.class, ()->{
            AirPlane a11 = new AirPlane("AP-0001", "Boeing", "37-MAX",100,"YVR",null);
        });
        assertTrue(ex11.getMessage().equals("Invalid Input!"));
    }
    /**
     * test the Bus constructor
     */
    @Test
    void testGoodBus()
    {
        Bus b = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                "Coach","Seattle","Kevin Cudihee");
        assertThat(b.getVehicleCode(),equalTo("BS-0004"));
        assertThat(b.getMake(),equalTo("Hino"));
        assertThat(b.getModel(),equalTo("HINO500"));
        assertThat(b.getCapacity(),equalTo(50));
        assertThat(b.getBusLiner(),equalTo("Greyhound"));
        assertThat(b.getBusType(),equalTo("Coach"));
        assertThat(b.getRoute(),equalTo("Seattle"));
        assertThat(b.getBusDriver(),equalTo("Kevin Cudihee"));
    }
    /**
     * test the Bus exception for the arguments
     */
    @Test
    void testBadBus()
    {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b1 = new Bus("BS-0004", "Hino", "HINO500",50,"",
                    "Coach","Seattle","Kevin Cudihee");
        });
        assertTrue(ex1.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b2 = new Bus("BS-0004", "Hino", "HINO500",50,null,
                    "Coach","Seattle","Kevin Cudihee");
        });
        assertTrue(ex2.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b3 = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    "","Seattle","Kevin Cudihee");
        });
        assertTrue(ex3.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b4 = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    null,"Seattle","Kevin Cudihee");
        });
        assertTrue(ex4.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex5 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b5 = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    "Coach","","Kevin Cudihee");
        });
        assertTrue(ex5.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex6 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b6 = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    "Coach",null,"Kevin Cudihee");
        });
        assertTrue(ex6.getMessage().equals("Invalid Input!"));
        IllegalArgumentException ex7 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b7 = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    "Coach","Seattle"," ");
        });
        assertTrue(ex7.getMessage().equals("Invalid Input!"));
        IllegalArgumentException ex8 = assertThrows(IllegalArgumentException.class, ()->{
            Bus b = new Bus("BS-0004", "Hino", "HINO500",50,"Greyhound",
                    "Coach","Seattle",null);
        });
        assertTrue(ex8.getMessage().equals("Invalid Input!"));
    }
    /**
     * test the CruiseShip constructor
     */
    @Test
    void testGoodCruiseShip()
    {

        CruiseShip c = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"BCIT Liner",
                "Alaska","Paul Mills");
        assertThat(c.getVehicleCode(),equalTo("CS-0002"));
        assertThat(c.getMake(),equalTo("Hyundai"));
        assertThat(c.getModel(),equalTo("M.V.Bcit"));
        assertThat(c.getCapacity(),equalTo(10000));
        assertThat(c.getCruiseLiner(),equalTo("BCIT Liner"));
        assertThat(c.getRoute(),equalTo("Alaska"));
        assertThat(c.getShipCaptain(),equalTo("Paul Mills"));

    }
    /**
     * test the CruiseShip exception for the arguments
     */
    @Test
    void testBadCruiseShip()
    {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c1 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"",
                    "Alaska","Paul Mills");
        });
        assertTrue(ex1.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c2 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,null,
                    "Alaska","Paul Mills");
        });
        assertTrue(ex2.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex3 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c3 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"BCIT Liner",
                    "","Paul Mills");
        });
        assertTrue(ex3.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c4 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"BCIT Liner",
                    null,"Paul Mills");
        });
        assertTrue(ex4.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex5 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c5 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"BCIT Liner",
                    "Alaska","");
        });
        assertTrue(ex5.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex6 = assertThrows(IllegalArgumentException.class, ()->{
            CruiseShip c6 = new CruiseShip("CS-0002", "Hyundai", "M.V.Bcit",10000,"BCIT Liner",
                    "Alaska",null);
        });
        assertTrue(ex6.getMessage().equals("Invalid Input!"));
    }
    /**
     * test the Train constructor
     */
    @Test
    void testGoodTrain()
    {

        Train t = new Train("TR-0003", "Bombardier", "Adirondack",300,"Amtrak",
                true,"Seattle","Bob Langelaan");
        assertThat(t.getVehicleCode(),equalTo("TR-0003"));
        assertThat(t.getMake(),equalTo("Bombardier"));
        assertThat(t.getModel(),equalTo("Adirondack"));
        assertThat(t.getCapacity(),equalTo(300));
        assertThat(t.getRailWayCompany(),equalTo("Amtrak"));
        assertThat(t.getHighSpeed(),equalTo(true));
        assertThat(t.getCityDest(),equalTo("Seattle"));
        assertThat(t.getTrainDriver(),equalTo("Bob Langelaan"));

    }
    /**
     * test the Train exception for the arguments
     */
    @Test
    void testBadTrain() {
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> {
            Train t1 = new Train("TR-0003", "Bombardier", "Adirondack", 300, "",
                    true, "Seattle", "Bob Langelaan");
        });
        assertTrue(ex1.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> {
            Train t2 = new Train("TR-0003", "Bombardier", "Adirondack", 300, null,
                    true, "Seattle", "Bob Langelaan");
        });
        assertTrue(ex2.getMessage().equals("Invalid Input!"));


        IllegalArgumentException ex4 = assertThrows(IllegalArgumentException.class, () -> {
            Train t4 = new Train("TR-0003", "Bombardier", "Adirondack", 300, "Amtrak",
                    true, "", "Bob Langelaan");
        });
        assertTrue(ex4.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex5 = assertThrows(IllegalArgumentException.class, () -> {
            Train t5 = new Train("TR-0003", "Bombardier", "Adirondack", 300, "Amtrak",
                    true, null, "Bob Langelaan");
        });
        assertTrue(ex5.getMessage().equals("Invalid Input!"));

        IllegalArgumentException ex6 = assertThrows(IllegalArgumentException.class, () -> {
            Train t = new Train("TR-0003", "Bombardier", "Adirondack", 300, "Amtrak",
                    true, "Seattle", "");
        });
        assertTrue(ex6.getMessage().equals("Invalid Input!"));
        IllegalArgumentException ex7 = assertThrows(IllegalArgumentException.class, () -> {
            Train t7 = new Train("TR-0003", "Bombardier", "Adirondack", 300, "Amtrak",
                    true, "", null);
        });
        assertTrue(ex7.getMessage().equals("Invalid Input!"));
    }

}