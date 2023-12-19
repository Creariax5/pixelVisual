package elc.florian.screen;

import elc.florian.Main;
import elc.florian.cube.Cube;
import elc.florian.tool.Vector;

import java.awt.*;

public class Refresh {
    static Cube cube = new Cube(new Vector(0, 0, 0), 1);

    public static void Screen(Graphics g) {
        g.setColor(Main.bgColor);
        g.fillRect(0,0, Main.canvaSize, Main.canvaSize);

        MyGraphics3D.drawCube(g, cube, Main.camera);

        g.dispose();
        Main.view.repaint();
        Main.refresh = Main.refresh + 1;
    }
}
