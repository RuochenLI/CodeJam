package codejam.codejam2017.qualificationRound;

import codejam.common.GoogleJamTemplate;

import java.util.Scanner;

/**
 * Created by Ruochen on 08/04/2017.
 */
public class BathroomStalls implements GoogleJamTemplate {
    @Override
    public String resolve(Scanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        return findSolution(n, k);
    }

    public String findSolution(int n, int k) {
        if (n == k) {
            return "0 0";
        }

        Stall topLeft = new Stall(-1, -1, null, null);
        Stall topRight = new Stall(-1, -1, null, null);
        initStalls(n, topLeft, topRight);
        Stall bestPos;
//        printStatus(topLeft, topRight);
        for (int i = 0; i < k - 1; i++) {
            bestPos = findBestPosition(topLeft, topRight);
            updateList(topLeft, topRight, bestPos);
//            printStatus(topLeft, topRight);
        }

        bestPos = findBestPosition(topLeft, topRight);
        return Math.max(bestPos.right, bestPos.left) + " " + Math.min(bestPos.right, bestPos.left);
    }

    private void printStatus(Stall topLeft, Stall topRight) {
        Stall pointer = topLeft.rightStall;
        while (pointer != topRight) {
            if (pointer.left == -1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            pointer = pointer.rightStall;
        }
        System.out.println();
    }

    private void updateList(Stall topLeft, Stall topRight, Stall bestPos) {
        bestPos.left = -1;
        bestPos.right = -1;
        Stall pointer = bestPos.leftStall;
        int count = 0;
        while (pointer != topLeft) {
            pointer.right = count;
            count++;
            pointer = pointer.leftStall;
        }

        pointer = bestPos.rightStall;
        count = 0;
        while (pointer != topRight) {
            pointer.left = count;
            count++;
            pointer = pointer.rightStall;
        }
    }

    private Stall findBestPosition(Stall topLeft, Stall topRight) {
        Stall best = topLeft.rightStall;
        Stall pointer = topLeft.rightStall;
        long recordMin = 0;
        long recordMax = pointer.right;
        while (pointer != topRight) {
            if (pointer.left != -1 && pointer.right != -1) {
                long min = Math.min(pointer.left, pointer.right);
                long max = Math.max(pointer.left, pointer.right);
                if (recordMin < min || recordMin == min && recordMax < max) {
                    recordMin = min;
                    best = pointer;
                    recordMax = max;
                }
            }
            pointer = pointer.rightStall;
        }
        return best;
    }

    private void initStalls(int n, Stall topLeft, Stall topRight) {
        Stall pointer = topLeft;
        for (int i = 0; i < n; i++) {
            Stall tmp = new Stall(i, n - i - 1, pointer, null);
            pointer.rightStall = tmp;
            pointer = tmp;
        }
        pointer.rightStall = topRight;
        topRight.leftStall = pointer;
    }

    private static class Stall {
        long left;
        long right;
        Stall leftStall;
        Stall rightStall;

        Stall(int left, int right, Stall leftStall, Stall rightStall) {
            this.left = left;
            this.right = right;
            this.leftStall = leftStall;
            this.rightStall = rightStall;
        }
    }
}
