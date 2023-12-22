package elc.florian.screen;

import elc.florian.Main;
import elc.florian.cube.Cube;
import elc.florian.tool.Vector;

import java.awt.*;

public class Refresh {
    static Cube cube1 = new Cube(new Vector(0, 0, 0), 1);
    static Cube cube2 = new Cube(new Vector(0, 3, 0), 2);
    static Cube cube3 = new Cube(new Vector(3, 3, 0), 2);
    static Cube cube4 = new Cube(new Vector(3, 0, 3), 2);

    public static void Screen(Graphics g) {
        g.setColor(Main.bgColor);
        g.fillRect(0,0, Main.canvaSize, Main.canvaSize);

        MyGraphics3D.drawCube(g, cube1, Main.camera);


        g.dispose();
        Main.view.repaint();
        Main.refresh = Main.refresh + 1;
    }
}
