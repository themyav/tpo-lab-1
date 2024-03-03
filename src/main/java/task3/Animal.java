package task3;

public abstract class Animal extends Entity{


    public double x;
    public double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double z;
    public final void move(double x, double y, double z){
        this.setX(x);
        this.setY(y);
        this.setX(z);
    }
}
