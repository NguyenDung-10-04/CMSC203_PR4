package org.example;

public class Plot {
    // Attributes:

    private int x; private int y; private int width; private int depth;

    public Plot() {
        this.depth = 1;
        this.width = 1;
    }

    public Plot(int depth, int width, int x, int y) {
        this.depth = depth;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Plot(Plot otherPlot){
        this.depth = otherPlot.depth;
        this.width = otherPlot.width;
        this.x = otherPlot.x;
        this.y = otherPlot.y;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return  x + ", " +  y + ", " + width + ", " + depth;
    }


    /*
   overlaps, encompasses

     */
}
