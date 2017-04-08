package codejam.common;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by ruli on 4/8/2016.
 */
public class GoogleJamOutputGenerator {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String packagePath = "codejam.codejam2017.qualificationRound.";
        //Add class name to be execute
        String className = "TidyNumbers";
        //Add input file name
        String input = "B-large.in";

        Preconditions.checkArgument(!className.isEmpty(), "class name cannot be empty");
        Preconditions.checkArgument(!input.isEmpty(), "input file name cannot be empty");
        String output = input.replace("in", "out");
        GoogleJamTemplate exercise = Class.forName(packagePath + className).asSubclass(GoogleJamTemplate.class).newInstance();
        InputStream inputStream = exercise.getClass().getResourceAsStream(input);
        Preconditions.checkArgument(inputStream != null);
        try (
                Scanner scanner = new Scanner(inputStream);
                PrintWriter writer = new PrintWriter(output)
        ) {
            int cases = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < cases; i++) {
//                System.out.println("Case #" + (i + 1) + ": ");
                writer.println("Case #" + (i + 1) + ": " + exercise.resolve(scanner));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
