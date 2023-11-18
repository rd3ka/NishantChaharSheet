import java.util.*;

class main {


    static boolean isSafe(int maze[][], boolean visit[][], int row, int col, int n) {
        return row >= 0 && col >= 0 && row < n && col < n && visit[row][col] == false && maze[row][col] == 1;
    }

    static void doRatMaze(int row, int col, List <String> directions, String direction, 
                            boolean visit[][], int maze[][], int n) {
        if (row == n - 1 && col == n - 1) {
            directions.add(direction);
            return;
        }

        if (isSafe(maze, visit, row, col, n)) {
            visit[row][col] = true;
            doRatMaze(row - 1, col, directions, direction + 'U', visit, maze, n); /* Up */
            doRatMaze(row + 1, col, directions, direction + 'D', visit, maze, n); /* Down */
            doRatMaze(row, col - 1, directions, direction + 'L', visit, maze, n); /* Left */
            doRatMaze(row, col + 1, directions, direction + 'R', visit, maze, n); /* Right */
            visit[row][col] = false;
        }
    }

    static List <String> ratMaze(int n, int [][]maze) {
        List <String> directions = new ArrayList <> ();
        boolean visit[][] = new boolean[n][n];
        if (maze[n - 1][n - 1] == 0)
            return directions;
        doRatMaze(0, 0, directions, "", visit, maze, n);        
        return directions;
    }

    public static void main(String []args) {
        int n = 4;
        int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        System.out.println(ratMaze(n, maze));
    }
}