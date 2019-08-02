package com.dotwai.entity;

public class MazeCell {
    private int[] walls;
    private int mark;

    public MazeCell(int[] walls, int mark) {
        this.walls = walls;
        this.mark = mark;
    }

    public void setWallValue(int index, int value){
        walls[index] = value;
    }

    public int getWallValue(int index){
        return walls[index];
    }

    public int[] getWalls() {
        return walls;
    }

    public void setWalls(int[] walls) {
        this.walls = walls;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
