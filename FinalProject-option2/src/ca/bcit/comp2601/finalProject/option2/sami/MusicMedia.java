package ca.bcit.comp2601.assignment2.option2.sam;

import java.util.Objects;
/**
 * The MusicMedia abstract class
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public abstract class MusicMedia
{
    private String sku;
    private String title;
    private String artistName;
    private int yearReleased;
    public static final int CURRENT_YEAR;
    public static final int FIRST_YEAR;
    static
    {
        FIRST_YEAR = 1860;
        CURRENT_YEAR = 2022;
    }
    /**
     * MusicMedia constructor
     */
    public MusicMedia()
    {
        super();
    }
    /**
     *MusicMedia overloaded constructor
     * @param sku String for the sku
     * @param title String for the song title
     * @param artistName String for the artist's name
     */
    public MusicMedia(String sku,String title, String artistName) {
        super();
        validateSku(sku);
        validateTitle(title);
        validateArtist(artistName);
        this.sku = sku;
        this.title = title;
        this.artistName = artistName;
        this.yearReleased = CURRENT_YEAR;
    }
    /**
     *MusicMedia overloaded constructor
     * @param sku String for the sku
     * @param title String for the song title
     * @param artistName String for the artist's name
     * @param yearReleased integer for the year that song released
     */
    public MusicMedia(String sku, String title, String artistName, int yearReleased)
    {
        super();
        validateSku(sku);
        validateTitle(title);
        validateArtist(artistName);
        validateYear(yearReleased);
        this.sku = sku;
        this.title = title;
        this.artistName = artistName;
        this.yearReleased = yearReleased;
    }
    /**
     * validator for the sku String
     * @param sku to be validated
     */
    public static void validateSku(String sku)
    {
        if( sku == null || sku.isEmpty()) {

            throw new IllegalArgumentException("invalid sku entered");
        }
    }
    /**
     * validator for to artist String
     * @param artist to be validated
     */
    public static void validateArtist(String artist)
    {
        if( artist== null || artist.isEmpty()) {

            throw new IllegalArgumentException("invalid artist entered");
        }
    }
    /**
     * validator for to title String
     * @param title to be validated
     */
    public static void validateTitle(String title)
    {
        if( title == null || title.isEmpty()) {

            throw new IllegalArgumentException("invalid title entered");
        }
    }
    /**
     * validator for to year integer
     * @param year to be validated
     */
    public static void validateYear(int year)
    {
        if(year < FIRST_YEAR) {

            throw new IllegalArgumentException("invalid year entered");
        }
    }
    /**
     * getter for the sku
     * @return the sku
     */
    public String getSku()
    {
        return sku;
    }
    /**
     * setter for the sku
     * @param sku to be set
     */
    public void setSku(String sku)
    {
        validateSku(sku);
        this.sku = sku;
    }
    /**
     * getter for the title
     * @return the title
     */
    public final String getTitle()
    {
        return title;
    }
    /**
     * setter for the sku
     * @param title to be set
     */
    public void setTitle(String title)
    {
        validateTitle(title);
        this.title = title;
    }
    /**
     * getter for the artist
     * @return the artist
     */
    public final String getArtistName()
    {
        return artistName;
    }
    /**
     * setter for the artist
     * @param artistName to be set
     */
    public void setArtistName(String artistName)
    {
        validateArtist(artistName);
        this.artistName = artistName;
    }
    /**
     * getter for the year
     * @return the year
     */
    public final int getYearReleased()
    {
        return yearReleased;
    }
    /**
     * setter for the year
     * @param yearReleased to be set
     */
    public void setYearReleased(int yearReleased)
    {
        validateYear(yearReleased);
        this.yearReleased = yearReleased;
    }
    /**
     * abstract method to play the song
     */
    public abstract void play();
    @Override
    public String toString()
    {
        return  sku + '|' +
                artistName   + '|' +
                title  + '|' +
                yearReleased ;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(artistName, title);
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusicMedia other = (MusicMedia) obj;
        return Objects.equals(artistName, other.artistName) && Objects.equals(title, other.title);
    }
}
