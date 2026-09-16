class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int totalN = n + k - 1;
        int totalK = 2 * k;

        if (totalK > totalN) return 0;

        return (int) combinations(totalN, totalK, MOD);
    }

    private long combinations(int n, int r, long mod) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;

        if (r > n - r) {
            r = n - r; 
        }

        long num = 1;
        long den = 1;

        for (int i = 0; i < r; i++) {
            num = (num * (n - i)) % mod;
            den = (den * (i + 1)) % mod;
        }

        
        return (num * modInverse(den, mod)) % mod;
    }

    private long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}