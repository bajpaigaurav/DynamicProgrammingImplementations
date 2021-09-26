package bruteForce;

import java.util.Arrays;

public class EqualSubsetSumPartition {

    public static boolean canPartition(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) {
            return false;
        } else {
            return letsPartition(arr, sum/2, 0);
        }
    }

    private static boolean letsPartition(int[] arr, int sum, int currentIndex) {
        if(sum == 0){
            return true;
        }
        if(arr.length == 0 || currentIndex >= arr.length) {
            return false;
        }
        // pre-check to see if currentblock back be processed
        // if yes then making recursive call by selecting the number from the array at current index
        if(arr[currentIndex] <= sum) {
            if(letsPartition(arr,sum-arr[currentIndex], currentIndex+1)) {
                return true;
            }
        }
        // recursive call without selecting the current index block of array
        return letsPartition(arr,sum,currentIndex+1);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1,2,3,4}));
    }
}
