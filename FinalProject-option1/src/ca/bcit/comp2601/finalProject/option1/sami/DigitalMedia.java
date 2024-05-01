package ca.bcit.comp2601.assignment2.option1.sam;
import java.io.*;
/**
 * The DigitalMedia class that extends the MusicMedia and implements FileProcessor
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public abstract class DigitalMedia extends MusicMedia implements FileManager
{
    private String filePath;
    public DigitalMedia()
    {
    }
    /**
     *
     * @param sku String for the sku
     * @param title String for the song title
     * @param artistName String for the artist's name
     * @param yearReleased integer for the year of the song
     */
    public DigitalMedia(String sku, String title, String artistName, int yearReleased)
    {
        super(sku, title, artistName, yearReleased);
    }
    /**
     * override the save method to copy the music_data.txt file to the new path
     * @param filePath to be saved
     */
    @Override
    public void save(String filePath, String fileName) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("invalid filePath entered");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("invalid fileName entered");
        }
        this.filePath = filePath;
        InputStream input;
        OutputStream output;
        try {
            input = new FileInputStream("src/music_data.txt");
            output = new FileOutputStream(filePath + "/" + fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0)
            {
                output.write(buffer, 0, length);
            }
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    /**
     * override the delete method to delete the file id it exist
     * @param filePath to delete the file
     */
    @Override
    public void delete(String filePath,String fileName)
    {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("invalid filePath entered");
        }
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("invalid fileName entered");
        }
        try
        {
            File f= new File(filePath+"/"+fileName);
            //file to be deleted
            // it will delete the file if it exists
            f.delete();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
