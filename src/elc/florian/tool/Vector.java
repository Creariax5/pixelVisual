package elc.florian.tool;

import elc.florian.camera.Camera;
import elc.florian.cube.Cube;

import java.awt.*;

public class Vector {
    float x;
    float y;
    float z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getId() {
        return z;
    }

    public void setId(float z) {
        this.z = z;
    }
}
