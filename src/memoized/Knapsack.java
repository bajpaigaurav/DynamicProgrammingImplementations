package memoized;

public class Knapsack {
    public static int solveKnapsack(int[] articleWeights, int[] articleProfits, int sackCapacity) {
        int[][] memo = new int[articleProfits.length][sackCapacity+1];
        return bruteKnapsack(memo,articleWeights,articleProfits,sackCapacity,0);
    }

    private static int bruteKnapsack(int[][] memo, int[] articleWeights, int[] articleProfits, int sackCapacity, int currentIndex) {

        // base case for stopping recursion
        if( sackCapacity <= 0 || currentIndex >= articleProfits.length) {
            return 0;
        }

        if(memo[currentIndex][sackCapacity] != 0) {
            return memo[currentIndex][sackCapacity];
        }

        // now make two recursive calls - first by adding an element and second by not adding it
        // then compare the profits and return the max from both the cases

        int profitByKeeping = 0;
        // Pre-check if we are keeping the article that its smaller then the current capacity
        if(articleWeights[currentIndex] <= sackCapacity) {
            profitByKeeping = articleProfits[currentIndex]
                    + bruteKnapsack(memo,articleWeights,articleProfits,
                    sackCapacity - articleWeights[currentIndex], currentIndex+1);
        }

        int profitByDiscarding = bruteKnapsack(memo,articleWeights,articleProfits,sackCapacity,currentIndex+1);
        memo[currentIndex][sackCapacity] = Math.max(profitByDiscarding,profitByKeeping);
        return memo[currentIndex][sackCapacity];
    }


    public static void main(String[] args) {

        int[] articleProfits = {1,2,3,4,5};
        int[] articleWeights = {1,2,2,1,2};
        int capacity = 5; //sacksize
        System.out.println("Optimized with memo-:"+solveKnapsack(articleWeights,articleProfits,capacity));
    }
}
