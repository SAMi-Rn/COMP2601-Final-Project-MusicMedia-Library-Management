package ca.bcit.comp2601.assignment2.option1.sam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

/**
 * The MusicGui class
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class MusicGui extends JFrame
{
    JScrollPane scrollPane ;
    private static List<MusicMedia> musicLibrary;
    private final DefaultListModel<MusicMedia> jListModel;
    private JList<MusicMedia> jList;
    private static final int SKU;
    private static final int TITLE;
    private static final int ARTIST_NAME;
    private static final int YEAR_RELEASED;
    private static final int FILE_NAME;
    private static final int FILE_RESOLUTION;
    private static final int NUMBER_OF_TRACKS;
    private static final int SIZE_IN_INCHES;
    private static final int WEIGHT_IN_GRAM;

    static
    {
        musicLibrary = new ArrayList<>();
        SKU = 0;
        TITLE = 1;
        ARTIST_NAME = 2;
        YEAR_RELEASED = 3;
        FILE_NAME = 4;
        FILE_RESOLUTION = 5;
        NUMBER_OF_TRACKS = 4;
        SIZE_IN_INCHES = 5;
        WEIGHT_IN_GRAM = 6;
    }
    {
        jListModel = new DefaultListModel<>();
        jList = new JList<>(jListModel);
        scrollPane = new JScrollPane();
    }

    /**
     * constructor for the MusicGui
     */
    public MusicGui()
    {
        super("Welcome to Music app");
        setSize(650,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setJMenuBar(getAppMenuBar());
        add(jList);
        setVisible(true);
        add(scrollPane);


    }
    /**
     * Menu bar for the Gui
     * @return the JMenuBar menu
     */
    public JMenuBar getAppMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // alt+F works too
        menuBar.add(fileMenu);
        JMenuItem saveMenu = new JMenuItem("Save Data");
        saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        fileMenu.add(saveMenu);
        //ask the user if they want to save the file
        saveMenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        int selectedOption = JOptionPane.showConfirmDialog(null,
                                "Do you want to save the changes?",
                                "Save Data?",
                                JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_OPTION)
                        {
                            File fnew=new File("src/music_data.txt");
                            Boolean appendFile = false;
                            final AtomicReference<String> source = new AtomicReference<>("");
                            musicLibrary.forEach(e->{
                                if(e instanceof AudioFile)
                                {   AudioFile a  =(AudioFile)e;
                                    source.updateAndGet(v -> v + e+"|"+a.getFileName()+"|"+a.getFileResolution()+"\n");
                                }else if(e instanceof CompactDisc)
                                {   CompactDisc c  =(CompactDisc) e;
                                    source.updateAndGet(v -> v + e+"|"+String.valueOf(c.getNumberOfTracks())+"\n");
                                }else if(e instanceof VinylRecord)
                                {   VinylRecord vinyl  =(VinylRecord) e;
                                    source.updateAndGet(v -> v + e+"|"+String.valueOf(vinyl.getNumberOfTracks())+
                                            "|"+String.valueOf(vinyl.getSizeInInches())+"|"+String.valueOf(vinyl.getWeightInGrams())+"\n");
                                }
                           });

                            FileWriter f2;
                            try {
                                f2 = new FileWriter(fnew,appendFile); // important part
                                f2.write(source.get());
                                appendFile = true;
                                f2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        //ask the user if they want to save the changes before exit the app
        exitMenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        int selectedOption = JOptionPane.showConfirmDialog(null,
                                "Do you want to save the changes?",
                                "Save Data?",
                                JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_OPTION)
                        {
                            File fnew=new File("src/music_data.txt");
                            Boolean appendFile = false;
                            final AtomicReference<String> source = new AtomicReference<>("");
                            musicLibrary.forEach(e->{
                                if(e instanceof AudioFile)
                                {   AudioFile a  =(AudioFile)e;
                                    source.updateAndGet(v -> v + e+"|"+a.getFileName()+"|"+a.getFileResolution()+"\n");
                                }else if(e instanceof CompactDisc)
                                {   CompactDisc c  =(CompactDisc) e;
                                    source.updateAndGet(v -> v + e+"|"+String.valueOf(c.getNumberOfTracks())+"\n");
                                }else if(e instanceof VinylRecord)
                                {   VinylRecord vinyl  =(VinylRecord) e;
                                    source.updateAndGet(v -> v + e+"|"+String.valueOf(vinyl.getNumberOfTracks())+
                                            "|"+String.valueOf(vinyl.getSizeInInches())+"|"+String.valueOf(vinyl.getWeightInGrams())+"\n");
                                }
                            });
                            FileWriter f2;
                            try {
                                f2 = new FileWriter(fnew,appendFile); // important part
                                f2.write(source.get());
                                appendFile = true;
                                f2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.exit(0);
                        }else{
                            System.exit(0);
                        }
                    }
                });
        JMenu searchMenu = new JMenu("Sort");
        searchMenu.setMnemonic(KeyEvent.VK_S);
        menuBar.add(searchMenu);
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener((event) -> JOptionPane.showMessageDialog(MusicGui.this,
                "Assignment2\nby Sami Roudgarian\nA01294122 ",
                "About...",
                JOptionPane.INFORMATION_MESSAGE));
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_DOWN_MASK));
        aboutMenuItem.setMnemonic(KeyEvent.VK_C);
        helpMenu.add(aboutMenuItem);

        // Create menu item for the Search menu
        JMenuItem searchItem1 = new JMenuItem("By Type");
        searchItem1.setMnemonic(KeyEvent.VK_J);
        searchMenu.add(searchItem1);


        JMenuItem searchItem2 = new JMenuItem("By Artist");
        searchItem2.setMnemonic(KeyEvent.VK_M);
        searchMenu.add(searchItem2);

        JMenuItem searchItem3 = new JMenuItem("BY Title");
        searchItem3.setMnemonic(KeyEvent.VK_Y);
        searchMenu.add(searchItem3);

        JMenuItem searchItem4 = new JMenuItem("By Year");
        searchItem4.setMnemonic(KeyEvent.VK_E);
        searchMenu.add(searchItem4);


        fileMenu.add(exitMenu);
        menuBar.add(fileMenu);
        menuBar.add(searchMenu);
        menuBar.add(helpMenu);

        searchItem1.addActionListener(e -> {
            // Clear data from JList
            jListModel.clear();
            List<MusicMedia> type = musicLibrary.stream()
                    .sorted(Comparator.comparing(MusicMedia::getSku))
                    .collect(Collectors.toList());
            for (MusicMedia m : type) {
                jListModel.addElement(m);
            }
            scrollPane = new JScrollPane(jList);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            scrollPane.setPreferredSize(new Dimension(400, 200));//<-----any size you want
            JOptionPane.showMessageDialog(null, scrollPane, "By Type",
                    JOptionPane.PLAIN_MESSAGE);
        });
        searchItem2.addActionListener(e -> {
            // Clear data from JList
            jListModel.clear();
            List<MusicMedia> type = musicLibrary.stream()
                    .sorted(Comparator.comparing(MusicMedia::getArtistName))
                    .collect(Collectors.toList());

            for (MusicMedia m : type) {
                jListModel.addElement(m);
            }
            scrollPane = new JScrollPane(jList);
            JPanel panel = new JPanel();
            panel.add(scrollPane);
            JOptionPane.showMessageDialog(null, scrollPane, "By Artist",
                    JOptionPane.PLAIN_MESSAGE);
        });
        searchItem3.addActionListener(e -> {
            // Clear data from JList
            jListModel.clear();
            List<MusicMedia> type = musicLibrary.stream()
                    .sorted(Comparator.comparing(MusicMedia::getTitle))
                    .collect(Collectors.toList());

            for (MusicMedia m : type) {
                jListModel.addElement(m);
            }
            scrollPane = new JScrollPane(jList);
            JPanel panel = new JPanel();
            panel.add(scrollPane);

            JOptionPane.showMessageDialog(null, scrollPane, "By Title",
                    JOptionPane.PLAIN_MESSAGE);
        });
        searchItem4.addActionListener(e -> {
            // Clear data from JList
            jListModel.clear();
            List<MusicMedia> type = musicLibrary.stream()
                    .sorted(Comparator.comparing(MusicMedia::getYearReleased))
                    .collect(Collectors.toList());

            for (MusicMedia m : type) {
                jListModel.addElement(m);
            }
            scrollPane = new JScrollPane(jList);
            final AtomicReference<JPanel> panel = new AtomicReference<>(new JPanel());
            panel.get().add(scrollPane);

            JOptionPane.showMessageDialog(null, scrollPane, "By Year",
                    JOptionPane.PLAIN_MESSAGE);
            });
        jList.getSelectionModel().addListSelectionListener(listSelectionEvent -> {

            MusicMedia c = jList.getSelectedValue();
            int index = jList.getSelectedIndex();
            if(c instanceof AudioFile) {
                AudioFile audioFile = (AudioFile) c;
                JTextField sku = new JTextField(audioFile.getSku());
                JTextField title = new JTextField(audioFile.getTitle());
                JTextField artist = new JTextField(audioFile.getArtistName());
                JTextField year = new JTextField(String.valueOf(audioFile.getYearReleased()));
                JTextField fileName = new JTextField(audioFile.getFileName());
                JTextField resolution = new JTextField(String.valueOf(audioFile.getFileResolution()));
                JTextField clear = new JTextField("not cleared");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(7, 2));
                JLabel skuLabel = new JLabel("SKU");
                JLabel titleLabel = new JLabel("Title");
                JLabel artistLabel = new JLabel("Artist");
                JLabel yearLabel = new JLabel("Year");
                JLabel fileLabel = new JLabel("FileName");
                JLabel resolutionLabel = new JLabel("Resolution");
                panel.add(skuLabel);
                panel.add(sku);
                panel.add(titleLabel);
                panel.add(title);
                panel.add(artistLabel);
                panel.add(artist);
                panel.add(yearLabel);
                panel.add(year);
                panel.add(fileLabel);
                panel.add(fileName);
                panel.add(resolutionLabel);
                panel.add(resolution);

                final JButton jbtClear = new JButton("Clear");
                final JButton jbtDelete = new JButton("Delete");
                final JButton jbtClose = new JButton("Close");
                final JButton jbtSave = new JButton("Save");
                final JDialog dialog = new JDialog(MusicGui.this, "Audio File", true);
                jbtClose.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dialog.dispose();
                    }
                });
                jbtClear.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        sku.setText("");
                        title.setText("");
                        artist.setText("");
                        year.setText("");
                        fileName.setText("");
                        resolution.setText("");
                        clear.setText("clear");
                    }
                });
                jbtDelete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {

                        int selectedOption = JOptionPane.showConfirmDialog(dialog,
                                "Are you sure you ?",
                                "Delete Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        switch (selectedOption)
                        {
                            case 0:
                                jListModel.remove(index);
                                musicLibrary.remove(audioFile);
                                dialog.dispose();
                        }
                    }
                });
                jbtSave.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(clear.getText().equals("clear")){
                            AudioFile newAudioFile = new AudioFile();
                            newAudioFile.setSku(sku.getText());
                            newAudioFile.setTitle(title.getText());
                            newAudioFile.setArtistName(artist.getText());
                            newAudioFile.setYearReleased(Integer.parseInt(year.getText()));
                            newAudioFile.setFileName(fileName.getText());
                            newAudioFile.setFileResolution(Integer.parseInt(resolution.getText()));

                            jListModel.addElement(newAudioFile);
                            musicLibrary.add(newAudioFile);
                            dialog.dispose();
                        } else {
                            audioFile.setSku(sku.getText());
                            audioFile.setTitle(title.getText());
                            audioFile.setArtistName(artist.getText());
                            audioFile.setYearReleased(Integer.parseInt(year.getText()));
                            audioFile.setFileName(fileName.getText());
                            audioFile.setFileResolution(Integer.parseInt(resolution.getText()));
                            dialog.dispose();
                        }
                    }
                });
                Object[] options1 = {jbtClose,jbtDelete , jbtSave, jbtClear};
                JOptionPane optionPane = new JOptionPane(panel,
                        DEFAULT_OPTION,
                        WARNING_MESSAGE,
                        null, options1, null);
                dialog.getContentPane().add(optionPane);
                dialog.setSize(390,270);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

            }
            else if(c instanceof VinylRecord) {
                VinylRecord vinyl = (VinylRecord) c;
                JTextField sku = new JTextField(vinyl.getSku());
                JTextField title = new JTextField(vinyl.getTitle());
                JTextField artist = new JTextField(vinyl.getArtistName());
                JTextField year = new JTextField(String.valueOf(vinyl.getYearReleased()));
                JTextField numberOfTracks = new JTextField((String.valueOf(vinyl.getNumberOfTracks())));
                JTextField sizeInInches = new JTextField(String.valueOf(vinyl.getSizeInInches()));
                JTextField weightInGrams = new JTextField(String.valueOf(vinyl.getWeightInGrams()));
                JTextField clear = new JTextField("not cleared");
                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(7, 2));
                JLabel skuLabel = new JLabel("SKU");
                JLabel titleLabel = new JLabel("Title");
                JLabel artistLabel = new JLabel("Artist");
                JLabel yearLabel = new JLabel("Year");
                JLabel numberOfTracksLabel = new JLabel("Number Of Tracks");
                JLabel sizeInInchesLabel = new JLabel("Size In Inches");
                JLabel weightInGramsLabel = new JLabel("WeightInGrams");
                panel.add(skuLabel);
                panel.add(sku);
                panel.add(titleLabel);
                panel.add(title);
                panel.add(artistLabel);
                panel.add(artist);
                panel.add(yearLabel);
                panel.add(year);
                panel.add(numberOfTracksLabel);
                panel.add(numberOfTracks);
                panel.add(sizeInInchesLabel);
                panel.add(sizeInInches);
                panel.add(weightInGramsLabel);
                panel.add(weightInGrams);
                final JButton jbtClear = new JButton("Clear");
                final JButton jbtDelete = new JButton("Delete");
                final JButton jbtClose = new JButton("Close");
                final JButton jbtSave = new JButton("Save");
                final JDialog dialog = new JDialog(MusicGui.this, "Vinyl Record", true);
                jbtClose.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dialog.dispose();
                    }
                });
                jbtClear.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        sku.setText("");
                        title.setText("");
                        artist.setText("");
                        year.setText("");
                        numberOfTracks.setText("");
                        sizeInInches.setText("");
                        weightInGrams.setText("");
                        clear.setText("clear");
                    }
                });
                jbtDelete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {

                        int selectedOption = JOptionPane.showConfirmDialog(dialog,
                                "Are you sure you ?",
                                "Delete Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        switch (selectedOption)
                        {
                            case 0:
                                jListModel.remove(index);
                                musicLibrary.remove(vinyl);
                                dialog.dispose();
                        }
                    }
                });
                jbtSave.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(clear.getText().equals("clear")){
                            VinylRecord newVinylRecord = new VinylRecord();
                            newVinylRecord.setSku(sku.getText());
                            newVinylRecord.setTitle(title.getText());
                            newVinylRecord.setArtistName(artist.getText());
                            newVinylRecord.setYearReleased(Integer.parseInt(year.getText()));
                            newVinylRecord.setNumberOfTracks(Integer.parseInt(numberOfTracks.getText()));
                            newVinylRecord.setSizeInInches(Integer.parseInt(sizeInInches.getText()));
                            newVinylRecord.setWeightInGrams(Integer.parseInt(weightInGrams.getText()));
                            jListModel.addElement(newVinylRecord);
                            musicLibrary.add(newVinylRecord);
                            dialog.dispose();
                        } else {
                            vinyl.setSku(sku.getText());
                            vinyl.setTitle(title.getText());
                            vinyl.setArtistName(artist.getText());
                            vinyl.setYearReleased(Integer.parseInt(year.getText()));
                            vinyl.setNumberOfTracks(Integer.parseInt(numberOfTracks.getText()));
                            vinyl.setSizeInInches(Integer.parseInt(sizeInInches.getText()));
                            vinyl.setWeightInGrams(Integer.parseInt(weightInGrams.getText()));
                            dialog.dispose();
                        }
                    }
                });
                Object[] options2 = {jbtClose,jbtDelete , jbtSave, jbtClear};
                JOptionPane optionPane = new JOptionPane(panel,
                        DEFAULT_OPTION,
                        WARNING_MESSAGE,
                        null, options2, null);
                dialog.getContentPane().add(optionPane);
                dialog.setSize(390,270);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
            else if(c instanceof CompactDisc) {
                CompactDisc compactDisc = (CompactDisc) c;
                JTextField sku = new JTextField(compactDisc.getSku());
                JTextField title = new JTextField(compactDisc.getTitle());
                JTextField artist = new JTextField(compactDisc.getArtistName());
                JTextField year = new JTextField(String.valueOf(compactDisc.getYearReleased()));
                JTextField numberOfTracks = new JTextField((String.valueOf(compactDisc.getNumberOfTracks())));
                JTextField clear = new JTextField("not cleared");

                JPanel panel = new JPanel();

                panel.setLayout(new GridLayout(7, 2));
                JLabel skuLabel = new JLabel("SKU");
                JLabel titleLabel = new JLabel("Title");
                JLabel artistLabel = new JLabel("Artist");
                JLabel yearLabel = new JLabel("Year");
                JLabel numberOfTracksLabel = new JLabel("Number Of Tracks");

                panel.add(skuLabel);
                panel.add(sku);
                panel.add(titleLabel);
                panel.add(title);
                panel.add(artistLabel);
                panel.add(artist);
                panel.add(yearLabel);
                panel.add(year);
                panel.add(numberOfTracksLabel);
                panel.add(numberOfTracks);

                final JButton jbtClear = new JButton("Clear");
                final JButton jbtDelete = new JButton("Delete");
                final JButton jbtClose = new JButton("Close");
                final JButton jbtSave = new JButton("Save");
                final JDialog dialog = new JDialog(MusicGui.this, "Compact Disc", true);
                jbtClose.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        dialog.dispose();
                    }
                });
                jbtClear.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        sku.setText("");
                        title.setText("");
                        artist.setText("");
                        year.setText("");
                        numberOfTracks.setText("");
                        clear.setText("clear");
                    }
                });
                jbtDelete.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) {

                        int selectedOption = JOptionPane.showConfirmDialog(dialog,
                                "Are you sure you ?",
                                "Delete Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        switch (selectedOption)
                        {
                            case 0:
                                jListModel.remove(index);
                                musicLibrary.remove(compactDisc);
                                dialog.dispose();
                        }
                    }
                });
                jbtSave.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        if(clear.getText().equals("clear")){
                            CompactDisc newCompactDisc = new CompactDisc();
                            newCompactDisc.setSku(sku.getText());
                            newCompactDisc.setTitle(title.getText());
                            newCompactDisc.setArtistName(artist.getText());
                            newCompactDisc.setYearReleased(Integer.parseInt(year.getText()));
                            newCompactDisc.setNumberOfTracks(Integer.parseInt(numberOfTracks.getText()));

                            jListModel.addElement(newCompactDisc);
                            musicLibrary.add(newCompactDisc);
                                dialog.dispose();
                        } else {
                            compactDisc.setSku(sku.getText());
                            compactDisc.setTitle(title.getText());
                            compactDisc.setArtistName(artist.getText());
                            compactDisc.setYearReleased(Integer.parseInt(year.getText()));
                            compactDisc.setNumberOfTracks(Integer.parseInt(numberOfTracks.getText()));
                            dialog.dispose();
                        }
                    }
                });
                Object[] options1 = {jbtClose,jbtDelete , jbtSave, jbtClear};
                JOptionPane optionPane = new JOptionPane(panel,
                        DEFAULT_OPTION,
                        WARNING_MESSAGE,
                        null, options1, null);
                dialog.getContentPane().add(optionPane);
                dialog.setSize(390,270);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        return menuBar;
            }
    public static void main(final String[] args)
    {
        // getting the data from music_data.txt
        File f = new File("src/music_data.txt");
        try
        {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\\|");
                if (data[0].substring(0, 2).equalsIgnoreCase("af"))
                {
                    MusicMedia newAudioFile = new AudioFile(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), data[FILE_NAME],
                            Integer.parseInt(data[FILE_RESOLUTION]));
                    musicLibrary.add(newAudioFile);
                }
                else if (data[0].substring(0, 2).equalsIgnoreCase("cd"))
                {
                    MusicMedia newCompactDisc =new CompactDisc(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), Integer.parseInt(data[NUMBER_OF_TRACKS]));
                    musicLibrary.add(newCompactDisc);
                } else
                {
                    MusicMedia newVinylRecord = new VinylRecord(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), Integer.parseInt(data[NUMBER_OF_TRACKS]),
                            Integer.parseInt(data[SIZE_IN_INCHES]), Integer.parseInt(data[WEIGHT_IN_GRAM]));
                    musicLibrary.add(newVinylRecord);
                }
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        MusicGui app = new MusicGui();
    }
}



