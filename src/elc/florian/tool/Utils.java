package elc.florian.tool;

public class Utils {
    public static Boolean sorted(double[] l) {
        double a = l[0];
        for (double b : l) {
            if (!(a <= b+0.0000001)) {
                return false;
            }
            a = b;
        }

        return true;
    }
}
