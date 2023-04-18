package by.teachmeskills.model;

import by.teachmeskills.exceptions.IncorrectFormatException;
import by.teachmeskills.exceptions.IncorrectValueException;
import by.teachmeskills.exceptions.InvalidYearException;

import java.time.Year;

public abstract class Show {
    private static final int COUNTRY_CODE_LENGTH = 2;
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 10.0;
    protected final String showName;
    protected final Year releaseYear;
    protected final String countryCode;
    protected final double rating;
    protected final int countOfRatings;

    public Show(String showName, Year releaseYear, String countryCode, double rating, int countOfRatings) {
        if (releaseYear.isBefore(Year.of(0)))
            throw new InvalidYearException("Negative year");
        if (countryCode.length() != COUNTRY_CODE_LENGTH || !isUpperCaseSymbols(countryCode))
            throw new IncorrectFormatException("Incorrect format of country code");
        if (rating < MIN_RATING || rating > MAX_RATING)
            throw new IncorrectValueException("You entered incorrect rating");
        if (countOfRatings < 0)
            throw new IncorrectValueException("You entered incorrect number of ratings");

        this.showName = showName;
        this.releaseYear = releaseYear;
        this.countryCode = countryCode;
        this.rating = rating;
        this.countOfRatings = countOfRatings;

    }

    private boolean isUpperCaseSymbols(String countryCode) {
        for (int i = 0; i < countryCode.length(); i++) {
            if (countryCode.charAt(i) < 'A' || countryCode.charAt(i) > 'Z')
                return false;
        }
        return true;
    }
}
