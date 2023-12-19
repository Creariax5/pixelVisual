/*

package elc.florian.screen;

import elc.florian.Main;
import elc.florian.camera.Camera;
import elc.florian.cube.Cube;
import elc.florian.tool.Utils;
import elc.florian.tool.Vector;

import java.awt.*;

public class MyGraphics3D {
    static int size = 1;
    public static void drawCube(Graphics g, Cube cube, Camera camera) {
        Graphics2D graphics2D = (Graphics2D) g;

        int midSize = Main.canvaSize/2;

        int[] voxCoo = new int[] {0, 0, 0};

        int[][] points = getVoxelPoint(voxCoo);

        for (int[] point : points) {
            Vector a = new Vector(point[0], point[1], point[2]);
        }


        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 800; j++) {
                float angleW = (float) (i - midSize) /1000;
                float angleH = (float) (j - midSize) /1000;




                Camera newCam = new Camera(camera);

                newCam.setOrientationW(newCam.getOrientationW() + angleW);
                newCam.setOrientationH(newCam.getOrientationH() + angleH);


                int color = 0;



                switch(color){

                    case 0:
                        graphics2D.setColor(new Color(0, 0, 0));
                        break;

                    case 1:
                        graphics2D.setColor(new Color(0, 0, 200));
                        break;

                    case 2:
                        graphics2D.setColor(new Color(0, 200, 0));
                        break;

                    case 3:
                        graphics2D.setColor(new Color(200, 0, 0));
                        break;
                    default:
                        System.out.println("Choix incorrect");
                        break;
                }

                graphics2D.fillRect(i, j, 1, 1);
            }
        }
    }

    private static int[][] getVoxelPoint(int[] voxCoo) {
        int[][] points = new int[6][3];


        String s = "000";

        for (int i = 0; i<6; i++) {
            points[i][0] = voxCoo[0] + s.charAt(0);
            points[i][1] = voxCoo[1] + s.charAt(1);
            points[i][2] = voxCoo[2] + s.charAt(2);

            s = Integer.toBinaryString(i);
        }


        return points;
    }

    public static void shaderTest(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;


        long end_time = System.currentTimeMillis();
        float ms = end_time - Main.start_time;

        int b = (int) Math.abs(Math.cos(ms/3000)*255);


        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 800; j++) {
                graphics2D.setColor(new Color(i/4, j/4, b));
                graphics2D.fillRect(i, j, 1, 1);
            }
        }
    }
}

*/