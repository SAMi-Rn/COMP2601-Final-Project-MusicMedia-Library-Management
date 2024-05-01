package ca.bcit.comp2601.assignment2.option1.sam;
/**
 * The fileProcessor interface for saving and deleting the files
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public interface FileManager
{
    /**
     * save the file in the filePath
     */
    void save(String path, String fileName);
    /**
     * delete the file from the filePath
     */
    void delete(String path, String fileName);
}
