import java.util.ArrayList;
import java.util.List;

public class Main {


    private static final String USER_TEXT = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum maximus porta est. Curabitur eu nibh et nisl maximus dapibus. Nunc gravida diam eu magna posuere, et viverra lorem faucibus. Etiam ex est, cursus vulputate velit id, iaculis molestie diam. Nulla nec imperdiet ipsum, vitae tempus sem. Nam ut maximus eros. Pellentesque a gravida dui. Ut posuere cursus euismod. Proin id ex at diam ullamcorper euismod. Sed ultrices ut ligula sit amet vehicula. Etiam tincidunt, velit et dictum faucibus, urna ipsum tristique massa, et fermentum enim elit nec dui. Nam ultricies porta tellus. Aliquam pharetra nec risus eu rutrum. Phasellus eget tellus eu ligula porta pretium. Suspendisse nec elementum ligula. Etiam odio erat, vehicula in massa ut, hendrerit euismod felis.\n" +
            "\n" +
            "Aliquam hendrerit rhoncus justo sed porta. Aenean rutrum mi vel odio dignissim elementum. In pretium in sem quis aliquet. Proin id lectus vitae leo cursus auctor. Mauris posuere eget ligula eget ultrices. Aenean vel faucibus est, et cursus est. Nunc nec lacinia massa. Sed bibendum turpis suscipit dolor varius eleifend. Mauris libero sem, elementum id efficitur ut, dignissim in libero. ";


    public static void main(String[] args) {
        String savedFileAbsolutePath = FilesManager.saveTextFile(USER_TEXT);
        System.out.println(savedFileAbsolutePath);


        List<String> savedFilesAbsolutePath = FilesManager.getSavedFilesAbsolutePath();

        if (savedFileAbsolutePath != null) {
            for (String fileAbsolutePath: savedFilesAbsolutePath) {
                System.out.println(fileAbsolutePath + "\n");

                String fileContent = FilesManager.readTextFile(savedFileAbsolutePath);

                if (fileContent != null) {
                    System.out.println(fileContent);
                }
            }
        }

    }
}
