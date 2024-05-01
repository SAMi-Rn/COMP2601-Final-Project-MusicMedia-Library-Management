package ca.bcit.comp2601.assignment2.option3.samAndJoseph;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * The AirPlane class that extends the PassengerVehicle and implements Bookable
 * @author Sam Roudgarian and Joseph Tyronne Salto
 * @version 1.0
 * created on July 5, 2022
 */
public class AgencyGUI extends JFrame {
    private final TravelAgency agency;

    private static final int VEHICLE_CODE;
    private static final int MAKE;
    private static final int MODEL;
    private static final int CAPACITY;
    private static final int BEGINING_CHAR;
    private static final int VEHICLE_ID_LEN;
    private static final int FLIGHT_DEST;
    private static final int PILOT;
    private static final int CRUISE_LINER;
    private static final int CRUISE_ROUTE;
    private static final int SHIP_CAPTAIN;
    private static final int RAIL_WAY_COMP;
    private static final int HIGH_SPEED;
    private static final int CITY_DEST;
    private static final int TRAIN_DRIVER;
    private static final int BUS_LINER;
    private static final int BUS_TYPE;
    private static final int ROUTES;
    private static final int BUS_DRIVER;
    private static final int FIRST_NAME;
    private static final int LAST_NAME;
    private static final int AGE_GROUP;
    private static final int ARR_BEGINNING;
    private static final int STARTING_SERIAL;

    static
    {
        STARTING_SERIAL = 1;
        ARR_BEGINNING   = 0;
        BEGINING_CHAR   = 0;
        VEHICLE_ID_LEN  = 2;
        VEHICLE_CODE    = 0;
        MAKE     = 1;
        MODEL    = 2;
        CAPACITY = 3;
        FLIGHT_DEST  = 4;
        PILOT = 5;
        CRUISE_LINER  = 4;
        CRUISE_ROUTE  = 5;
        SHIP_CAPTAIN  = 6;
        RAIL_WAY_COMP = 4;
        HIGH_SPEED    = 5;
        CITY_DEST = 6;
        TRAIN_DRIVER  = 7;
        BUS_LINER  = 4;
        BUS_TYPE   = 5;
        ROUTES     = 6;
        BUS_DRIVER = 7;
        FIRST_NAME = 1;
        LAST_NAME  = 2;
        AGE_GROUP  = 3;
    }

    {
        agency = new TravelAgency("BCIT");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);
        setJMenuBar(menuBarInterface());
        setVisible(true);
        try {
            passengerList();
            vehicleList();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor to initialize the travel agency's GUI app.
     */
    public AgencyGUI() {
        super("Music Media");
    }

    /**
     * Creates a functional menu bar for the travel agency app.
     * @return the fully functional menu bar.
     */
    public JMenuBar menuBarInterface() {
        final JMenuBar menuBar;
        menuBar = new JMenuBar();

        // File Menu
        final JMenu menuFile;
        menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menuFile);

        // File Menu items
        final JMenuItem mFSave;
        mFSave = new JMenuItem("Save Data");
        mFSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mFSave.addActionListener(event -> {
            final int option;

            option = JOptionPane.showConfirmDialog(this,"Do you want to save changes?", "Save Data?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                File file;
                file = new File("Passenger_list.txt");

                try {
                    FileWriter writer = new FileWriter(file);

                    agency.getTravellerDB().keySet().forEach(key-> {
                        try {
                            writer.write(key + '|' + agency.getTravellerDB().get(key).toString() +"\n");
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        menuFile.add(mFSave);

        final JMenuItem mFExit;
        mFExit = new JMenuItem("Exit");
        mFExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        mFExit.addActionListener(event-> System.exit(0));
        menuFile.add(mFExit);

        // Agency Menu
        final JMenu menuAgency;
        menuAgency = new JMenu("Agency");
        menuAgency.setMnemonic(KeyEvent.VK_A);
        menuBar.add(menuAgency);

        // Agency Menu Item
        final JMenuItem mAPassenger;
        mAPassenger = new JMenuItem("Passenger");
        mAPassenger.addActionListener(event -> {
            agencyDialog("passenger");
        });
        menuAgency.add(mAPassenger);

        final JMenuItem mAVehicle;
        mAVehicle = new JMenuItem("Vehicle");
        mAVehicle.addActionListener(event -> {
            agencyDialog("vehicle");
        });
        menuAgency.add(mAVehicle);

        final JMenuItem mAPassengerAssign;
        mAPassengerAssign = new JMenuItem("New Passenger");
        mAPassengerAssign.addActionListener(event -> passengerEditDialog(null, true));
        menuAgency.add(mAPassengerAssign);

        //JOptionPane.showMessageDialog(menuAbout, "A project by\nJoseph Tyronne Salto\nand\nSam Roudgarian");
        // Agency Menu
        final JMenu menuAbout;
        menuAbout = new JMenu("About");
        menuAbout.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(menuAbout, "A project by\nJoseph Tyronne Salto\nand\nSam Roudgarian");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        menuBar.add(menuAbout);

        return menuBar;
    }

    /**
     * Creates a dialog box that can be used around the app that can display a list of the content in Travel Agency Database.
     *
     * @param agencyMenuOption the menu item in the menu toolbar.
     * @return a functional dialog box.
     */
    public JDialog agencyDialog(String agencyMenuOption)
    {
        final DefaultListModel<String> aModelList;
        final JList<String> aList;

        aModelList = new DefaultListModel<>();
        aList = new JList<>(aModelList);

        final JDialog aDialog;
        final JPanel  aPanel;
        final JPanel  aButtonPanel;
        final JButton aButton;
        final JScrollPane aScrollPane;

        aDialog      = new JDialog(this, "Library Contents");//NUll for now
        aScrollPane  = new JScrollPane(aList);
        aPanel       = new JPanel();
        aButton      = new JButton("OK");
        aButtonPanel = new JPanel();


        // aScrollPane
        aScrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // aButton
        aButton.addActionListener(event->{
            aDialog.dispose();
        });

        // aButtonPanel
        aButtonPanel.setLayout(new BoxLayout(aButtonPanel, BoxLayout.LINE_AXIS));
        aButtonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        aButtonPanel.add(Box.createHorizontalGlue());
        aButtonPanel.add(aButton);

        // aPanel
        aPanel.setLayout(new BoxLayout(aPanel,BoxLayout.Y_AXIS));
        aPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        aPanel.add(aScrollPane);
        aPanel.add(aButtonPanel);

        // aDialog
        aDialog.setLocationRelativeTo(this);
        aDialog.setLocation(500,300);
        aDialog.add(aPanel);
        aDialog.setSize(700, 450);
        aDialog.setVisible(true);

        if (agencyMenuOption.equalsIgnoreCase("vehicle")) {
            aModelList.clear();

            agency.getVehicleDB().forEach(vehicle -> aModelList.addElement(vehicle.toString()));

            aList.addMouseListener( new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(aDialog, agency.getVehicleDB().stream().
                            filter(n ->
                                    n.getVehicleCode().equalsIgnoreCase(Arrays.stream(aList.getSelectedValue()
                                            .split("\\|")).toList().get(ARR_BEGINNING)))
                            .toList().get(ARR_BEGINNING).destination());
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
        else if (agencyMenuOption.equalsIgnoreCase("passenger")) {
            aModelList.clear();

            agency.getTravellerDB().keySet().stream().toList()
                    .forEach(k -> aModelList.addElement(k + '|' +agency.getTravellerDB().get(k)));

            aList.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    passengerEditDialog(Arrays.stream(aList.getSelectedValue().split("\\|")).toList().get(ARR_BEGINNING), false);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });

        }

        return aDialog;
    }

    /**
     * Creates a dialog box that ables to edit or create a new passenger
     *
     * @param key The key in the Map in Travel Agency
     * @param isEditable true to make the content editable, false if not.
     * @returna a functional dialog box for editing and creating passenger info
     */
    public JDialog passengerEditDialog(final String  key,
                                       final boolean isEditable)
    {
        final JDialog editDialog;
        final Person person;
        editDialog = new JDialog(this, "Passenger Info");
        person = agency.getTravellerDB().get(key);

        // Setting up the edit panel for label and text field.
        final JPanel  editPanel;
        editPanel = new JPanel();
        editPanel.setLayout(new BoxLayout(editPanel,BoxLayout.Y_AXIS));
        editPanel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));

        //Setting up the panel for editing fields and its label
        final JPanel editContentPanel;
        editContentPanel = new JPanel();

        JTextField vCodeField = new JTextField(key,40);
        JTextField fNameField = new JTextField(40);
        JTextField lNameField = new JTextField(40);
        JTextField ageGroupField = new JTextField(40);

        JLabel vCodeTxt = new JLabel("Vehicle Code",SwingConstants.CENTER);
        JLabel fNameTxt = new JLabel("First Name",SwingConstants.CENTER);
        JLabel lNameTxt = new JLabel("Last Name",SwingConstants.CENTER);
        JLabel ageGroupTxt = new JLabel("Age Group",SwingConstants.CENTER);

        if (isEditable)
        {
            String  string;
            boolean isExist;

            string  = null;
            isExist = false;

            for (int i = STARTING_SERIAL; !isExist; i++) {
                string  = String.format("NA-0000-%3d", i).replace(' ', '0');

                if(!agency.getTravellerDB().keySet().stream().map(String::toLowerCase).toList().contains(string.toLowerCase())) {
                    isExist = true;
                }
            }

            vCodeField.setText(string);
            vCodeField.setEditable(false);
        }
        else {
            vCodeField.setText(key);
            fNameField.setText(person.getFirstName());
            lNameField.setText(person.getLastName());
            ageGroupField.setText(person.getAgeGroup());

            fNameField.setEditable(false);
            lNameField.setEditable(false);
            ageGroupField.setEditable(false);
        }

        editContentPanel.setLayout(new GridLayout(7,2));
        editContentPanel.add(vCodeTxt);
        editContentPanel.add(vCodeField);
        editContentPanel.add(fNameTxt);
        editContentPanel.add(fNameField);
        editContentPanel.add(lNameTxt);
        editContentPanel.add(lNameField);
        editContentPanel.add(ageGroupTxt);
        editContentPanel.add(ageGroupField);

        // Setting up buttons for the dialog
        final JPanel buttonPanel;
        buttonPanel = new JPanel();

        JButton cancelButton = new JButton("Cancel");
        JButton clearButton = new JButton("Clear");
        JButton saveButton = new JButton("Save");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttonPanel.add(clearButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(cancelButton);

        cancelButton.addActionListener(event->
        {
            editDialog.dispose();
        });

        clearButton.addActionListener(event->
        {
            vCodeField.setText("");
        });

        saveButton.addActionListener(event->
        {
            if (agency.getTravellerDB().keySet().stream().map(String::toLowerCase).toList().contains(vCodeField.getText().toLowerCase())) {
                JOptionPane.showMessageDialog(editDialog,"File Already Exist");
            }
            else {
                agency.addPassenger(vCodeField.getText(), new Person(fNameField.getText(), lNameField.getText(), ageGroupField.getText()));

                agency.getTravellerDB().remove(key);

                editDialog.dispose();
            }
        });

        deleteButton.addActionListener(event->
        {
            if (agency.getTravellerDB().keySet().stream().map(String::toLowerCase).toList().contains(vCodeField.getText().toLowerCase())) {
                agency.getTravellerDB().remove(key);
            }
            else {
                JOptionPane.showMessageDialog(editDialog,"File Doesn't Exist");
            }
        });

        //finalizing the edit dialog.
        editDialog.setLocationRelativeTo(this);
        editDialog.setLocation(500,300);
        editDialog.setSize(700,450);
        editPanel.add(editContentPanel);
        editPanel.add(Box.createVerticalGlue());
        editPanel.add(buttonPanel);
        editDialog.add(editPanel);
        editDialog.setVisible(true);

        return editDialog;
    }

    /**
     * Opens and read the passenger file to be used in the app.
     * the file content is stored in the Travel Agency database.
     *
     * @throws FileNotFoundException if file is not found in the directory.
     */
    private void passengerList() throws FileNotFoundException {
        final File    passengerFile;
        final Scanner passengerScan;

        passengerFile = new File("Passenger_list.txt");
        passengerScan = new Scanner(passengerFile);;

        while (passengerScan.hasNext()) {
            final String[] passenger;
            final String   vCode;
            final String   firstName;
            final String   lastName;
            final String   ageGroup;

            passenger = passengerScan.nextLine().split("\\|");
            vCode     = passenger[VEHICLE_CODE];
            firstName = passenger[FIRST_NAME];
            lastName  = passenger[LAST_NAME];
            ageGroup  = passenger[AGE_GROUP];

            agency.addPassenger(vCode, new Person(firstName, lastName, ageGroup));
        }
    }

    /**
     * Opens and read the vehicle file to be used in the app.
     * the file content is stored in the Travel Agency database.
     *
     * @throws FileNotFoundException if file is not found in the directory.
     */
    private void vehicleList() throws FileNotFoundException {
        final File    vehicleFile;
        final Scanner vehicleScan;


        vehicleFile = new File("Vehicle_list.txt");
        vehicleScan = new Scanner(vehicleFile);


        while (vehicleScan.hasNext()) {
            final String[] vehicle;
            final String vehicleCode;
            final String make;
            final String model;
            final int capacity;

            vehicle = vehicleScan.nextLine().split("\\|");
            vehicleCode = vehicle[VEHICLE_CODE];
            make = vehicle[MAKE];
            model = vehicle[MODEL];
            capacity = Integer.parseInt(vehicle[CAPACITY]);

            if (vehicleCode.substring(BEGINING_CHAR, VEHICLE_ID_LEN).equalsIgnoreCase("ap")) {
                final String flightDest;
                final String headPilot;

                flightDest = vehicle[FLIGHT_DEST];
                headPilot = vehicle[PILOT];
                ;

                agency.addVehicleDB(new AirPlane(vehicleCode, make, model, capacity, flightDest, headPilot));
            } else if (vehicleCode.substring(BEGINING_CHAR, VEHICLE_ID_LEN).equalsIgnoreCase("CS")) {
                final String cruiseLiner;
                final String route;
                final String shipCaptain;

                cruiseLiner = vehicle[CRUISE_LINER];
                route = vehicle[CRUISE_ROUTE];
                shipCaptain = vehicle[SHIP_CAPTAIN];

                agency.addVehicleDB(new CruiseShip(vehicleCode, make, model, capacity, cruiseLiner, route, shipCaptain));

            } else if (vehicleCode.substring(BEGINING_CHAR, VEHICLE_ID_LEN).equalsIgnoreCase("TR")) {
                final String railWayCompany;
                final boolean isHighSpeed;
                final String cityDest;
                final String trainDriver;

                railWayCompany = vehicle[RAIL_WAY_COMP];
                isHighSpeed = Boolean.parseBoolean(vehicle[HIGH_SPEED]);
                cityDest = vehicle[CITY_DEST];
                trainDriver = vehicle[TRAIN_DRIVER];

                agency.addVehicleDB(new Train(vehicleCode, make, model, capacity, railWayCompany, isHighSpeed, cityDest, trainDriver));

            } else if (vehicleCode.substring(BEGINING_CHAR, VEHICLE_ID_LEN).equalsIgnoreCase("BS")) {
                final String busLiner;
                final String busType;
                final String route;
                final String busDriver;

                busLiner = vehicle[BUS_LINER];
                busType = vehicle[BUS_TYPE];
                route = vehicle[ROUTES];
                busDriver = vehicle[BUS_DRIVER];

                agency.addVehicleDB(new Bus(vehicleCode, make, model, capacity, busLiner, busType, route, busDriver));
            }
        }

    }

    public static void main(String[] args) {
        final AgencyGUI GUI;

        GUI = new AgencyGUI();
    }
}
