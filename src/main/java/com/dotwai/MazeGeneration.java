package com.dotwai;

import com.dotwai.entity.MazeCell;
import com.dotwai.entity.Point;

import java.util.Random;
import java.util.Stack;

public class MazeGeneration {
    private static Random random = new Random();

    private static MazeCell[][] maze;

    private static final int VISITED = 1;

    public static int[][] mazeGenerate(int n) {
        maze = new MazeCell[n][n];
        init(maze, n);
        return new int[1][1];
    }

    private static void init(MazeCell[][] maze, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = new MazeCell(new int[]{0, 0, 0, 0}, 0);
            }
        }
    }

    private static void generate(MazeCell[][] maze, int n){
        Stack<Point> stack = new Stack<>();
        Point startPoint = randomPoint(n);
        int direction = randomDirection();
    }

    private static Point randomPoint(int n){
        return new Point(random.nextInt(n), random.nextInt(n));
    }

    private static int randomDirection(){
        return random.nextInt(4);
    }

    private static void markVisted(Point point){
        maze[point.getX()][point.getY()].setMark(VISITED);
    }

    private static Point nextPoint(Point point, int direction){
        return null;
    }
}
