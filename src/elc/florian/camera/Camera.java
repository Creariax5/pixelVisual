package elc.florian.camera;

import elc.florian.tool.Vector;

public class Camera {
    Vector vector;
    Vector coo;
    double orientationW;
    double orientationH;
    int id;

    public Camera(Vector coo, int id) {
        this.vector = new Vector(0, 0, 0);
        this.coo = coo;
        this.id = id;
        this.orientationW = 0;
        this.orientationH = Math.acos(vector.getY());
    }

    public Camera(Camera camera) {
        this.vector = camera.getVector();
        this.coo = camera.getCoo();
        this.id = -1;
        this.orientationW = camera.getOrientationW();
        this.orientationH = camera.getOrientationH();
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public Vector getCoo() {
        return coo;
    }

    public void setCoo(Vector coo) {
        this.coo = coo;
    }

    public double getOrientationW() {
        return orientationW;
    }

    public void setOrientationW(double orientationW) {
        this.orientationW = orientationW;
        Vector.oriToVec(vector, orientationH, orientationW);
    }

    public double getOrientationH() {
        return orientationH;
    }

    public void setOrientationH(double orientationH) {
        this.orientationH = orientationH;
        Vector.oriToVec(vector, orientationH, orientationW);
    }

    public void setOrientationHW(double orientationH, double orientationW) {
        this.orientationH = orientationH;
        this.orientationW = orientationW;
        Vector.oriToVec(vector, orientationH, orientationW);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
