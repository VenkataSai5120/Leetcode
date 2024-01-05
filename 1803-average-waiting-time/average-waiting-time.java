class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalTime = customers[0][1];
        int currTime = customers[0][0] + customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            if (customers[i][0] > currTime) {
                currTime = customers[i][0] + customers[i][1];
                totalTime += customers[i][1];
            }
            else {
                totalTime += currTime - customers[i][0] + customers[i][1];
                currTime += customers[i][1];
            }
        }   

        return totalTime / customers.length;
    }
}