package enums;

public enum Direction {
    RIGHT(1,0),
    LEFT(-1,0),
    UP(0,-1),
    DOWN(0,1);

     public final int y;
     public final int x;


    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
