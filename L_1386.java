// Leetcode -1386


// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         Map<Integer, Set<Integer>> mp = new HashMap<>(); //row -> seats booked in each row

//         for(int[] reservedSeat : reservedSeats) {
//             int row  = reservedSeat[0];
//             int seat = reservedSeat[1];
//             mp.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
//         }

//         int result = (n - mp.size()) * 2;

//         for(Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
//             Set<Integer> bookedSeats = entry.getValue();

//             boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);
//             boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);
//             boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);

//             if(groupA && groupC)
//                 result += 2;
//             else if(groupA || groupB || groupC)
//                 result += 1;
//         }

//         return result;
//     }
// }

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L_1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> mp = new HashMap<>(); // row -> seats booked in each row

        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            mp.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        }

        int result = (n - mp.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> entry : mp.entrySet()) {
            Set<Integer> bookedSeats = entry.getValue();

            boolean groupA = !bookedSeats.contains(2) && !bookedSeats.contains(3) && !bookedSeats.contains(4) && !bookedSeats.contains(5);
            boolean groupB = !bookedSeats.contains(4) && !bookedSeats.contains(5) && !bookedSeats.contains(6) && !bookedSeats.contains(7);
            boolean groupC = !bookedSeats.contains(6) && !bookedSeats.contains(7) && !bookedSeats.contains(8) && !bookedSeats.contains(9);

            if (groupA && groupC) {
                result += 2;
            } else if (groupA || groupB || groupC) {
                result += 1;
            }
        }

        return result;
    }

    // Main method to execute and test the solution in VS Code
    public static void main(String[] args) {
        L_1386 solver = new L_1386();

        // Sample Test Case 1
        int n1 = 3;
        int[][] reservedSeats1 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println("Output 1: " + solver.maxNumberOfFamilies(n1, reservedSeats1)); // Expected: 4

        // Sample Test Case 2
        int n2 = 2;
        int[][] reservedSeats2 = {{2, 1}, {1, 8}, {2, 6}};
        System.out.println("Output 2: " + solver.maxNumberOfFamilies(n2, reservedSeats2)); // Expected: 2
    }
}