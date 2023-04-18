package by.teachmeskills.repository;

import by.teachmeskills.config.ShowRepoProperties;
import by.teachmeskills.model.Show;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ShowFileRepository implements ShowRepository {

    private static final Path MOVIE_PATH = Path.of("films.csv");
    private static final Path SERIAL_PATH = Path.of("series.csv");
    private final ShowRepoProperties properties;

    public ShowFileRepository(ShowRepoProperties properties) {
        this.properties = properties;
    }

    @Override
    public List<Show> getAllShow() {
        List<Show> show = new ArrayList<>();
        getShow(show, MOVIE_PATH, new MovieDeserializer());
        getShow(show, SERIAL_PATH, new SeriesDeserializer());
        return show;
    }

    private void getShow(List<Show> showList, Path path, ShowDeserializer deserializer) {
        List<String> csvLines;

        path = properties.getPathToDir().resolve(path);
        try {
            csvLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }

        for (String line: csvLines) {
            Show show = deserializer.deserialize(line);
            showList.add(show);
        }
    }

}
