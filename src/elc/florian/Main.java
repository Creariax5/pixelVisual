package elc.florian;

import elc.florian.camera.Camera;
import elc.florian.tool.Frame;
import elc.florian.screen.Refresh;
import elc.florian.tool.Vector;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class Main {
    public static JLabel view;
    BufferedImage surface;
    public static int canvaSize = 800;

    public static Color bgColor = Color.BLACK;
    public static int refresh = 0;
    public static long start_time = System.currentTimeMillis();
    public static Camera camera = new Camera(new Vector(10, 3, 0), 1);

    public static JFrame frame = Frame.create();
    public Main()
    {
        float ori = (float) (3*Math.PI/2);
        camera.setOrientationW(ori);

        ori = (float) (1.1*Math.PI/2);
        camera.setOrientationH(ori);

        surface = new BufferedImage(canvaSize,canvaSize,BufferedImage.TYPE_INT_RGB);
        view = new JLabel(new ImageIcon(surface));


        ActionListener listener = ae -> Refresh.Screen(surface.getGraphics());
        Timer timer = new Timer(0, listener);
        timer.start();
    }


    public static void main(String[] args)
    {

    }
}
