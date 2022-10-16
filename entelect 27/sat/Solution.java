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
        ArrayList<String> arrGrid = ReadFile("2.txt");

        int row = 12, col = 20;
        String [][] matrixGrid = new String[row][col];

        for (int i = 0 ; i < arrGrid.size(); i++) {
            String element = arrGrid.get(i);
            String [] eleArr = element.split(",", col);

            for (int j = 0; j < eleArr.length; j++) {
                // System.out.println(eleArr[j]);
                matrixGrid[i][j] = eleArr[j];
            }
        }

        int [][] target_path = {{2,3},
                                {3,15},
                                {3,17},
                                {4,13},
                                {10,7},
                                {11,19}};

        int target_row = 2, target_col = 3;

        int next_path_row = 0;
        int next_path_col = 0;

        int track_row = 0, track_col = 0;
        for (int i = track_row; i <= target_row; i++) {
            String result = "";
            boolean found_path = false;
            for (int j = track_col; j <= target_col; j++){
                String above = "", below = "", right = "", left = "";

                System.out.print(matrixGrid[i][j] +"["+ i + ","+ j + "] ");

                // check below
                if (i + 1 < row) {
                    below = matrixGrid[i+1][j];

                    if (i+1 == target_row) {
                        track_row = target_row;
                       // System.out.print(matrixGrid[i][j] +"["+ i + ","+ j + "] ");
                    }
                }

                // check right
                if (j - 1 >= 0) {
                    right = matrixGrid[i][j-1];

                    if (j-1 == target_col) {
                        track_col = target_col;
                        //System.out.print(matrixGrid[i][j] +"["+ i + ","+ j + "] ");
                        }
                }

                // check left
                if (j + 1 < col) {
                    left = matrixGrid[i][j+1];

                    if (j+1 == target_col) {
                        track_col = target_col;
                        System.out.print( ".....,"+ j + "] ");
                    }
                }

                if ( foundTarget(i, j, target_row, target_col) ) {

                    System.out.print( ANSI_YELLOW +
                    matrixGrid[i][j] +"["+ i + ","+ j + "] "
                    + ANSI_RESET);

                    next_path_row++;
                    target_row = target_path[next_path_row][next_path_col];
                    target_col = target_path[next_path_row][next_path_col + 1];
                    // break;

                    // check below
                    if (i == target_row) {
                        track_row = target_row;
                        track_col = j;
                        System.out.print(matrixGrid[i][j] +"["+ i + ","+ j + "] ");
                    } else {
                        i++;
                        track_col = j;
                        System.out.print(matrixGrid[i][j] +"["+ i + ","+ j + "] ");
                        }

                    found_path = true;
                    // continue;
                } else {
                }

                // track_col++;
            }
           // track_row++;
            System.out.println();
        }
    }

    public static boolean foundTarget(int row, int col, int target_row, int target_col) {

        return row == target_row && col == target_col;
    }
}