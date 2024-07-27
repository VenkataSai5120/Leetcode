class Solution {
    public String losingPlayer(int x, int y) {
        // Value of each type of coin
        int coinValue75 = 75;
        int coinValue10 = 10;
        // Total value needed in each turn
        int target = 115;

        // Turns taken by players (0, 1, 2, ...)
        int turns = 0;

        while (x > 0 || y > 0) {
            int needed75 = Math.min(x, target / coinValue75);
            int remaining = target - needed75 * coinValue75;
            int needed10 = Math.min(y, remaining / coinValue10);

            if (needed75 * coinValue75 + needed10 * coinValue10 != target) {
                break;
            }

            x -= needed75;
            y -= needed10;
            turns++;
        }

        // If turns are odd, Alice loses, otherwise Bob loses
        return turns % 2 == 0 ? "Bob" : "Alice";
    }
}
