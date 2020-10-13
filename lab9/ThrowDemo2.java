package lab9;

import java.util.Scanner;

public class ThrowDemo2 {
    public void getKey() throws Exception {
        Scanner myScanner = new Scanner( System.in );
        String key = myScanner.nextLine();
        printDetails( key );
    }
    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println( message );
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}
