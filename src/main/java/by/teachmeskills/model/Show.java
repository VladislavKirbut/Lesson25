package by.teachmeskills.model;

import by.teachmeskills.exceptions.IncorrectFormatException;
import by.teachmeskills.exceptions.IncorrectLengthOfParameterException;
import by.teachmeskills.exceptions.IncorrectValueException;
import by.teachmeskills.exceptions.InvalidYearException;

import java.time.Year;

public abstract class Show {
    private static final int COUNTRY_CODE_LENGTH = 2;
    private static final double MIN_RATING = 0.0;
    private static final double MAX_RATING = 10.0;
    private final String showName;
    private final Year issueYear;
    private final String countryCode;
    private final double rating;
    private final int countOfRatings;

    public Show(String showName, Year issueYear, String countryCode, double rating, int countOfRatings) {
        isIssueYearValid(issueYear);
        isCountryCodeValid(countryCode);
        isRatingValid(rating);
        isCountOfRatingsCorrect(countOfRatings);

        this.showName = showName;
        this.issueYear = issueYear;
        this.countryCode = countryCode;
        this.rating = rating;
        this.countOfRatings = countOfRatings;

    }

    private void isIssueYearValid(Year year) {
        if (year.isBefore(Year.of(0)))
            throw new InvalidYearException("Negative year");
    }

    private void isCountryCodeValid(String countryCode) {
        if (countryCode.length() != COUNTRY_CODE_LENGTH)
            throw new IncorrectLengthOfParameterException("Incorrect country code length");

        if (!isUpperCaseSymbols(countryCode))
            throw new IncorrectFormatException("Incorrect format of country code");
    }

    private void isRatingValid(double rating) {
        if (rating < MIN_RATING || rating > MAX_RATING)
            throw new IncorrectValueException("You entered incorrect rating");
    }

    private void isCountOfRatingsCorrect(int countOfRatings) {
        if (countOfRatings < 0)
            throw new IncorrectValueException("You entered incorrect number of ratings");
    }
    private boolean isUpperCaseSymbols(String countryCode) {
        for (int i = 0; i < countryCode.length(); i++) {
            if (countryCode.charAt(i) < 'A' || countryCode.charAt(i) > 'Z')
                return false;
        }

        return true;
    }

    public String getShowName() {
        return showName;
    }

    public Year getIssueYear() {
        return issueYear;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getRating() {
        return rating;
    }

    public int getCountOfRatings() {
        return countOfRatings;
    }
}
