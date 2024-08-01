class Solution {
    public int nonSpecialCount(int l, int r) {
        int maxPrime = (int) Math.sqrt(r) + 1;
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[maxPrime + 1];
        for (int i = 2; i <= maxPrime; i++) isPrime[i] = true;

        for (int i = 2; i * i <= maxPrime; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxPrime; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= maxPrime; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int specialCount = 0;
        for (int prime : primes) {
            long specialNumber = (long) prime * prime;
            if (specialNumber >= l && specialNumber <= r) {
                specialCount++;
            }
        }

        int totalNumbers = r - l + 1;
        return totalNumbers - specialCount;
    }
}
