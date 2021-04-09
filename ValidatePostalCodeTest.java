//Import java packages
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class ValidatePostalCodeTest {
    public static void main(String[] args){
        //Setting necessary variables
        String postalCode = "T4L";
        boolean found = false;
        
        //calling method
        found = read(found,postalCode);
        // If it prints out true, it means it is working as the postal code above is in the csv file
        System.out.println(found); 
    }
    
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
}