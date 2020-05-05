package cn.xpbootcamp.refactor;

import java.util.ArrayList;
import java.util.Enumeration;

public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    String statement() {
        double totalAmount = 0d;
        // frequent renter points
        int totalPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");

        for (Rental rental : rentals) {
            double amount = rental.amount();
            totalPoints += rental.points();

            //show figures for this rental
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(amount).append("\n");
            totalAmount += amount;
        }

        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(totalPoints).append(" frequent renter points");
        return result.toString();
    }
}
