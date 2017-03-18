package codejam.codejam2016.qualificationRound;import com.google.common.collect.Sets;
import org.junit.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.Set;

/**
 * Created by Ruochen on 09/04/2016.
 */
public class CoinJamTest {

    @Test
    public void testCoinJam() {
        System.out.println(CoinJam.coinJam(6, 30, "BasicPrimeSet.out"));
    }

    @Test
    public void testCoinJam1() {
        System.out.println(CoinJam.coinJam(6, 30, "test.in"));
    }


    @Test
    public void generatePrimeSet() {
        BigInteger two = new BigInteger("2");
        try (BufferedWriter out = new BufferedWriter(new FileWriter("primeBis.out"))) {
            out.write("2 ");
            for (long i = 3; i < 3333333333333334L; i++) {
                BigInteger pow = new BigInteger(String.valueOf(i - 1));
                BigInteger mod = new BigInteger(String.valueOf(i));
                if (two.modPow(pow, mod).compareTo(BigInteger.ONE) == 0) {
                    out.write(String.valueOf(i) + " ");
                    System.out.println(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test(){
        Set<Long> set = Sets.newHashSet();
        for (long i = 2; i < 3333333333333334L; i++) {
            set.add(i);
            System.out.println();
        }
        int i = 0;
    }


    @Test
    public void test2() {
        try (PrintWriter writer = new PrintWriter("primeBis.out")) {
            for (long i = 2; i < 3333333333333334L; i++) {
                long v = ((long) Math.pow((double) 2, (double) (i - 1))) % i;
                if (v == 1) {
                    writer.println(i);
                    System.out.println(i);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        generatePrime(3333333333333334L);
    }

    public static void generatePrime(long upper) {

        Set<Long> primeSet = Sets.newLinkedHashSet();
        for (long i = 2; i < upper; i++) {
            primeSet.add(i);
        }
        System.out.print("blb");
        for (long i = 2; i < upper; i++) {
            if (primeSet.contains(i)) {
                for (long j = 2; j < upper; j++) {
                    long candidate = i * j;
                    if (candidate < upper) {
                        primeSet.remove(candidate);
                    } else {
                        break;
                    }

                }
            }

        }
        System.out.print("blb");
        try (PrintWriter writer = new PrintWriter("prime2.out")) {
            primeSet.forEach(result -> writer.println(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
