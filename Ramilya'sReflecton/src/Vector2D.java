
/**
 * @author Ramilia Nigmatullina
 * 11-402
 * Task25с
 */

public class Vector2D {
    private double x,y;

    public Vector2D() {
        this(0,0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Author(name = "Rinat")
    public double getX() {
        return x;
    }

    @Author(name = "Kate")
    public void setX(double x) {
        this.x = x;
    }

    @Author(name = "Ilya")
    public double getY() {
        return y;
    }

    @Author(name = "Ilya")
    public void setY(double y) {
        this.y = y;
    }

    @Author(name = "Kate")
    public Vector2D add (Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }

    @Author()
    public void add2 (Vector2D v) {
        x += v.x;
        y += v.y;
        this.toString();
    }

    @Author(name = "Rinat")
    public Vector2D sub (Vector2D v) {
        return new Vector2D(x - v.x, y - v.y);
    }

    @Author(name = "Rinat")
    public void sub2 (Vector2D v) {
        x -= v.x;
        y -= v.y;
        this.toString();
    }

    @Author(name = "Damir")
    public Vector2D mult (double a) {
        return new Vector2D(x * a, y * a);
    }

    @Author(name = "Rinat")
    public void mult2 (double a) {
        x = x * a;
        y = y * a;
        this.toString();
    }

    @Author(name = "Kate")
    public String toString () {
        return "<" + x + ", " + y + ">";
    }

    @Author(name = "Damir")
    public double length () {
        return Math.sqrt(x * x + y * y);
    }

    @Author(name = "Ilya")
    public double scalarProduct(Vector2D v) {
        return x * v.x + y * v.y;
    }

    @Author(name = "Ilya")
    public double cos(Vector2D v) {
        double a;
        a = this.scalarProduct(v);
        double length2 = this.length ();
        double length3 = v.length ();
        return a / (length2 * length3);
    }

    @Author(name = "Rinat")
    public boolean equals(Vector2D v) {
        if (x == v.x && y == v.y) {
            return true;
        }
        else    {
            return false;
        }
    }
}
