package codejam.common;

import java.util.Scanner;

public interface GoogleJamTemplate {
   /**
    * Reads input from scanner for the current test case,
    * prepares the result in string
    */
   String resolve(Scanner scanner);
}