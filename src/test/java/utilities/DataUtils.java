package utilities;

import java.util.Random;

public class DataUtils {
    /*
    *This method will generate random emails.
    * Ex:
    * . getRandomEmail(); -> return "encwnnc@gmail.com"
     */
    public static String getRandomEmail(){
        /// abc 333765353
        String email = "abc";
        Random random = new Random();
        int number = random.nextInt(10000);
        return email+number+"@gmail.com"; //"abc1234@gmail.com";


    }

}
