package by.teachmeskills.repository;

import by.teachmeskills.model.Serial;
import by.teachmeskills.model.Show;

import java.time.Year;

public class SeriesDeserializer implements ShowDeserializer {
    @Override
    public Show deserialize(String line) {
        String[] csvLine = line.split(",");

        return new Serial(csvLine[0],
                Year.of(Integer.parseInt(csvLine[1])),
                Year.of(Integer.parseInt(csvLine[2])),
                csvLine[3],
                Integer.parseInt(csvLine[4]),
                Integer.parseInt(csvLine[5]),
                Double.parseDouble(csvLine[6]),
                Integer.parseInt(csvLine[7])
        );
    }
}
