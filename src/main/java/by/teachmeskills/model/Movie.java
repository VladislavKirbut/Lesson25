package by.teachmeskills.model;

import java.time.Year;

public class Movie extends Show {
    public Movie(String showName, Year issueYear, String countryCode, double rating, int countOfRatings) {
        super(showName, issueYear, countryCode, rating, countOfRatings);
    }
}
