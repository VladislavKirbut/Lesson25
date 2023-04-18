package by.teachmeskills.model;

import java.time.Year;

public class Movie extends Show {
    public Movie(String showName, Year releaseYear, String countryCode, double rating, int countOfRatings) {
        super(showName, releaseYear, countryCode, rating, countOfRatings);
    }

    @Override
    public String toString() {
        return "{Movie}  %-35s %20s %2s %s %5s".formatted(showName, releaseYear, countryCode, rating, countOfRatings);
    }
}
