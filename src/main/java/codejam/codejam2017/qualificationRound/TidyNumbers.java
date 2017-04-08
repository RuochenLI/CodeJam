package codejam.codejam2017.qualificationRound;

import codejam.common.GoogleJamTemplate;

import java.util.Scanner;

/**
 * Created by Ruochen on 08/04/2017.
 */
public class TidyNumbers implements GoogleJamTemplate {

    @Override
    public String resolve(Scanner scanner) {
        return findTinyNumber(scanner.nextLine());
    }

    public String findTinyNumber(String numStr) {
        int valueIndex = findFirstDownValueIndex(numStr);
        if (valueIndex == -1) return numStr;

        StringBuilder sb = new StringBuilder();
        valueIndex = findFirstNotEquals(numStr, valueIndex);

        sb.append(numStr.substring(0, valueIndex));
        char downValue = getDownValue(numStr.charAt(valueIndex));
        if (sb.length() != 0 || downValue != '0') {
            sb.append(downValue);
        }

        sb.append(fillWithNine(numStr.length() - 1 - valueIndex));
        return sb.toString();
    }

    private char getDownValue(char c) {
        return (char) (c - 1);
    }

    private String fillWithNine(int num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            sb.append("9");
        }
        return sb.toString();
    }

    private int findFirstNotEquals(String number, int valueIndex) {
        int pointer = valueIndex;
        while (pointer > 0 && number.charAt(pointer) == number.charAt(pointer - 1)) pointer--;
        return pointer;
    }

    private int findFirstDownValueIndex(String numStr) {
        int pointer = 0;
        while (pointer < numStr.length() - 1 && (int) numStr.charAt(pointer) <= (int) numStr.charAt(pointer + 1)) {
            pointer++;
        }
        if (pointer >= numStr.length() - 1) {
            return -1;
        }

        return (int) numStr.charAt(pointer) >= (int) numStr.charAt(pointer + 1) ? pointer : -1;
    }
}
