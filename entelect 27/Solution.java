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

        boolean found_grid = false;
        while (myReader.hasNextLine()) {
            String strData = myReader.nextLine();

            String [] arrData = strData.split("=", 2);

            if (arrData[0].equals("map_size")) {
                System.out.println("found Grid!");
                found_grid = true;
                continue;
            }

            if (found_grid) list.add(strData);

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
        ArrayList<String> arrGrid = ReadFile("map.txt");

        int row = 3, col = 5;
        String [][] matrixGrid = new String[row][col];

        for (int i = 0 ; i < arrGrid.size(); i++) {
            String element = arrGrid.get(i);

            String [] eleArr = element.split(",", col);

            for (int j = 0; j < eleArr.length; j++) {
                // System.out.println(eleArr[j]);

                matrixGrid[i][j] = eleArr[j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                System.out.print(matrixGrid[i][j] + " ");
            }
            System.out.println();
        }

    }
}