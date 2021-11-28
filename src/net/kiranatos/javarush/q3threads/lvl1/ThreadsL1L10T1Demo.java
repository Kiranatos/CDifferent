package net.kiranatos.javarush.q3threads.lvl1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import net.kiranatos.OzoHelper;
import net.kiranatos.javarush.q3threads.lvl1.ThreadsL1L10T1.Solution;

/* Demo class for ThreadsL1L10T1 */
public class ThreadsL1L10T1Demo {
    private static final String PATH_TO_FOLDER = "wfiles\\javarush\\q3\\lvl1";
    private static final String NAMES_OF_FILES = "ThreadsL1L10T1%d.txt";
    private static final String PATH_TO_FILE = "wfiles\\javarush\\q3\\lvl1\\info.txt";
    public static void main(String[] args) throws IOException {
        File[] files = OzoHelper.createFewFiles(PATH_TO_FOLDER, NAMES_OF_FILES, 20, 50);
        ThreadsL1L10T1Demo test = new ThreadsL1L10T1Demo();
        String pathToArchive = test.archiveFileInZip(files, PATH_TO_FOLDER, "%dL1L10T1.txt");
        
        Solution.writeZipEntriesToFile(pathToArchive, PATH_TO_FILE);
    }
    
    public String archiveFileInZip(File[] files, String pathToArchive, String entryMask) {        
        File archivePath = new File(pathToArchive, "L1L10T1.zip");
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archivePath))) {             
            for (int i = 0; i < files.length; i++) {
                FileInputStream fis = new FileInputStream(files[i]);
                String nameZipEntryFile = String.format(entryMask, i);
                ZipEntry ent = new ZipEntry(nameZipEntryFile);
                zout.putNextEntry(ent);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception ex) { System.out.println(ex.getMessage()); }
        return archivePath.getAbsolutePath();
    }
}
