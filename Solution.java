import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Solution {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static ArrayList<String> ReadFile(String filename) {
        ArrayList<String> list = new ArrayList<>();

        try {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            list.add(data);
            // System.out.println(data);
        }
        myReader.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> myList = ReadFile("1.txt");

        String grid = myList.get(2);

        int len = grid.length();

        ArrayList<String> temp = new ArrayList<>();
        int  i = 0;
        while(i < len) {

            String number = "";
            for(int j = 0; j < 3; j++) {
                number += grid.charAt(i);
                i++;
            }

            temp.add(number);
        }

        //System.out.println(temp);

        int cnt = 0;
        for(int row = 0; row < 15; row++) {
            for (int col = 0; col < 30; col++) {

                int n = Integer.parseInt( temp.get(cnt) );

                if (n >= 176 && n <= 255) System.out.print( ANSI_YELLOW + "111 " + ANSI_RESET);
                else System.out.print("000 ");
                cnt++;
            }
            System.out.println("\n");
        }
    }
}