// Throughout this project, the use of data structures are not permitted such as methods like .split and .toCharArray




import java.util.Scanner;
// More packages may be imported in the space below
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

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
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static boolean validatePostalCode(boolean found, String postalCode){
        BufferedReader objReader = null;
        String fileName = "postal_codes.csv";
        String filePath = "C:\\Users\\Ubaid Khan\\Downloads\\";
        try{
            String currentLine;
            objReader = new BufferedReader(new FileReader(filePath + fileName));

            while((currentLine = objReader.readLine()) != null) {
                if(currentLine.startsWith(postalCode)) {
                    found = true;
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(objReader != null) {
                    objReader.close();
                }
            }
            
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }

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
    * This method may be edited to achieve the task however you like.
    * The method may not nesessarily be a void return type
    * This method may also be broken down further depending on your algorithm
    */
    public static void generateCustomerDataFile(){
       
        Scanner reader = new Scanner(System.in);
        System.out.println("How do you like to name the file:");
        String fileName = reader.nextLine();
        System.out.println("Where do you want to store the file:");
        String filePath = reader.nextLine();

        String fileLocation = filePath.concat("\\" + fileName);
        
        String idValue = "";
        idValue = uniqueCustomerValues(idValue);
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
            bw.write("ID value,First Name,Last Name,City,Postal Code,Credit Card Number \n");
            bw.write(idValue + ",");
            bw.write(firstName + ",");
            bw.write(lastName + ",");
            bw.write(city + ",");
            bw.write(postalCode + ",");
            bw.write(creditCard + ",");
            bw.close();
        }

        catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Data file created");

        reader.close();
    }
    /*******************************************************************
    *       ADDITIONAL METHODS MAY BE ADDED BELOW IF NECESSARY         *
    *******************************************************************/

    public static String uniqueCustomerValues(String idValue){
    }
}