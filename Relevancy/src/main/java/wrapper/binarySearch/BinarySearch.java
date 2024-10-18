package wrapper.binarySearch;

import java.util.*;

public class BinarySearch {

    public static List<String> findEliminationOrder(String[][] laps) {
        int numDrivers = laps[0].length;
        List<String> eliminatedDrivers = new ArrayList<>();
        Set<String> remainingDrivers = new HashSet<>();


        for (int i = 0; i < numDrivers; i++) {
            remainingDrivers.add(laps[0][i].split(" ")[0]);
        }


        for (int lap = 0; lap < laps.length; lap++) {
            if (remainingDrivers.isEmpty()) {
                break;
            }

            List<String> driversToEliminate = new ArrayList<>();
            int slowestTime = Integer.MIN_VALUE;

            for (int i = 0; i < numDrivers; i++) {
                String[] driverData = laps[lap][i].split(" ");
                String driverName = driverData[0];
                int lapTime = Integer.parseInt(driverData[1]);

                if (remainingDrivers.contains(driverName)) {
                    if (lapTime > slowestTime) {
                        slowestTime = lapTime;
                        driversToEliminate.clear();
                        driversToEliminate.add(driverName);
                    } else if (lapTime == slowestTime) {
                        driversToEliminate.add(driverName);
                    }
                }
            }

            Collections.sort(driversToEliminate);
            eliminatedDrivers.addAll(driversToEliminate);

            for (String driver : driversToEliminate) {
                remainingDrivers.remove(driver);
            }

            if (remainingDrivers.isEmpty()) {
                break;
            }
        }

        return eliminatedDrivers;
    }

    public static void main(String[] args) {
        String[][] laps = {
                {"Gina 155", "Eddie 160", "Joy 161", "Harold 163"},
                {"Harold 151", "Gina 153", "Joy 160", "Eddie 160"},
                {"Harold 149", "Joy 150", "Gina 152", "Eddie 154"},
                {"Harold 148", "Gina 150", "Eddie 151", "Joy 155"}
        };

        List<String> eliminationOrder = findEliminationOrder(laps);
        System.out.println("Elimination order: " + eliminationOrder);
    }

}
