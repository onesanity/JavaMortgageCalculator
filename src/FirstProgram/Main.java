package FirstProgram;

import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create scanner object to obtain the input from users

        int principal = 0; //INT allows us to store values up to 2 billion
        float annualInterest = 0;
        byte years = 0;

        //Principal ($1k - $1M)
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            System.out.print("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            //get this as a byte
            //because the max number we want to store is 30
            //based on the number of years, we calculate the number of payments
            if (years >= 1 && years <= 30)
                break;
            System.out.print("Enter a value between 1 and 30");
        }

        //call calculateMortgage in this main method

       double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }

    public static double calculateMortgage(
            int principal,
            float annualInterest,
            byte years) {
        //declare constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        //once we obtain all data, we calculate the mortgage
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return mortgage;
    }
}
