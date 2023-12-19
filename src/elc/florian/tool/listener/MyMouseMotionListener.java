package elc.florian.tool.listener;

import elc.florian.Main;

import java.awt.*;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener{
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
        robot.mouseMove(Main.frame.getX() + 400, Main.frame.getY() + 400);


        Main.camera.setOrientationW((float) (Main.camera.getOrientationW() + (0.01*(x-400))));

        Main.camera.setOrientationH((float) (Main.camera.getOrientationH() + (0.01*(y-400))));
        if (Main.camera.getOrientationH()<0) {
            Main.camera.setOrientationH(0);
        }

        System.out.println(Main.camera.getOrientationH());
        System.out.println(Main.camera.getOrientationW());
    }
}
