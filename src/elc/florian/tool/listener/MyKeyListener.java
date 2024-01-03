package elc.florian.tool.listener;

import elc.florian.Main;
import elc.florian.camera.Camera;
import elc.florian.tool.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.getKeyText(e.getKeyCode()).equals("R")) {
            long end_time = System.currentTimeMillis();
            double s = (double) (end_time - Main.start_time) /1000;

            System.out.println(Main.refresh + " frames depuis " + s + " secondes");
            System.out.println(Main.refresh / s + " frames/s");
            System.out.println();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Space")) {
            Main.camera.getCoo().setY(Main.camera.getCoo().getY()+1);
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("E")) {
            Main.camera.getCoo().setY(Main.camera.getCoo().getY()-1);
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Q")) {
            Camera cam = new Camera(Main.camera);
            cam.setOrientationW(cam.getOrientationW()-Math.PI/2);
            Main.camera.setCoo(Vector.add(Main.camera.getCoo(), new Vector(Math.sin(cam.getOrientationW())/4, 0, Math.cos(cam.getOrientationW())/4)));
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {
            Camera cam = new Camera(Main.camera);
            cam.setOrientationW(cam.getOrientationW()+Math.PI/2);
            Main.camera.setCoo(Vector.add(Main.camera.getCoo(), new Vector(Math.sin(cam.getOrientationW())/4, 0, Math.cos(cam.getOrientationW())/4)));
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Z")) {
            Main.camera.setCoo(Vector.add(Main.camera.getCoo(), new Vector(Math.sin(Main.camera.getOrientationW())/4, 0, Math.cos(Main.camera.getOrientationW())/4)));
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {
            Main.camera.setCoo(Vector.add(Main.camera.getCoo(), new Vector(-Math.sin(Main.camera.getOrientationW())/4, 0, -Math.cos(Main.camera.getOrientationW())/4)));
        }


        else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Right")) {
            Main.camera.setOrientationW(Main.camera.getOrientationW()+0.1);
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Left")) {
            Main.camera.setOrientationW(Main.camera.getOrientationW()-0.1);
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Up")) {
            Main.camera.setOrientationH(Main.camera.getOrientationH()-0.1);
            System.out.println(Main.camera.getOrientationH());
            if (Main.camera.getOrientationH()<0) {
                Main.camera.setOrientationH(0);
            }
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("Down")) {
            Main.camera.setOrientationH(Main.camera.getOrientationH()+0.1);
            if (Main.camera.getOrientationH()>Math.PI) {
                Main.camera.setOrientationH(Math.PI);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
