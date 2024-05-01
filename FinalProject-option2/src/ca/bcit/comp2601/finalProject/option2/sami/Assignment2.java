package ca.bcit.comp2601.assignment2.option2.sam;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * The main class for the assignment 2
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class Assignment2 {
    private MusicLibrary library;
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
    public static void main(final String[] args) {
        Assignment2 assignment = new Assignment2();
        assignment.init();
        assignment.DisplayMenu();
    }

    /**
     * to get the object from the music_data.txt and add it to the musicLibrary hashmap
     */
    public void init() {
        library = new MusicLibrary();
        File f = new File("src/music_data.txt");
        try {
            Scanner fileScanner = new Scanner(f);
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\\|");
                if (data[0].substring(0, 2).equalsIgnoreCase("af")) {
                    MusicMedia newAudioFile = new AudioFile(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), data[FILE_NAME],
                            Integer.parseInt(data[FILE_RESOLUTION]));
                    library.addMusic(newAudioFile);

                } else if (data[0].substring(0, 2).equalsIgnoreCase("cd")) {
                    MusicMedia newCompactDisc = new CompactDisc(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), Integer.parseInt(data[NUMBER_OF_TRACKS]));
                    library.addMusic(newCompactDisc);
                } else {
                    MusicMedia newVinylRecord = new VinylRecord(data[SKU], data[TITLE], data[ARTIST_NAME],
                            Integer.parseInt(data[YEAR_RELEASED]), Integer.parseInt(data[NUMBER_OF_TRACKS]),
                            Integer.parseInt(data[SIZE_IN_INCHES]), Integer.parseInt(data[WEIGHT_IN_GRAM]));
                    library.addMusic(newVinylRecord);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displaying the menu in the console
     */
    public void DisplayMenu() {
        System.out.println("Welcome to our Music App");
        String userInput;
        while (true) {
            System.out.println("Choose one of the following options");
            System.out.println("    1. File");
            System.out.println("    2. Sort");
            System.out.println("    3. About");

            Scanner keyboardScanner = new Scanner(System.in);
            if (keyboardScanner.hasNext()) // user typed something...
            {
                if (keyboardScanner.hasNextInt()) {
                    int input = keyboardScanner.nextInt();


                    if (input == 1) {

                        while (true) {
                            System.out.println("File:");
                            System.out.println("    1. Add");
                            System.out.println("    2. Remove");
                            System.out.println("    3. Save");
                            System.out.println("    4. Exit");
                            System.out.println("    5. Back\n");
                            if (keyboardScanner.hasNextInt()) {
                                input = keyboardScanner.nextInt();

                                keyboardScanner.nextLine();

                                if (input == 1) {
                                    while (true) {
                                        System.out.println("Add:");
                                        System.out.println("    1. Audio File");
                                        System.out.println("    2. Compact Disc");
                                        System.out.println("    3. Vinyl Record");
                                        System.out.println("    4. Back\n");
                                        if (keyboardScanner.hasNextInt()) {
                                            input = keyboardScanner.nextInt();
                                            if (input == 1) {
                                                System.out.println("Audio File\n");
                                                System.out.println("Enter the SKU:");
                                                String sku = keyboardScanner.next();
                                                System.out.println("Enter the song title:");
                                                String title = keyboardScanner.next();
                                                System.out.println("Enter the Artist Name:");
                                                String artistName = keyboardScanner.next();
                                                System.out.println("Enter the year released(integer):");
                                                int yearReleased = keyboardScanner.nextInt();
                                                System.out.println("Enter the File Name:");
                                                String fileName = keyboardScanner.next();
                                                System.out.println("Enter the file resolution(integer):");
                                                int fileResolution = keyboardScanner.nextInt();
                                                AudioFile newAudioFile = new AudioFile(sku, title, artistName, yearReleased, fileName, fileResolution);
                                                library.addMusic(newAudioFile);

                                            } else if (input == 2) {
                                                System.out.println("Enter the SKU:");
                                                String sku = keyboardScanner.next();
                                                System.out.println("Enter the song title:");
                                                String title = keyboardScanner.next();
                                                System.out.println("Enter the Artist Name:");
                                                String artistName = keyboardScanner.next();
                                                System.out.println("Enter the year released(integer):");
                                                int yearReleased = keyboardScanner.nextInt();
                                                System.out.println("Enter the number of tracks(integer):");
                                                int numberOfTracks = keyboardScanner.nextInt();
                                                CompactDisc newCompactDisc = new CompactDisc(sku, title, artistName, yearReleased, numberOfTracks);
                                                library.addMusic(newCompactDisc);

                                            } else if (input == 3) {
                                                System.out.println("Enter the SKU:");
                                                String sku = keyboardScanner.next();
                                                System.out.println("Enter the song title:");
                                                String title = keyboardScanner.next();
                                                System.out.println("Enter the Artist Name:");
                                                String artistName = keyboardScanner.next();
                                                System.out.println("Enter the year released(integer):");
                                                int yearReleased = keyboardScanner.nextInt();
                                                System.out.println("Enter the number of tracks(integer):");
                                                int numberOfTracks = keyboardScanner.nextInt();
                                                System.out.println("Enter the Size in inches(integer):");
                                                int sizeInInches = keyboardScanner.nextInt();
                                                System.out.println("Enter the weight in gram(integer):");
                                                int weightInGram = keyboardScanner.nextInt();
                                                VinylRecord newVinylRecord = new VinylRecord(sku, title, artistName, yearReleased, numberOfTracks, sizeInInches, weightInGram);
                                                library.addMusic(newVinylRecord);
                                            } else if (input == 4) {
                                                break;
                                            } else {
                                                System.out.println("error! you typed " + input);
                                            }
                                        } else {
                                            userInput = keyboardScanner.next();
                                            System.out.println("error! you typed " + userInput);
                                        }
                                    }
                                } else if (input == 2) {
                                    System.out.println("Enter the SKU of the MusicMedia you want to remove");
                                    String sku = keyboardScanner.nextLine();
                                    library.removeMusic(sku);
                                } else if (input == 3) {

                                    System.out.println("You want to save the changes?, type Y or N");
                                    String answer = keyboardScanner.nextLine();
                                    if (answer.equalsIgnoreCase("y")) {
                                        library.save("src", "music_data.txt");
                                    }
                                } else if (input == 4) {

                                    System.out.println("You want to save the changes?, type Y or N");
                                    String answer = keyboardScanner.nextLine();
                                    if (answer.equalsIgnoreCase("y")) {
                                        library.save("src", "music_data.txt");
                                        System.exit(0);
                                    } else {
                                        System.exit(0);
                                    }

                                } else if (input == 5) {
                                    break;

                                } else {
                                    System.out.println("error! you typed " + input);
                                }
                            } else {
                                userInput = keyboardScanner.next();
                                System.out.println("error! you typed " + userInput);
                            }
                        }
                    } else if (input == 2) {
                        while (true) {
                            System.out.println("Sort");
                            System.out.println("    1. By Type");
                            System.out.println("    2. By Title");
                            System.out.println("    3. By Artist");
                            System.out.println("    4. By Year");
                            System.out.println("    5. Back\n");
                            if (keyboardScanner.hasNextInt()) {
                                input = keyboardScanner.nextInt();
                                if (input == 1) {
                                    library.orderByType();
                                } else if (input == 2) {
                                    library.orderByTitle();
                                } else if (input == 3) {
                                    library.orderByArtist();
                                } else if (input == 4) {
                                    library.orderByYear();
                                } else if (input == 5) {
                                    break;
                                } else {
                                    System.out.println("error! you typed " + input);
                                }
                            } else {
                                userInput = keyboardScanner.next();
                                System.out.println("error! you typed " + userInput);
                            }
                        }
                    } else if (input == 3) {
                        while (true) {
                            System.out.println("About");
                            System.out.println("    1. About");
                            System.out.println("    2. Back\n");

                            if (keyboardScanner.hasNextInt()) {
                                input = keyboardScanner.nextInt();
                                if (input == 1) {
                                    System.out.println("Assignment 2\nBy Sami Roudgarian\nA01294122 ");
                                } else if (input == 2) {
                                    break;
                                } else {
                                    System.out.println("error! you typed " + input);
                                }
                            } else {
                                userInput = keyboardScanner.next();
                                System.out.println("error! you typed " + userInput);
                            }
                        }
                    } else {
                        System.out.println("error! you typed " + input);
                    }
                } else {
                    userInput = keyboardScanner.next();
                    System.out.println("error! you typed " + userInput);
                }
            }
        }
    }
}