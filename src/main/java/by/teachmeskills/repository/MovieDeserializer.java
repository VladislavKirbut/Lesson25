package by.teachmeskills.repository;

import by.teachmeskills.model.Movie;
import by.teachmeskills.model.Show;

import java.time.Year;

public class MovieDeserializer implements ShowDeserializer {
    @Override
    public Show deserialize(String line) {
        String[] csvLine = line.split(",");
        return new Movie(csvLine[0],
                         Year.of(Integer.parseInt(csvLine[1])),
                         csvLine[2],
                         Double.parseDouble(csvLine[3]),
                         Integer.parseInt(csvLine[4])
        );
    }
}
