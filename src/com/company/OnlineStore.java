package com.company;
import javax.swing.JOptionPane;
public class OnlineStore {

    public boolean validateCreditCard(String string_credit) {

        //The length of the credit card
        final int LENGTH_CREDIT_NUMBER = 16;
        final int TEN = 10;
        final int TWO = 2;
        final int ZERO = 0;
        final int FORTY_EIGHT = 48;
        final int FIFTY_SEVEN = 57;

        //Checks if the credit number entered by user is exactly 16 digitsqq
        if(string_credit.length() != LENGTH_CREDIT_NUMBER) {
            return false;
        }

        //Initialization of credit card array
        int[] credit_card = new int[LENGTH_CREDIT_NUMBER];

        //To hold the sum
        int checksum = ZERO;

        // For loop to convert string value into integer and then insert into the array
        for(int i = ZERO; i < string_credit.length(); i++) {
            //Checks to see if the characters have ASCII numbers of digits between 0 and 9
            if(string_credit.charAt(i) < FORTY_EIGHT || string_credit.charAt(i) > FIFTY_SEVEN) {
                return false;
            }
            //Converts the string value to integer
            credit_card[i] = Integer.parseInt(String.valueOf(string_credit.charAt(i)));

            //To double the digits at the even index
            if(i % TWO == ZERO){
                credit_card[i] = credit_card[i] * TWO;
            }
            //To sum up numbers greater than 10
            if(credit_card[i] >= TEN ) {
                checksum = credit_card[i]/TEN + (credit_card[i])%TEN + checksum;
            }
            //To sum up numbers less than 10
            else {
                checksum = credit_card[i] + checksum;
            }
        }
        //Returns the boolean value of if checksum is multiple of 10
        return (checksum % TEN == ZERO);
    }

    public static void main(String[] args) {

        //String value that holds the input from input dialog
        String strvalue = JOptionPane.showInputDialog(null,"Enter credit card number: ");

        //Checks to if strvalue is equal to null
        if(strvalue == null) {
            return;
        }
        //Initializing of OnlineStore class
        OnlineStore credit_number = new OnlineStore();

        //Checks if the credit card is valid and gives a message in the showMessageDialog
        if(credit_number.validateCreditCard(strvalue)) {
            JOptionPane.showMessageDialog(null, "The credit card is valid");
        }
        else {
            JOptionPane.showMessageDialog(null,"The credit card is not valid");
        }
    }
}
