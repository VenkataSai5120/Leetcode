class SeatManager {
    int marker;
    PriorityQueue<Integer> manager;
    public SeatManager(int n) {
        marker = 1;
        manager = new PriorityQueue<>();
    }

    public int reserve() {
        if (!manager.isEmpty()) {
            return manager.poll();
        }

        return marker++;
    }

    public void unreserve(int seatNumber) {
        manager.offer(seatNumber);
    }
}
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */