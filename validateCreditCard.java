/*
 * Date: April 8, 2021
 * Name: Muhammad Tagari
 * Teacher: Mr.Ho
 * Description: Validates Credit Card
 */

class validateCreditCard{
public static void main(String [] args){
    // Variable for the Credit Card Number
    String creditCard = "56565";
    // Checks to see if it's valid using Luhn
    System.out.println(checkLuhn(creditCard));
}
/*
 * @param - String credit card, using boolean to say if it's valid or not (true or false)
 * @return - returns either true or false
 */
    private static boolean checkLuhn(String creditCard) {
        // Variable for the credit card number length
        int cardlength = creditCard.length();
        // Variable for even, odd and sum
        int evenSum = 0, oddSum = 0, sum;
        // For loop that allows for Luhn to check 
        for (int i = creditCard - 1; i >= 0; i--) {
            System.out.println(creditCard.charAt(i));
            int digit = Character.getNumericValue(creditCard.charAt(i));
            if (i % 2 == 0) {
                int multiplyByTwo = digit * 2;
                if (multiplyByTwo > 9) {
                    /* Add two digits to handle cases that make two digits after doubling */
                    String mul = String.valueOf(multiplyByTwo);
                    multiplyByTwo = Character.getNumericValue(mul.charAt(0)) + Character.getNumericValue(mul.charAt(1));
                }
                evenSum += multiplyByTwo;
            } else {
                oddSum += digit;
            }
        }
        sum = evenSum + oddSum;
        if (sum % 10 == 0) {
            System.out.println("valid card");
            return true;
        } else {
            System.out.println("invalid card");
            return false;
        }

    }
}
