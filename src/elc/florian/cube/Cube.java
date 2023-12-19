package elc.florian.cube;

import elc.florian.tool.Vector;

public class Cube {
    Vector vector;
    int id;

    public Cube(Vector vector, int id) {
        this.vector = vector;
        this.id = id;
    }

    public Vector getVector() {
        return vector;
    }

    public void setY(Vector vector) {
        this.vector = vector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
