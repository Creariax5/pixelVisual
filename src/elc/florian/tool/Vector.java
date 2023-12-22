package elc.florian.tool;

public class Vector {
    float x;
    float y;
    float z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();
    }

    public static Vector add(Vector a, Vector b) {
        return new Vector(a.getX() + b.getX(), a.getY() + b.getY(), a.getZ() + b.getZ());
    }

    public static float Pscalaire(Vector a, Vector b) {
        return a.x*b.x + a.y*b.y +a.z*b.z;
    }

    public static Vector Pvectoriel(Vector a, Vector b) {
        return new Vector(
                a.y*b.z - b.y*a.z,
                -(a.x*b.z - b.x*a.z),
                a.x*b.y - b.x*a.y
        );
    }

    public static Vector Psimple(Vector a, float b) {
        return new Vector(
                a.x*b,
                a.y*b,
                a.z*b
        );
    }

    public static Vector rotation(Vector V1, Vector V2, float O) {
        return Vector.add(
                Vector.add(
                        Vector.Psimple(
                                V1, (float) Math.cos(O)
                        ),
                        Vector.Psimple(
                                Vector.Pvectoriel(
                                        V2,
                                        V1
                                ), (float) Math.sin(O)
                        )
                ),
                Vector.Psimple(
                        Vector.Psimple(
                                V2,
                                Vector.Pscalaire(V2, V1)
                        ),
                        (float) (1-Math.cos(O))
                )
        );
    }

    /*public void vecToOri() {
        this.orientationW = (float) Math.atan(vector.getX()/vector.getZ());
        this.orientationH = (float) Math.acos(vector.getY());
    }*/

    public static Vector oriToVec(Vector vector, float orientationH, float orientationW) {
        vector.setX((float) (Math.sin(orientationH) * Math.sin(orientationW)));
        vector.setZ((float) (Math.sin(orientationH) * Math.cos(orientationW)));
        vector.setY((float) Math.cos(orientationH));
        return vector;
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
}
