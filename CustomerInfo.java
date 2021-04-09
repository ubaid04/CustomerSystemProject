/*
 * Name: Muhammad Tagari
 * Date: April 8, 2021
 * Teacher: Mr.Ho
 * Description: Stores Customer Information (First Name, Last Name, City)
 */ 
// Imports Scanner
import java.util.Scanner;

class CustomerInfo {
    public static void main(String [] args){

        // Promps the method back to the main 
        enterCustomerInfo();

    }
    /*
     * @param enterCustomerInfo allows user to input their information
     */
    public static void enterCustomerInfo(){

        // Initializes Scanner
        Scanner reader = new Scanner (System.in);

        // Promps user for their first name, last name, city, postal code, and credit card number and stores it in a variable
        System.out.println("What is your first name?");
        String firstName = reader.nextLine();
        
        System.out.println("What is your last name?");
        String lastName = reader.nextLine();

        System.out.println("What city do you live in?");
        String city = reader.nextLine();

        System.out.println("What is your postal code?");
        String postalCode = reader.nextLine();

        System.out.println("What is your credit card number?");
        String creditCard = reader.nextLine();

        // Closes Scanner
        reader.close();
    }
}