package ca.bcit.comp2601.assignment2.option2.sam;

/**
 * The AudioFile class that extends the DigitalMedia
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class AudioFile extends DigitalMedia
{
    private String fileName;
    private int fileResolution;
    public static final int MIN_FILE_RESOLUTION;
    static
    {
     MIN_FILE_RESOLUTION = 1;
    }
    {
        fileName = "unknownFile";
    }
    /**
     * AudioFile constructor without parameter
     */
    public AudioFile()
    {
        super();
    }
    /**
     *
     * @param sku String for the Sku
     * @param title String for the title of the song
     * @param artistName String for the artist name
     * @param yearReleased integer for the year released
     * @param fileName file name of the audioFile
     * @param fileResolution the resolution of the songs
     */
    public AudioFile(String sku, String title, String artistName, int yearReleased, String fileName, int fileResolution) {
        super(sku, title, artistName, yearReleased);
        validateFileName(fileName);
        validateResolution(fileResolution);
        this.fileName = fileName;
        this.fileResolution = fileResolution;
    }
    /**
     *
     * @param sku String for the Sku
     * @param title String for the title of the song
     * @param artist String for the artist name
     * @param year integer for the year released
     * @param fileName file name of the audioFile
     */
    public AudioFile(String sku, String title, String artist, int year, String fileName) {
        super(sku, title, artist, year);
        validateFileName(fileName);
        this.fileResolution = MIN_FILE_RESOLUTION;
    }
    /**
     * validation for the file name
     * @param fileName to be validate
     */
    public static void validateFileName(String fileName) {
        if (fileName == null || fileName.isEmpty())
        {
            throw new IllegalArgumentException("invalid fileName entered");
        }
    }
    /**
     * validation for the file resolution
     * @param fileResolution to be validated
     */
    public static void validateResolution(int fileResolution) {
        if (fileResolution < MIN_FILE_RESOLUTION)
        {
            throw new IllegalArgumentException("invalid file resolution entered");
        }
    }
    /**
     * getter for the fileName
     * @return return fileName
     */
    public String getFileName()
    {
        return fileName;
    }
    /**
     * setter for the fileName
     * @param fileName to set
     */
    public void setFileName(String fileName)
    {
        validateFileName(fileName);
        this.fileName = fileName;
    }
    /**
     * getter for the fileResolution
     * @return return fileResolution
     */
    public int getFileResolution()
    {
        return fileResolution;
    }
    /**
     * setter for the fileResolution
     * @param fileResolution to set
     */
    public void setFileResolution(int fileResolution)
    {
        validateResolution(fileResolution);
        this.fileResolution = fileResolution;
    }
    @Override
    public void play()
    {
        System.out.println("Playing an audio file");
    }
    @Override
    public String toString()
    {
        return
                super.toString() ;
    }
}
