package FirstProgram;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //declare constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        //create scanner object to obtain the input from users

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt(); //INT allows us to store values up to 2 billion

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat(); //obtain the annual interest
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte(); //get this as a byte
        //because the max number we want to store is 30
        //based on the number of years, we calculate the number of payments
        int numberOfPayments = years * MONTHS_IN_YEAR;

        //once we obtain all data, we calculate the mortgage
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        //after you calculate the mortgage,
        //we use the number format class to get the currency

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);


    }
}
