package elc.florian.tool;

import java.lang.reflect.Array;
import java.util.List;

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

    public static int min(float[] l) {
        float a = l[0];
        int j = 0;
        for (int i = 0; i < l.length; i++) {
            if ((l[i] < a)) {
                a = l[i];
                j = i;
            }
            //System.out.println(l[i]);
        }
        //System.out.println("a: "+a);

        return j;
    }
}
