// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray

import java.util.Scanner;
// More packages may be imported in the space below
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

class CustomerSystem{
    public static void main(String[] args){
        // Please do not edit any of these variables
        Scanner reader = new Scanner(System.in);
        String userInput, enterCustomerOption, generateCustomerOption, exitCondition;
        enterCustomerOption = "1";
        generateCustomerOption = "2";
        exitCondition = "9";

        // More variables for the main may be declared in the space below


        do{
            printMenu();                                    // Printing out the main menu
            userInput = reader.nextLine();                  // User selection from the menu

            if (userInput.equals(enterCustomerOption)){
                // Only the line below may be editted based on the parameter list and how you design the method return
		        // Any necessary variables may be added to this if section, but nowhere else in the code
                enterCustomerInfo();
            }
            else if (userInput.equals(generateCustomerOption)) {
                // Only the line below may be editted based on the parameter list and how you design the method return
                //Call the method which is responsible for making a csv file
                generateCustomerDataFile();
            }
            else{
                System.out.println("Please type in a valid option (A number from 1-9)");
            }

        } while (!userInput.equals(exitCondition));         // Exits once the user types 
        
        reader.close();
        System.out.println("Program Terminated");
    }
    public static void printMenu(){
        System.out.println("Customer and Sales System\n"
        .concat("1. Enter Customer Information\n")
        .concat("2. Generate Customer data file\n")
        .concat("3. Report on total Sales (Not done in this part)\n")
        .concat("4. Check for fraud in sales data (Not done in this part)\n")
        .concat("9. Quit\n")
        .concat("Enter menu option (1-9)\n")
        );
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void enterCustomerInfo() {
    }
    /*
    * Overview: This method will takes the postalCode and check if it is real or is it fake
    * @parameters:boolean found,String postalCode
    * @return: It will return a boolean
    */
    public static boolean validatePostalCode(boolean found, String postalCode){
        BufferedReader objReader = null;
        //The file to look for and read from
        String fileName = "postal_codes.csv";
        String filePath = "C:\\Users\\Ubaid Khan\\Downloads\\";
        try{
            String currentLine;
            objReader = new BufferedReader(new FileReader(filePath + fileName));

            //Read the file line to line 
            while((currentLine = objReader.readLine()) != null) {
                //Check to see if the line starts with the given postal code
                if(currentLine.startsWith(postalCode)) {
                    found = true;
                }
            }
        }
        //This will sort out any given errors and exceptions
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                //Close reader
                if(objReader != null) {
                    objReader.close();
                }
            }
            //Handle any errors that occur
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        //Return if the postal code was real or not
        return found;
    }
    /*
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void validateCreditCard(){
    }
    /*
    * Overview: This method will create a customer file which contains all their data
    * @parameters: no parameters
    * @return: it returns nothing at it is a void method
    */
    public static void generateCustomerDataFile(){
        //Initialize and declare Scanner
        Scanner reader = new Scanner(System.in);

        //Ask where the user wants to store the file
        System.out.println("How do you like to name the file:");
        String fileName = reader.nextLine();
        System.out.println("Where do you want to store the file:");
        String filePath = reader.nextLine();

        String fileLocation = filePath.concat("\\" + fileName);
        
        //Creating a unique id value with using the uniqueCustomerValue method
        String idValue = "";
        idValue = uniqueCustomerValue(idValue);

        //Ask required information to create a csv file
        System.out.println("Postal code:");
        String postalCode = reader.nextLine();
        System.out.println("First name:");
        String firstName = reader.nextLine();
        System.out.println("Last name:");
        String lastName = reader.nextLine();
        System.out.println("City:");
        String city = reader.nextLine();
        System.out.println("Credit Card");
        String creditCard = reader.nextLine();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation));
            //Write the information in the file
            bw.write("ID value,First Name,Last Name,City,Postal Code,Credit Card Number \n");
            bw.write(idValue + ",");
            bw.write(firstName + ",");
            bw.write(lastName + ",");
            bw.write(city + ",");
            bw.write(postalCode + ",");
            bw.write(creditCard + ",");
            bw.close();
        }

        //Handle any errors
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        //Letting the user know that the file was created successfully
        System.out.println("Data file created");

    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    /*
    * Overview: This method will craete a unique id to every customer
    * @Parameters: String idValue
    * @return: idValue
    */
    public static String uniqueCustomerValue(String idValue){
        UUID uniqueId = UUID.randomUUID();
        String id = ("1" + uniqueId);
        
        return id;
    }
}