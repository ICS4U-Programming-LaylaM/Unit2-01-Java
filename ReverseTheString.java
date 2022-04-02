import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This program reads a file and creates a new file
* with the reversed strings of the original file.
*
* @author Layla Michel
* @version 1.0
* @since 2022-03-31
*/

class ReverseTheString {
    static String[] reversedArray;
    static String[] charsArray;
    static int counter;
    static String chars;
    static String reverseStr;

    /**
    * Creating private constructor due to
    * public/default constructor error.
    *
    * @throws IllegalStateException if there is an issue
    */
    private ReverseTheString() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Creating function to generate random marks for each
    * student into a 2d array.
    *
    * @param strings as string
    *
    * @return strings as string
    */
    public static String reverse(String strings) {
        String newString = strings;
        if (!"".equals(newString)) {
            newString = reverse(newString.substring(0 + 1))
                + newString.substring(0, 1);
        }

        return newString;
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    * @throws IOException if no file is passed in
    */
    public static void main(String[] args)
            throws IOException {

        // Create list to get the strings
        final List<String> listOfChars =
            new ArrayList<String>();

        BufferedReader bf = null;
        try {
            // Check if there are some arguments
            if (null != args[0]
                // Length > 4 because a.txt will be shortest filename
                && args[0].length() > 4
                // Check if arguments have the correct file extension
                && args[0].endsWith(".txt")) {
                bf = new BufferedReader(new FileReader(args[0]));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        String line = bf.readLine();

        // Add file elements to list
        while (line != null) {
            listOfChars.add(line);
            line = bf.readLine();
        }

        // Create array of chars of the size of the list
        charsArray = listOfChars.toArray(new String[0]);

        final List<String> reversedString =
            new ArrayList<String>();

        try {
            for (counter = 0; counter < charsArray.length; counter++) {
                chars = reverse(charsArray[counter]);
                reversedString.add(chars);
            }

            reversedArray = reversedString.toArray(new String[0]);

            // Build a string containing the elements of the 2d array
            final StringBuilder builder = new StringBuilder();
            for (counter = 0; counter < reversedArray.length; counter++) {
                builder.append(reversedArray[counter]);
                builder.append("\n");
            }

            // Create new file called "output.txt"
            final BufferedWriter writer = new BufferedWriter(new
                    FileWriter("/home/ubuntu/"
                + "environment/ISC4U/Unit2/Unit2-01/Unit2-01-Java/output.txt"));
            writer.write(builder.toString());
            writer.close();
            System.out.println("Reversed strings added to 'output.txt'");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
