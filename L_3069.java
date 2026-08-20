// class Solution {
//     public int[] resultArray(int[] nums) {
//         int n = nums.length;
//         int[] arr1 = new int[n];
//         int[] arr2 = new int[n];
        
//         int idx1 = 0, idx2 = 0;
        
//         // Step 1: Initialize arr1 and arr2 with the first two elements
//         arr1[idx1++] = nums[0];
//         arr2[idx2++] = nums[1];
        
//         // Step 2: Distribute remaining elements based on last appended values
//         for (int i = 2; i < n; i++) {
//             if (arr1[idx1 - 1] > arr2[idx2 - 1]) {
//                 arr1[idx1++] = nums[i];
//             } else {
//                 arr2[idx2++] = nums[i];
//             }
//         }
        
//         // Step 3: Concatenate arr1 and arr2 into the result array
//         int[] result = new int[n];
//         System.arraycopy(arr1, 0, result, 0, idx1);
//         System.arraycopy(arr2, 0, result, idx1, idx2);
        
//         return result;
//     }
// }



public class L_3069 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        int idx1 = 0, idx2 = 0;
        
        // Step 1: Place first two elements into arr1 and arr2
        arr1[idx1++] = nums[0];
        arr2[idx2++] = nums[1];
        
        // Step 2: Distribute remaining elements based on the last elements of arr1 and arr2
        for (int i = 2; i < n; i++) {
            if (arr1[idx1 - 1] > arr2[idx2 - 1]) {
                arr1[idx1++] = nums[i];
            } else {
                arr2[idx2++] = nums[i];
            }
        }
        
        // Step 3: Concatenate arr1 followed by arr2
        int[] result = new int[n];
        System.arraycopy(arr1, 0, result, 0, idx1);
        System.arraycopy(arr2, 0, result, idx1, idx2);
        
        return result;
    }

    // Main method to run directly in VS Code
    public static void main(String[] args) {
        L_3069 sol = new L_3069();

        // Example 1: nums = [5, 4, 3, 8]
        int[] nums1 = {5, 4, 3, 8};
        int[] result1 = sol.resultArray(nums1);
        System.out.print("Output 1: ");
        printArray(result1); // Expected: [5, 3, 4, 8]

        // Example 2: nums = [2, 1, 3]
        int[] nums2 = {2, 1, 3};
        int[] result2 = sol.resultArray(nums2);
        System.out.print("Output 2: ");
        printArray(result2); // Expected: [2, 3, 1]
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}