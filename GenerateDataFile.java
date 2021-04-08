//Importing required java packages
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
class GenerateDataFile {
    public static void main(String[] args) {
        //Initializing scanner
        Scanner reader = new Scanner(System.in);
        
        //Asking for file location
        System.out.println("How do you like to name the file:");
        String fileName = reader.nextLine();
        System.out.println("Where do you want to store the file:");
        String filePath = reader.nextLine();

        String fileLocation = filePath.concat("\\" + fileName);
        
        //setting necessary variables
        String idValue = "2004";
        String postalCode = "S4D";
        String firstName = "Ubaid";
        String lastName = "Khan";
        String city = "Markham";
        String creditCard = "349876456";
        
        //calling method
        createDataFile(idValue, postalCode, firstName, lastName, city, creditCard, fileLocation);
        
        //Letting user know that the file was created
        System.out.println("Data file created");

        reader.close();
    }

    public static void createDataFile(String idValue, String postalCode, String firstName, String lastName, String city, String creditCard, String fileLocation) {

        try{
            //Create file with the given information
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
        
        //handle any errors
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}