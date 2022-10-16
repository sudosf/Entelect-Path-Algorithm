import java.io.*;  // Import the File class


public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("jason.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    try {
        FileWriter myWriter = new FileWriter("jason.txt");
        myWriter.write("{   “Party”: [“Scout”, “Gatherer”],  " + "\n" + "    “Path”: [[0,0], [0,1], [0,2], [0,3], [1,3], [2,3], [2,4]]" + "\n" + "}");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
  }
}
