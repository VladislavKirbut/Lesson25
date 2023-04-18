package by.teachmeskills.model;

import by.teachmeskills.exceptions.IncorrectValueException;
import by.teachmeskills.exceptions.InvalidYearException;

import java.time.Year;

public class Serial extends Show {
    private final Year yearOfLastEpisode;
    private final int countOfSeasons;
    private final int countOfEpisode;
    public Serial(String showName, Year releaseYear, Year yearOfLastEpisode, String countryCode, int countOfSeasons,
                  int countOfEpisode, double rating, int countOfRatings) {
        super(showName, releaseYear, countryCode, rating, countOfRatings);

        if (yearOfLastEpisode.isBefore(Year.of(0)))
            throw new InvalidYearException("Incorrect year of last episode");
        if (countOfSeasons <= 0 || countOfEpisode <= 0)
            throw new IncorrectValueException("Incorrect value of episode or season");

        this.yearOfLastEpisode = yearOfLastEpisode;
        this.countOfSeasons = countOfSeasons;
        this.countOfEpisode = countOfEpisode;
    }

    @Override
    public String toString() {
        return "{Serial} %-50s %5s-%s %s %s %s %3s %3s".formatted(showName, releaseYear, yearOfLastEpisode, countryCode,
                countOfSeasons, countOfEpisode, rating, countOfRatings);
    }
}
