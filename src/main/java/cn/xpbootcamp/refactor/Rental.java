package cn.xpbootcamp.refactor;

public class Rental {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    int getDaysRented() {
        return daysRented;
    }

    double amount() {
        double amount = 0d;
        switch (movie.getPriceCode()) {
            case Movie.HISTORY:
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case Movie.CAMPUS:
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }

        return amount;
    }
}
