package codejam.codejam2016.qualificationRound;

import codejam.common.GoogleJamTemplate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ruochen on 16/03/2017.
 */
public class CountingSheep implements GoogleJamTemplate {
    public static String count(long num) {
        if (num == 0) {
            return "INSOMNIA";
        } else {
            Set<Integer> numSet = new HashSet<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
            return String.valueOf(findFinal(num, numSet, 1, num));
        }
    }

    private static long findFinal(long num, Set<Integer> numSet, int i, long n) {
        removeDigital(num, numSet);
        if (numSet.isEmpty()) {
            return num;
        } else {
            return findFinal(n * (i +1), numSet, i + 1, n);
        }

    }

    private static void removeDigital(long num, Set<Integer> numSet) {
        String s = String.valueOf(num);
        for (char c : s.toCharArray()) {
            int digital = Character.getNumericValue(c);
            if (numSet.contains(digital)) {
                numSet.remove(digital);
            }
        }
    }

    @Override
    public String resolve(Scanner scanner) {
        int num = Integer.parseInt(scanner.nextLine());
        return count(num);
    }
}
