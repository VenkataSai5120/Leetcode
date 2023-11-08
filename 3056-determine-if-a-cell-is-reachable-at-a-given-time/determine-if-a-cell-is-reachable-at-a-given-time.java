class Solution {
    public boolean isReachableAtTime(int startX, int startY, int targetX, int targetY, int timeLimit) {
        if (startX == targetX && startY == targetY && timeLimit == 1) return false;
        
        int yDiff = Math.abs(targetY - startY);
        int xDiff = Math.abs(targetX - startX);
        int minDiff = Math.min(yDiff, xDiff);
        
        yDiff -= minDiff;
        xDiff -= minDiff;
        
        int totalDistance = minDiff + yDiff + xDiff;
        
        if (totalDistance <= timeLimit) {
            return true;
        }
        
        return false;
    }
}