import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FilesManager {

    private static final String SAVED_FILES = "saved_files";


    public static String saveTextFile(String text) {
        File savedFilesDir = new File(SAVED_FILES);

        boolean isDirReady = savedFilesDir.exists();

        if (!isDirReady) {
            isDirReady = savedFilesDir.mkdir();
        }

        String fileName = new SimpleDateFormat("dd-mm-yyyy:HH-mm-ss").format(new Date()) + ".txt";


        File textFile = new File(savedFilesDir.getAbsolutePath() + File.separator + fileName);

        FileWriter fileWriter = null;

        String savedFileAdbsolutePath = null;

        try {
            boolean isTextFileCreated = textFile.exists();

            if (!isTextFileCreated) {
                isTextFileCreated = textFile.createNewFile();
            }

            if (isTextFileCreated) {
                savedFileAdbsolutePath = textFile.getAbsolutePath();
                fileWriter = new FileWriter(savedFileAdbsolutePath);

                fileWriter.write(text);
            }

            System.out.println("File saved!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not saved!");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return savedFileAdbsolutePath;
    }

    public static String readTextFile(String fileAbsolutePath) {
        File textFile = new File(fileAbsolutePath);

        StringBuilder stringBuilder = new StringBuilder();

        if (textFile.exists()) {
            FileReader fileReader = null;
            Scanner scanner = null;

            try {
                fileReader = new FileReader(textFile);
                scanner = new Scanner(fileReader);


                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    stringBuilder.append(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }

        return null;
    }

    public static List<String> getSavedFilesAbsolutePath() {
        List<String> savedFilesAbsolutePath = new ArrayList<>();

        File savedFilesDir = new File(SAVED_FILES);

        File[] savedFiles = savedFilesDir.listFiles();

        if (savedFiles != null) {
            for (File savedFile: savedFiles) {
                savedFilesAbsolutePath.add(savedFile.getAbsolutePath());
            }
        }

        if (!savedFilesAbsolutePath.isEmpty()) {
            return savedFilesAbsolutePath;
        }

        return null;

    }
}
