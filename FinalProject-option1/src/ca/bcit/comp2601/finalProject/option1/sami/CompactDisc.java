package ca.bcit.comp2601.assignment2.option1.sam;
import java.util.Objects;
/**
 * The Compact disc extends PhysicalMedia
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class CompactDisc extends PhysicalMedia {
    private int numberOfTracks;
    public static final int MIN_NUMBER_OF_TRACKS;
    static
    {
        MIN_NUMBER_OF_TRACKS = 1;
    }
    public CompactDisc() {
        super();
    }
    /**
     *
     * @param sku String for the sku
     * @param title String for the song title
     * @param artist String for the artist name
     * @param yearReleased integer for the yearReleased that music released
     * @param numberOfTracks  integer that has number of the tracks
     */
    public CompactDisc(String sku, String title, String artist, int yearReleased, int numberOfTracks)
    {
        super(sku, title, artist, yearReleased);
        validateNumberOfTracks(numberOfTracks);
        this.numberOfTracks = numberOfTracks;
    }
    /**
     * validate the number of tracks
     * @param numberOfTracks to be validate
     */
    public static void validateNumberOfTracks(int numberOfTracks)
    {
        if (numberOfTracks < MIN_NUMBER_OF_TRACKS) {

            throw new IllegalArgumentException("invalid number of tracks entered");
        }
    }
    /**
     * getter for the number of tracks
     * @return the number of tracks
     */
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }
    /**
     * setter for the number of tracks
     * @param numberOfTracks to set the new number of trakcs
     */
    public void setNumberOfTracks(int numberOfTracks)
    {
        validateNumberOfTracks(numberOfTracks);
        this.numberOfTracks = numberOfTracks;
    }
    @Override
    public void play()
    {
        System.out.println("Playing the " + getTitle() + " compact disc");
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(numberOfTracks);
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CompactDisc other = (CompactDisc) obj;
        return numberOfTracks == other.numberOfTracks;
    }
}
