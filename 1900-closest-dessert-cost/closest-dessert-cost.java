public class Solution {

    private int result;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        result = baseCosts[0];

        for (int base : baseCosts) {
            calculateClosestCost(base, toppingCosts, 0, target);
        }

        return result;
    }

    private void calculateClosestCost(int current, int[] toppingCosts, int index, int target) {
        if (isCloser(current, result, target)) {
            result = current;
        }

        if (index == toppingCosts.length || current >= target) {
            return;
        }

        calculateClosestCost(current, toppingCosts, index + 1, target);
        calculateClosestCost(current + toppingCosts[index], toppingCosts, index + 1, target);
        calculateClosestCost(current + toppingCosts[index] * 2, toppingCosts, index + 1, target);
    }

    private boolean isCloser(int current, int result, int target) {
        int currentDifference = Math.abs(target - current);
        int resultDifference = Math.abs(target - result);

        return currentDifference < resultDifference || 
        (currentDifference == resultDifference && current < result);
    }
}
