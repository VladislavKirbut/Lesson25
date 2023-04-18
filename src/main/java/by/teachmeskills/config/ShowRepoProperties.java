package by.teachmeskills.config;

import java.nio.file.Path;
import java.util.Objects;

public class ShowRepoProperties {
    private final Path pathToDir;

    public ShowRepoProperties(Path pathToStore) {
        Objects.requireNonNull(pathToStore);

        this.pathToDir = pathToStore;
    }

    public Path getPathToDir() {
        return pathToDir;
    }
}
