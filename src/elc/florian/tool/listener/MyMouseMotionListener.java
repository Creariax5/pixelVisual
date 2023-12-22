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

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            throw new RuntimeException(ex);
        }
        robot.mouseMove(Main.frame.getX() + Main.canvaSize/2, Main.frame.getY() + Main.canvaSize/2);

        Main.camera.setOrientationHW(Main.camera.getOrientationH() + (0.005*(y- (double) Main.canvaSize /2)), Main.camera.getOrientationW() + (0.005*(x- (double) Main.canvaSize /2)));
        if (Main.camera.getOrientationH()<0) {
            Main.camera.setOrientationH(0);
        }
        if (Main.camera.getOrientationH()>Math.PI) {
            Main.camera.setOrientationH(Math.PI);
        }
    }
}
