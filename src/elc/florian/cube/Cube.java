package elc.florian.cube;

import elc.florian.tool.Vector;

public class Cube {
    Vector vector;
    double[] TList = new double[6];

    public Cube(Vector vector) {
        this.vector = vector;
    }

    public double[] getTList() {
        return TList;
    }

    public void setTList(double[] TList) {
        this.TList = TList;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }
}
