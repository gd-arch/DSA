package PepCode.src.RecursionBackTracking;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();

            }
        }
        boolean visited[][] = new boolean[n][m];
        floodfill(arr, 0, 0, "", visited);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
        //corner cases
        if (row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            return;
        }
        //Destination reached
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);

            return;
        }
//        mark visited

        visited[row][col] = true;
        //TLDR pattern
        floodfill(maze, row - 1, col, psf + "t", visited);
        floodfill(maze, row, col - 1, psf + "l", visited);
        floodfill(maze, row + 1, col, psf + "d", visited);
        floodfill(maze, row, col + 1, psf + "r", visited);
        //mark visited unvisited
        visited[row][col] = false;
    }
}
