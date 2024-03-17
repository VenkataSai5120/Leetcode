class MinStack {
    List<Integer> storage;
    List<Integer> minTrack;

    public MinStack() {
        this.storage = new ArrayList<>();
        this.minTrack = new ArrayList<>();
    }
    
    public void push(int val) {
        if (storage.isEmpty()) {
            storage.add(val);
            minTrack.add(val);
        }
        else {
            storage.add(val);
            int minVal = Math.min(val, minTrack.get(minTrack.size() - 1));
            minTrack.add(minVal);
        }
    }
    
    public void pop() {
        int n = storage.size();
        storage.remove(n - 1);
        minTrack.remove(n - 1);
    }
    
    public int top() {
        return storage.get(storage.size() - 1);
    }
    
    public int getMin() {
        return minTrack.get(minTrack.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */