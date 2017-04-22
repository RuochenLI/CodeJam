package codejam.codejam2017.round1B;

import codejam.common.GoogleJamTemplate;
import com.google.common.collect.Lists;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ruochen on 22/04/2017.
 */
public class CruiseControl implements GoogleJamTemplate {

    private double maxTime = 0;

    @Override
    public String resolve(Scanner scanner) {

        long distance = scanner.nextLong();
        int n = scanner.nextInt();
        List<Long> distanceList = Lists.newArrayList();
        List<Integer> speedList = Lists.newArrayList();
        for (int i = 0; i < n; i++) {
            distanceList.add(scanner.nextLong());
            speedList.add(scanner.nextInt());
        }
        return calculateSpeed(distance, n, distanceList, speedList);
    }

    String calculateSpeed(long distance, int n, List<Long> distanceList, List<Integer> speedList) {
        for (int i = 0; i < n; i++) {
            long d = distance - distanceList.get(i);
            double time = d / speedList.get(i);
            maxTime = Math.max(maxTime, time);
        }

        DecimalFormat df = new DecimalFormat("#0.000000");
        return df.format(distance / maxTime);
    }
}
