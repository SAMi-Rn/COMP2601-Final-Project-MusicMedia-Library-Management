package ca.bcit.comp2601.assignment2.option1.sam;
/**
 * The VinylRecord class extends PhysicalMedia
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class VinylRecord extends PhysicalMedia {
    private int numberOfTracks;
    private int weightInGrams;
    private int sizeInInches;

    private  final int SINGLE_SIZE;
    private  final int EP_SIZE;
    private  final int LP_SIZE;

    private  final int SINGLE_WEIGHT;
    private  final int EP_WEIGHT;
    private  final int LP_WEIGHT;

    private static final int DEFAULT_SIZE = 7;
    private static final int DEFAULT_WEIGHT = 40;
    private static final int DEFAULT_TRACK_NUMBER = 2;
    private static final int MIN_TRACK_NUMBER = 1;
    {
        SINGLE_SIZE = DEFAULT_SIZE;
        EP_SIZE = 10;
        LP_SIZE = 12;

        SINGLE_WEIGHT = DEFAULT_WEIGHT;
        EP_WEIGHT = 100;
        LP_WEIGHT = 180;
    }
    /**
     * constructor for VinylRecord
     */
    public VinylRecord()
    {
        super();
    }
    /**
     *
     * @param sku String for the sku
     * @param title String for the song title
     * @param artist String for the artist's name
     * @param yearReleased integer for the yearReleased of the song
     * @param numberOfTracks integer for the number of tracks
     * @param sizeInInches integer for the size in inches
     * @param weightInGrams integer for the weight in grams
     */
    public VinylRecord(String sku, String title, String artist, int yearReleased, int numberOfTracks,int sizeInInches, int weightInGrams )
    {
        super(sku, title, artist, yearReleased);
        validateNumberOfTracks(numberOfTracks);

        validateSizeInInches(sizeInInches);
        validateWeightInGrams(weightInGrams);
        this.numberOfTracks = numberOfTracks;

        this.sizeInInches = sizeInInches;
        this.weightInGrams = weightInGrams;
    }
    /**
     *
     * @param sku String for the sku
     * @param title String for the song title
     * @param artist String for the artist's name
     * @param year integer for the year of the song
     * @param numberOfTracks integer for the number of tracks
     */
    public VinylRecord(String sku, String title, String artist, int year, int numberOfTracks)
    {
       this(sku, title, artist, year, DEFAULT_TRACK_NUMBER,DEFAULT_WEIGHT,DEFAULT_SIZE);
    }
    /**
     * validator for the numberOfTracks
     * @param numberOfTracks to be validated
     */
    public static void validateNumberOfTracks(int numberOfTracks)
    {
        if (numberOfTracks < MIN_TRACK_NUMBER) {

            throw new IllegalArgumentException("invalid number of tracks entered");
        }
    }
    /**
     * validator for the weightInGrams
     * @param weightInGrams to be validated
     */
    public  void validateWeightInGrams(int weightInGrams)
    {
        if (sizeInInches == SINGLE_SIZE && weightInGrams != SINGLE_WEIGHT) {
            throw new IllegalArgumentException("Record weight is invalid");
        } else if (sizeInInches == EP_SIZE && weightInGrams != EP_WEIGHT) {
            throw new IllegalArgumentException("Record weight is invalid");
        } else if (sizeInInches == LP_SIZE && weightInGrams != LP_WEIGHT) {
            throw new IllegalArgumentException("Record weight is invalid");
        }
    }
    /**
     * validator for the sizeInInches
     * @param sizeInInches to be validated
     */
    public void validateSizeInInches(int sizeInInches)
    {
        if( sizeInInches != SINGLE_SIZE && sizeInInches != EP_SIZE && sizeInInches != LP_SIZE){
            throw new IllegalArgumentException("Invalid Size, Size must be "+SINGLE_SIZE+" or "+EP_SIZE+" or "+LP_SIZE);
        }
    }

    /**
     * getter for numberOfTracks
     * @return numberOfTracks
     */
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }

    /**
     * setter for numberOfTracks
     * @param numberOfTracks is the int numberOfTracks
     */
    public void setNumberOfTracks(int numberOfTracks)
    {
        validateNumberOfTracks(numberOfTracks);
        this.numberOfTracks = numberOfTracks;
    }
    /**
     * getter for weightInGrams
     * @return weightInGrams
     */
    public int getWeightInGrams()
    {
        return weightInGrams;
    }
    /**
     * setter for weightInGrams
     * @param weightInGrams is the int weightInGrams
     */
    public void setWeightInGrams(int weightInGrams)
    {
        validateWeightInGrams(weightInGrams);
        this.weightInGrams = weightInGrams;
    }
    /**
     * getter for sizeInInches
     * @return sizeInInches
     */
    public int getSizeInInches()
    {
        return sizeInInches;
    }
    /**
     * setter for sizeInInches
     * @param sizeInInches is the int sizeInInches
     */
    public void setSizeInInches(int sizeInInches)
    {
        validateSizeInInches(sizeInInches);
        this.sizeInInches = sizeInInches;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
    @Override
    public void play()
    {
        System.out.println("Playing a vinyl record");

    }
}
