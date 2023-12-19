package elc.florian.camera;

import elc.florian.tool.Vector;

public class Camera {
    Vector vector;
    Vector coo;
    float orientationW;
    float orientationH;
    int id;

    public Camera(Vector coo, int id) {
        this.vector = new Vector(0, 0, 0);
        this.coo = coo;
        this.id = id;
        this.orientationW = 0;
        this.orientationH = (float) Math.acos(vector.getY());
    }

    public Camera(Camera camera) {
        this.vector = camera.getVector();
        this.coo = camera.getCoo();
        this.id = -1;
        this.orientationW = camera.getOrientationW();
        this.orientationH = camera.getOrientationH();
    }

    public void vecToOri() {
        this.orientationW = (float) Math.atan(vector.getX()/vector.getZ());
        this.orientationH = (float) Math.acos(vector.getY());
        System.out.println(orientationW);
    }

    public void oriToVec() {
        //System.out.println(orientationH);
        //System.out.println(orientationW);

        this.vector.setX((float) (Math.sin(orientationH) * Math.sin(orientationW)));
        this.vector.setZ((float) (Math.sin(orientationH) * Math.cos(orientationW)));
        this.vector.setY((float) Math.cos(orientationH));
        /*System.out.println(vector.getX());
        System.out.println(vector.getY());
        System.out.println(vector.getZ());
        System.out.println(Math.sqrt(Math.pow(vector.getX(), 2)+Math.pow(vector.getY(), 2)+Math.pow(vector.getZ(), 2)));*/
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

    public float getOrientationW() {
        return orientationW;
    }

    public void setOrientationW(float orientationW) {
        this.orientationW = orientationW;
        oriToVec();
    }

    public float getOrientationH() {
        return orientationH;
    }

    public void setOrientationH(float orientationH) {
        this.orientationH = orientationH;
        oriToVec();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}