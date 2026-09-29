class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length is m + n - 1. Must be even to be valid.
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        // Maximum open brackets possible is (m + n) / 2
        int maxOpen = (m + n) / 2;
        memo = new Boolean[m][n][maxOpen + 1];

        return dfs(grid, 0, 0, 0, m, n, maxOpen);
    }

    private boolean dfs(char[][] grid, int r, int c, int open, int m, int n, int maxOpen) {
        // Adjust balance based on the current character
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }

        // Invalid prefix balance
        if (open < 0 || open > maxOpen) {
            return false;
        }

        // Reached the destination
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean found = false;

        // Move Down
        if (r + 1 < m) {
            found = dfs(grid, r + 1, c, open, m, n, maxOpen);
        }

        // Move Right
        if (!found && c + 1 < n) {
            found = dfs(grid, r, c + 1, open, m, n, maxOpen);
        }

        return memo[r][c][open] = found;
    }
}