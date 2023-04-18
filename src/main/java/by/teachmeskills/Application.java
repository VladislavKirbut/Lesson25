package by.teachmeskills;

import by.teachmeskills.config.ShowRepoProperties;
import by.teachmeskills.model.Show;
import by.teachmeskills.repository.ShowFileRepository;

import java.nio.file.Path;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Path path = Path.of(System.getenv("DATA_DIR"));
        ShowRepoProperties properties = new ShowRepoProperties(path);
        ShowFileRepository repository = new ShowFileRepository(properties);

        List<Show> showList = repository.getAllShow();
        for (Show show: showList) {
            System.out.println(show);
        }
    }
}
