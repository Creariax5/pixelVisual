package elc.florian.tool;

public class Utils {
    public static Boolean sorted(float[] l) {
        float a = l[0];
        for (float b : l) {
            if (!(a <= b)) {
                return false;
            }
            a = b;
        }

        return true;
    }
}
