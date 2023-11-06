class SeatManager {
    PriorityQueue<Integer> manager;
    public SeatManager(int n) {
        this.manager = new PriorityQueue<Integer>();
        for (int i = 1; i <= n; i++) this.manager.add(i);
    }
    
    public int reserve() {
        return this.manager.poll();
    }
    
    public void unreserve(int seatNumber) {
        this.manager.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */