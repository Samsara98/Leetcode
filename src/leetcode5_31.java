public class leetcode5_31 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    check(grid,x,y);
                    result++;
                }
            }
        }
        return result;
    }

    public void check(char[][] grid, int x, int y) {
        if (y - 1 >= 0 && grid[y - 1][x] == '1') {
            grid[y - 1][x] = '2';
            check(grid, x, y - 1);
        }
        if (y + 1 < grid.length && grid[y + 1][x] == '1') {
            grid[y + 1][x] = '2';
            check(grid, x, y + 1);
        }
        if (x - 1 >= 0 && grid[y][x-1] == '1') {
            grid[x - 1][x] = '2';
            check(grid, x - 1, y);
        }
        if (x + 1 < grid[0].length && grid[y][x + 1] == '1') {
            grid[y][x + 1] = '2';
            check(grid, x + 1, y);
        }
    }
}
