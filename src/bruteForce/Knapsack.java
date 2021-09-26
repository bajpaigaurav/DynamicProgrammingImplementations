package bruteForce;

public class Knapsack {


    public static int solveKnapsack(int[] articleWeights, int[] articleProfits, int sackCapacity) {
        return bruteKnapsack(articleWeights,articleProfits,sackCapacity,0);
    }

    private static int bruteKnapsack(int[] articleWeights, int[] articleProfits, int sackCapacity, int currentIndex) {

        // base case for stopping recursion
        if( sackCapacity <= 0 || currentIndex >= articleProfits.length) {
            return 0;
        }

        // now make two recursive calls - first by adding an element and second by not adding it
        // then compare the profits and return the max from both the cases

        int profitByKeeping = 0;
        // Pre-check if we are keeping the article that its smaller then the current capacity
        if(articleWeights[currentIndex] <= sackCapacity) {
            profitByKeeping = articleProfits[currentIndex]
                    + bruteKnapsack(articleWeights,articleProfits,
                    sackCapacity - articleWeights[currentIndex], currentIndex+1);
        }

        int profitByDiscarding = bruteKnapsack(articleWeights,articleProfits,sackCapacity,currentIndex+1);

        return Math.max(profitByDiscarding,profitByKeeping);
    }


    public static void main(String[] args) {

        int[] articleProfits = {1,2,3,4,5};
        int[] articleWeights = {1,2,2,1,2};
        int capacity = 5; //sacksize
        System.out.println(solveKnapsack(articleWeights,articleProfits,capacity));
    }
}
