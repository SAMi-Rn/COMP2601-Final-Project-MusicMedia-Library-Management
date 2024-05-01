package ca.bcit.comp2601.assignment2.option2.sam;
/**
 * The PhysicalMedia class extends MusicMedia
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public abstract class PhysicalMedia extends MusicMedia {
    /**
     * constrictor for PhysicalMedia
     */
    public PhysicalMedia()
    {
    }
    /**
     *
     * @param sku String for the sku
     * @param title String for the song title
     * @param artistName String for the artist's name
     * @param yearReleased integer for the year of the song
     */
    public PhysicalMedia(String sku, String title, String artistName, int yearReleased)
    {
        super(sku, title, artistName, yearReleased);
    }
}
