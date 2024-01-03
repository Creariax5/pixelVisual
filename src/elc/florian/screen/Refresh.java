package elc.florian.screen;

import elc.florian.Main;
import elc.florian.cube.Cube;
import elc.florian.tool.Vector;

import java.awt.*;

public class Refresh {
    public static void Screen(Graphics g) {
        g.setColor(Main.bgColor);
        g.fillRect(0,0, Main.canvaSize, Main.canvaSize);

        MyGraphics3D.drawCubes(g, Main.cubes, Main.camera);


        g.dispose();
        Main.view.repaint();
        Main.refresh = Main.refresh + 1;
    }

    public static Cube[] createCubes() {
        int size = 1;

        Cube[] cubes = new Cube[size*size*size];

        int l = 0;

        for (int i = 0; i<size; i++) {
            for (int j = 0; j<size; j++) {
                for (int k = 0; k<size; k++) {
                    cubes[l] = new Cube(new Vector(i*2 , j*2, k*2));
                    l++;
                }
            }
        }
        return cubes;
    }
}
