//Import java packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
 
 class UbaidWork {
     public static void main(String[] args) {
          //Setting necessary variables
        String postalCode = "T4L";
        boolean found = false;
        
        //calling method
        found = read(found,postalCode);
        // If it prints out true, it means it is working as the postal code above is in the csv file
        System.out.println(found); 

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
     /*
    * Overview: This method will check to see if the user postal code is real or not
    * @parameters: boolean found, String postalCode
    * return: This method will return boolean found
    */
    public static boolean read(boolean found, String postalCode){
        BufferedReader objReader = null;
        //file location 
        String fileName = "postal_codes.csv";
        String filePath = "C:\\Users\\Ubaid Khan\\Downloads\\";

        try{
            String currentLine;
            //Setting what file to read
            objReader = new BufferedReader(new FileReader(filePath + fileName));
            //reading file line by line
            while((currentLine = objReader.readLine()) != null) {
                //if line starts with the given postal code
                if(currentLine.startsWith(postalCode)) {
                    found = true;
                }
            }
        }
        
        //handle any errors
        catch(IOException e) {
            e.printStackTrace();
        }

        finally{
            try{
                if(objReader != null) {
                    //close reader
                    objReader.close();
                }
            }
            //handle any errors
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        //return if the postal code was real or not
        return found;
    }

     /*
    * Overview: This method will create a data file
    * @parameters: String idValue, String postalCode, String firstName, String lastName, String city, String creditCard, String fileLocation
    * return: This method will not return as it is a void method
    */
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
