package by.teachmeskills.model;

import by.teachmeskills.exceptions.IncorrectValueException;
import by.teachmeskills.exceptions.InvalidYearException;

import java.time.Year;

public class Serial extends Show {
    private final Year yearOfLastEpisode;
    private final int countOfSeasons;
    private final int countOfEpisode;
    public Serial(String showName, Year issueYear, String countryCode, double rating, int countOfRatings,
                  Year yearOfLastEpisode, int countOfSeasons, int countOfEpisode) {
        super(showName, issueYear, countryCode, rating, countOfRatings);

        isYearOfLastEpisodeValid(yearOfLastEpisode);
        isCountOfSeasonCorrect(countOfSeasons);
        isCountOfEpisodeValid(countOfEpisode);

        this.yearOfLastEpisode = yearOfLastEpisode;
        this.countOfSeasons = countOfSeasons;
        this.countOfEpisode = countOfEpisode;
    }

    private void isYearOfLastEpisodeValid(Year yearOfLastEpisode) {
        if (yearOfLastEpisode.compareTo(Year.of(0)) <= 0)
            throw new InvalidYearException("Incorrect year of last episode");
    }

    private void isCountOfSeasonCorrect(int countOfSeasons) {
        if (countOfSeasons <= 0)
            throw new IncorrectValueException("Incorrect value of seasons");
    }

    private void isCountOfEpisodeValid(int countOfEpisode) {
        if (countOfEpisode <= 0)
            throw new IncorrectValueException("Incorrect value of episode");
    }

    public Year getYearOfLastEpisode() {
        return yearOfLastEpisode;
    }

    public int getCountOfSeasons() {
        return countOfSeasons;
    }

    public int getCountOfEpisode() {
        return countOfEpisode;
    }
}
