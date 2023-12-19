package elc.florian.tool;

import elc.florian.Main;
import elc.florian.tool.listener.MyKeyListener;
import elc.florian.tool.listener.MyMouseListener;
import elc.florian.tool.listener.MyMouseMotionListener;

import javax.swing.*;

public class Frame {
    public static JFrame create() {
        Main canvas = new Main();
        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas.view);
        frame.addMouseListener(new MyMouseListener());
        frame.addMouseMotionListener(new MyMouseMotionListener());
        frame.addKeyListener(new MyKeyListener());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        return frame;
    }
}
