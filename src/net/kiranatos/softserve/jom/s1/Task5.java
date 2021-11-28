package net.kiranatos.softserve.jom.s1;

public class Task5 {}

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // return a 2-element int[] of {x,y}
    public int[] getXYPair(){
        return new int[]{x,y};
    }
    
    // return distance from this point to the given point at (x, y)
    public double distance(int x, int y){
        return distance(this.x, this.y, x, y);
    }
    
    // return distance from this point to the given instance of Point
    public double distance(Point point){
        return distance(this.x, this.y, point.x, point.y);
    }
    
    // return distance from this point to (0,0)
    public double distance(){
        return distance(this.x, this.y, 0, 0);
    }
    
    private double distance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}