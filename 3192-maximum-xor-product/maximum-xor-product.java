// class Solution {
//     public int maximumXorProduct(long a, long b, int n) {
//         long max = (long)Math.pow(2, n) - 1;
//         return find(max, 0, 0, a, b);
//     }
    
//     private int find(long max, int index, long res, long a, long b) {
//         if (max <= 0) {
//             System.out.println(res);
//             return (int)(((a ^ res) * (b ^ res)) % 1_000_000_007);
//         }
//         long val1 = a & (1 << index);
//         long val2 = b & (1 << index);
        
//         if (val1 == 0 && val2 == 0) {
//             return find(max >> 1, index + 1, res + (1 << index), a, b);
//         }
//         return Math.max(find(max >> 1, index + 1, 
//         res + (1 << index), a, b), find(max >> 1, index + 1, res, a, b));
//     }
// }

import java.math.BigInteger;
class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        BigInteger cand = BigInteger.ZERO;
        BigInteger A = BigInteger.valueOf(a);
        BigInteger B = BigInteger.valueOf(b);
        BigInteger ans = A.multiply(B);
        for(int i=n-1; i>=0; i--) {
            BigInteger temp = cand.setBit(i);
            BigInteger tempAns = A.xor(temp).multiply(B.xor(temp));
            if(tempAns.compareTo(ans) > 0) {
                ans = tempAns;
                cand = temp;
            }
        }
        return Integer.parseInt(ans.mod(BigInteger.valueOf(1000000007)).toString());
    }
}