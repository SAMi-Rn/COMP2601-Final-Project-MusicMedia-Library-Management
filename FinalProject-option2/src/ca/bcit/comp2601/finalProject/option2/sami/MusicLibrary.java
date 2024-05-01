package ca.bcit.comp2601.assignment2.option2.sam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The MusicLibrary class
 * @author Sam Roudgarian
 * @version 1.0
 * created on July 5, 2022
 */
public class MusicLibrary implements FileManager
{
    private HashMap<String, MusicMedia> library;
    public static final String AUDIO_FILE_PREFIX;
    public static final String COMPACT_DISC_PREFIX;
    public static final String VINYL_RECORD_PREFIX;
    public static final String DEFAULT_FILE_NAME;
    public static final String DEFAULT_FILE_PATH;
    static
    {
        AUDIO_FILE_PREFIX = "af";
        COMPACT_DISC_PREFIX ="cd";
        VINYL_RECORD_PREFIX = "vr";
        DEFAULT_FILE_PATH = "src";
        DEFAULT_FILE_NAME = "temporary_file.txt";
    }
    /**
    * constrictor for the music library
    */
    public MusicLibrary()
    {
        library = new HashMap<>();
    }
    /**
     * add the musicMedia selection to the library hashmap
     * @param selection is the musicMedia selection
     */
    public void addMusic(MusicMedia selection)
    {
        if (selection == null) {
            throw new NullPointerException("Invalid Music media selection: null");
        }
        library.put(selection.getSku(), selection);
    }
    public void removeMusic(String sku)
    {
        if (sku == null|| sku.isBlank()) {
            throw new NullPointerException("Invalid Music media selection: null");
        }
        library.remove(sku);
    }
    /**
     * display all the files in the library hashmap
     * use the save() method to copy the current FilePath and FileName
     */
    public void displayLibrary() {

        Set<String> libraryIds = library.keySet();
        for (String libraryId : libraryIds) {
            System.out.println(library.get(libraryId));
            if (library.get(libraryId) instanceof AudioFile) {
                AudioFile audio = (AudioFile) library.get(libraryId);
                audio.save(DEFAULT_FILE_PATH,DEFAULT_FILE_NAME);
            }
        }
    }
    /**
     * display the files in the hashmap that start with the prefix
     * @param prefix the first 2 letter of the file
     */
    public void displayChoice(String prefix)
    {
        Set<String> libraryIds = library.keySet();
        for (String libraryId : libraryIds) {
            if (prefix.equalsIgnoreCase(AUDIO_FILE_PREFIX) && library.get(libraryId) instanceof AudioFile) {
                AudioFile audio = (AudioFile) library.get(libraryId);
                System.out.println(audio);
            } else if (prefix.equalsIgnoreCase(COMPACT_DISC_PREFIX) && library.get(libraryId) instanceof CompactDisc) {
                CompactDisc compactDisc = (CompactDisc) library.get(libraryId);
                System.out.println(compactDisc);
            }else if (prefix.equalsIgnoreCase(VINYL_RECORD_PREFIX) && library.get(libraryId) instanceof VinylRecord) {
                VinylRecord vinylRecord = (VinylRecord) library.get(libraryId);
                System.out.println(vinylRecord);
            }
        }
    }

    public void orderByType(){
        List<MusicMedia> decadeMap = library.entrySet().stream()
                .filter(Objects::nonNull)
                .filter(p->p.getKey()!=null)
                .filter(p -> !p.getKey().trim().isBlank())
                .sorted(Comparator.comparing(p->p.getValue().getSku()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        decadeMap.forEach(p-> System.out.println(p));

    }
    public void orderByTitle(){
    List<MusicMedia> decadeMap = library.entrySet().stream()
            .filter(Objects::nonNull)
            .filter(p->p.getKey()!=null)
            .filter(p -> !p.getKey().trim().isBlank())
            .sorted(Comparator.comparing(p->p.getValue().getTitle()))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
    decadeMap.forEach(p-> System.out.println(p));

    }
    public void orderByArtist(){
        List<MusicMedia> decadeMap = library.entrySet().stream()
                .filter(Objects::nonNull)
                .filter(p->p.getKey()!=null)
                .filter(p -> !p.getKey().trim().isBlank())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        decadeMap.forEach(p-> System.out.println(p));

    }
    public void orderByYear(){
        List<MusicMedia> decadeMap = library.entrySet().stream()
                .filter(Objects::nonNull)
                .filter(p->p.getKey()!=null)
                .filter(p -> !p.getKey().trim().isBlank())
                .sorted(Comparator.comparing(p->p.getValue().getYearReleased()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        decadeMap.forEach(p-> System.out.println(p));

    }

    @Override
    public void save(final String path, final String fileName) {
        File fnew=new File(path+"/"+fileName);
        String s = "";
        Set<String> libraryIds = library.keySet();

        for(String sku: libraryIds) {
            MusicMedia musicMedia = library.get(sku);
            if (musicMedia instanceof AudioFile) {
                AudioFile a = (AudioFile) musicMedia;
                s+=musicMedia +"|" + a.getFileName() + "|" + a.getFileResolution() + "\n" ;
            } else if (musicMedia instanceof CompactDisc) {
                CompactDisc c = (CompactDisc) musicMedia;
                s+= musicMedia + "|" + String.valueOf(c.getNumberOfTracks()) + "\n";
            } else if (musicMedia instanceof VinylRecord) {
                VinylRecord vinyl = (VinylRecord) musicMedia;
                s+= musicMedia + "|" + String.valueOf(vinyl.getNumberOfTracks()) +
                        "|" + String.valueOf(vinyl.getSizeInInches()) + "|" + String.valueOf(vinyl.getWeightInGrams()) + "\n";
            }
        }

        FileWriter f2;

        try {
            //change this line to read this

            // f2 = new FileWriter(fnew,false);

            // to read this
            f2 = new FileWriter(fnew,false); // important part
            f2.write(s);

            // change field back to true so the rest of the new data will
            // append to the new file.


            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(final String path, final String fileName) {
        System.out.println("delete");
    }
}
