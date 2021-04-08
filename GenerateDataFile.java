import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
class GenerateDataFile {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);

        System.out.println("How do you like to name the file:");
        String fileName = reader.nextLine();
        System.out.println("Where do you want to store the file:");
        String filePath = reader.nextLine();

        String fileLocation = filePath.concat("\\" + fileName);

        String idValue = "2004";
        String postalCode = "S4D";
        String firstName = "Ubaid";
        String lastName = "Khan";
        String city = "Markham";
        String creditCard = "349876456";

        createDataFile(idValue, postalCode, firstName, lastName, city, creditCard, fileLocation);

        System.out.println("Data file created");

        reader.close();
    }

    public static void createDataFile(String idValue, String postalCode, String firstName, String lastName, String city, String creditCard, String fileLocation) {

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
    }
}