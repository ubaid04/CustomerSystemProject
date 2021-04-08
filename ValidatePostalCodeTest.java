import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class ValidatePostalCodeTest {
    public static void main(String[] args){
        String postalCode = "T4L";
        boolean found = false;
        found = read(found,postalCode);
        // If it prints out true, it means it is working as the postal code above is in the csv file
        System.out.println(found); 
    }

    public static boolean read(boolean found, String postalCode){
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
}