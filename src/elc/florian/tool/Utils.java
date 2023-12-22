package elc.florian.tool;

public class Utils {
    public static Boolean sorted(double[] l) {
        double a = l[0];
        for (double b : l) {
            if (!(a <= b)) {
                return false;
            }
            a = b;
        }

        return true;
    }
}
