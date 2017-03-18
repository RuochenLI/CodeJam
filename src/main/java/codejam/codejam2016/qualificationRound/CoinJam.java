package codejam.codejam2016.qualificationRound;

import codejam.common.GoogleJamTemplate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ruochen on 09/04/2016.
 */
public class CoinJam implements GoogleJamTemplate{
    static long lastPrimeInSet = 316826971L;

    public static Set<Long> generatePrimeSet(String inputFile) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            Set<Long> primeSet = Sets.newHashSet();
            while (scanner.hasNext()) {
                primeSet.add(scanner.nextLong());
            }
            return primeSet;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return Sets.newHashSet();
    }

    public static String coinJam(int longue, int expectResultNum, String basicPrimeSetFile) {
        Set<Long> basicPrimeSet = generatePrimeSet(basicPrimeSetFile);
        System.out.println("start");
        BigInteger two = new BigInteger("2");
        BigInteger low = two.pow(longue - 1).add(BigInteger.ONE);
        BigInteger up = two.pow(longue).subtract(BigInteger.ONE);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (low.compareTo(up) <= 0 && count < expectResultNum) {

            if (isPrime(two, low, basicPrimeSet) == -1) {
                List<String> results = verify(low, basicPrimeSet);
                if (results != null) {
                    count++;
                    results.forEach(result -> stringBuilder.append(result).append(" "));
                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
                    stringBuilder.append("\n");
                }
            }

            low = low.add(two);
        }

        return stringBuilder.toString();
    }

    private static List<String> verify(BigInteger low, Set<Long> basicPrimeSet) {
        List<String> result = Lists.newLinkedList();
        BigInteger two = new BigInteger("2");
        String valueBasedTwo = low.toString(2);
        result.add(valueBasedTwo);
        List<BigInteger> candidates = Lists.newArrayList();
        for (int i = 2; i <= 10; i++) {
            BigInteger valueInRadix = new BigInteger(valueBasedTwo, i);
            if (isPrime(two, valueInRadix, basicPrimeSet) != -1) {
                return null;
            } else {
                candidates.add(valueInRadix);
            }
        }
        System.out.println(valueBasedTwo);
        for (BigInteger candidate : candidates) {
            String divisor = findDivisor(candidate, basicPrimeSet);
            result.add(divisor);
        }


        return result;
    }

    private static String findDivisor(BigInteger valueInRadix, Set<Long> basicPrimeSet) {
        long floor = (long) Math.floor(Math.sqrt(valueInRadix.doubleValue()));
        BigInteger two = new BigInteger("2");
        for (long i = 2; i <= 316826971L; i++) {
            long prime = -1;
//            if (i > lastPrimeInSet) {
//                prime = isPrime(two, new BigInteger(String.valueOf(i)), basicPrimeSet);
//            }
            if ((basicPrimeSet.contains(i) || prime != -1)
                    && valueInRadix.mod(new BigInteger(String.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
                return String.valueOf(i);
            }
        }

        return null;
    }

    private static long isPrime(BigInteger two, BigInteger num, Set<Long> basicPrimeSet) {

        if (two.modPow(num.subtract(BigInteger.ONE), num).compareTo(BigInteger.ONE) == 0) {
            long numLong = num.longValue();
//            basicPrimeSet.add(numLong);
//            System.out.println(numLong);
            return numLong;
        }

        return -1;
    }

    @Override
    public String resolve(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        while (scanner.hasNext()) {
            result.append(coinJam(scanner.nextInt(), scanner.nextInt(), "Prime.out"));
        }
        return result.toString();
    }
}
