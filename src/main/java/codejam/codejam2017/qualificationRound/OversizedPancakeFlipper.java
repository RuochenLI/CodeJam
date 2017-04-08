package codejam.codejam2017.qualificationRound;

import codejam.common.GoogleJamTemplate;

import java.util.Scanner;

/**
 * Created by Ruochen on 08/04/2017.
 */
public final class OversizedPancakeFlipper implements GoogleJamTemplate {

    public String findSolution(String cakeStr, int k) {
        int count = 0;
        String tmpCakeStr = cakeStr;
//        System.out.println("cakeStr = " + cakeStr);
//        System.out.println("k = " + k);
        while (!tmpCakeStr.isEmpty() && tmpCakeStr.length() >= k) {
            tmpCakeStr = removeFirstUpCakes(tmpCakeStr);
            if (tmpCakeStr.length() >= k) {
                count++;
                tmpCakeStr = flip(tmpCakeStr, k);
//                System.out.println("tmpCakeStr after flip = " + tmpCakeStr);
            }
        }

//        System.out.println(tmpCakeStr.isEmpty() ? String.valueOf(count) : "IMPOSSIBLE");
        return tmpCakeStr.isEmpty() ? String.valueOf(count) : "IMPOSSIBLE";
    }

    private String flip(String tmpCakeStr, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char c = tmpCakeStr.charAt(i) == '+' ? '-' : '+';
            sb.append(c);
        }
        sb.append(tmpCakeStr.substring(k));
        return sb.toString();
    }

    private String removeFirstUpCakes(String cakeStr) {
        int pointer = 0;
        while (pointer < cakeStr.length() && cakeStr.charAt(pointer) == '+') {
            pointer++;
        }
        return cakeStr.substring(pointer);
    }

    @Override
    public String resolve(Scanner scanner) {
        String cakeStr = scanner.next();
        int k = scanner.nextInt();
        return findSolution(cakeStr, k);
    }
}
