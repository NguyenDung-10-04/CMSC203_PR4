package org.example;

public class Plot {
    // Attributes:

    private int x; private int y; private int width; private int depth;

    public Plot() {
        this.depth = 1;
        this.width = 1;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;

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
        ✅ Ý tưởng:
        Hai Plot không giao nhau nếu một trong các điều kiện sau đúng:

        Một plot nằm hoàn toàn bên trái plot kia.

        Một plot nằm hoàn toàn bên phải plot kia.

        Một plot nằm hoàn toàn phía trên plot kia.

        Một plot nằm hoàn toàn phía dưới plot kia.

        Khi không rơi vào các trường hợp này, thì hai plot có giao nhau.

        2 hình: trùng nhau, giao nhau , nằm trong nhau, không giao nhau
        => this: green
        => plot: tím
    */

    public boolean overlaps(Plot plot){
        return this.x + this.width >= plot.x && this.y + this.depth >= plot.y && this.x + this.width <= plot.x && this.y + this.depth <= plot.y;

    }

    // plot => con
    // this => cha
    public boolean encompasses(Plot p) {
        return p.x >= this.x
                && p.y >= this.y
                && p.x + p.width  <= this.x + this.width
                && p.y + p.depth  <= this.y + this.depth;
    }
}
