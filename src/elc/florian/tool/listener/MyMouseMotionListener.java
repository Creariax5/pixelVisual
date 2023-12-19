package elc.florian.tool.listener;

import elc.florian.Main;

import java.awt.event.KeyEvent;
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



        Main.camera.setOrientationW((float) (0.02*(x-400)));

        Main.camera.setOrientationH((float) (0.02*(y-400)));
        if (Main.camera.getOrientationH()<0) {
            Main.camera.setOrientationH(0);
        }

        System.out.println(0.02*(x-400));
        System.out.println(0.02*(y-400));
    }
}
