package by.teachmeskills.repository;

import by.teachmeskills.model.Show;

public interface ShowDeserializer {

    Show deserialize(String line);
}
