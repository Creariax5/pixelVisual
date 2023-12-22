package elc.florian.tool;

public class Vector {
    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
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

    public static double Pscalaire(Vector a, Vector b) {
        return a.x*b.x + a.y*b.y +a.z*b.z;
    }

    public static Vector Pvectoriel(Vector a, Vector b) {
        return new Vector(
                a.y*b.z - b.y*a.z,
                -(a.x*b.z - b.x*a.z),
                a.x*b.y - b.x*a.y
        );
    }

    public static Vector Psimple(Vector a, double b) {
        return new Vector(
                a.x*b,
                a.y*b,
                a.z*b
        );
    }

    public static Vector rotation(Vector V1, Vector V2, double O) {
        return Vector.add(
                Vector.add(
                        Vector.Psimple(
                                V1, Math.cos(O)
                        ),
                        Vector.Psimple(
                                Vector.Pvectoriel(
                                        V2,
                                        V1
                                ), Math.sin(O)
                        )
                ),
                Vector.Psimple(
                        Vector.Psimple(
                                V2,
                                Vector.Pscalaire(V2, V1)
                        ),
                        1-Math.cos(O)
                )
        );
    }

    public static Vector oriToVec(Vector vector, double orientationH, double orientationW) {
        vector.setX(Math.sin(orientationH) * Math.sin(orientationW));
        vector.setZ(Math.sin(orientationH) * Math.cos(orientationW));
        vector.setY(Math.cos(orientationH));
        return vector;
    }


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
}
