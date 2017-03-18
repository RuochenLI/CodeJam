package codejam.codejam2016.qualificationRound;

import codejam.common.GoogleJamTemplate;
import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * Created by Ruochen on 09/04/2016.
 */
public class RevengePancake implements GoogleJamTemplate {


    public static int getMinTime(LinkedList<Character> pancakes, int count) {
        LinkedList<Character> newStack = Lists.newLinkedList();
        int lastIndexOf = pancakes.lastIndexOf('-');
        if (lastIndexOf == -1) {
            return count;
        }
        int indexOf = pancakes.indexOf('-');
        if (indexOf == 0) {
            stackOver(pancakes, newStack, 0, lastIndexOf);
        } else {
            copyStack(pancakes, newStack, indexOf, lastIndexOf);
            stackOver(pancakes, newStack, 0, indexOf - 1);

        }

        return getMinTime(newStack, ++count);
    }

    private static void copyStack(LinkedList<Character> pancakes, LinkedList<Character> newStack, int start, int end) {
        for (int i = end; i >= start; i--) {
            newStack.push(pancakes.get(i));
        }
    }

    private static void stackOver(LinkedList<Character> pancakes, LinkedList<Character> newStack, int start, int end) {
        for (int i = start; i <= end; i++) {
            Character pop = pancakes.pop();
            if (pop == '+') {
                newStack.push('-');
            } else {
                newStack.push('+');
            }
        }
    }

    @Override
    public String resolve(Scanner scanner) {
        char[] valueOf = String.valueOf(scanner.nextLine()).toCharArray();
        LinkedList<Character> characters = Lists.newLinkedList();
        for (int i = 0; i < valueOf.length; i++) {
            characters.add(valueOf[i]);
        }
        return String.valueOf(getMinTime(characters, 0));
    }
}
