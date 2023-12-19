/*package elc.florian.screen;

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

        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 800; j++) {
                float angleW = (float) (i - midSize) /2000;
                float angleH = (float) (j - midSize) /2000;

                Camera newCam = new Camera(camera);

                newCam.setOrientationW(newCam.getOrientationW() + angleW);
                newCam.setOrientationH(newCam.getOrientationH() + angleH);
                Vector camVector = newCam.getVector();
                Vector cubeCoo = cube.getVector();

                int color = getTcolor(camera, cubeCoo, camVector);

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

    private static int getTcolor(Camera camera, Vector cubeCoo, Vector camVector) {
        float[] tList = new float[] {(cubeCoo.getY()- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getY()+size- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getX()- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getX()+size- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getZ()- camera.getCoo().getZ())/ camVector.getZ(),
                (cubeCoo.getZ()+size- camera.getCoo().getZ())/ camVector.getZ()};

        int i = Utils.min(tList);
        float t = tList[i];

        float touchY = (camVector.getY()) * t + camera.getCoo().getY();
        float touchX = (camVector.getX()) * t + camera.getCoo().getX();
        float touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

        if (t>0) {
            switch(i){

                case 0, 1:
                    if (touchSurfaceY(touchY, touchX, touchZ, cubeCoo)) {
                        return 1;
                    }
                    break;

                case 2, 3:
                    if (touchSurfaceX(touchY, touchX, touchZ, cubeCoo)) {
                        return 2;
                    }
                    break;

                case 4, 5:
                    if (touchSurfaceZ(touchY, touchX, touchZ, cubeCoo)) {
                        return 3;
                    }
                    break;
                default:
                    System.out.println("Choix incorrect");
                    break;
            }
        }
        return 0;
    }

    private static Boolean touchSurfaceY(float touchY, float touchX, float touchZ, Vector cubeCoo) {
        //System.out.println(cubeCoo.getY()*size + " " + " " + touchY);
        float[] lY = new float[] {cubeCoo.getY()*size ,touchY};
        if (!Utils.sorted(lY)) {
            return false;
        }
        float[] lX = new float[] {cubeCoo.getX()*size ,touchX,(cubeCoo.getX() + 1)*size};
        if (!Utils.sorted(lX)) {
            return false;
        }
        float[] lZ = new float[] {cubeCoo.getZ()*size ,touchZ,(cubeCoo.getZ() + 1)*size};
        if (!Utils.sorted(lZ)) {
            return false;
        }
        return true;
    }

    private static Boolean touchSurfaceX(float touchY, float touchX, float touchZ, Vector cubeCoo) {
        //System.out.println(cubeCoo.getY()*size + " " + " " + touchY);
        float[] lX = new float[] {cubeCoo.getX()*size ,touchX};
        if (!Utils.sorted(lX)) {
            return false;
        }
        float[] lY = new float[] {cubeCoo.getY()*size ,touchY,(cubeCoo.getY() + 1)*size};
        if (!Utils.sorted(lY)) {
            return false;
        }
        float[] lZ = new float[] {cubeCoo.getZ()*size ,touchZ,(cubeCoo.getZ() + 1)*size};
        if (!Utils.sorted(lZ)) {
            return false;
        }
        return true;
    }

    private static Boolean touchSurfaceZ(float touchY, float touchX, float touchZ, Vector cubeCoo) {
        //System.out.println(cubeCoo.getY()*size + " " + " " + touchY);
        float[] lZ = new float[] {cubeCoo.getZ()*size ,touchZ};
        if (!Utils.sorted(lZ)) {
            return false;
        }
        float[] lX = new float[] {cubeCoo.getX()*size ,touchX,(cubeCoo.getX() + 1)*size};
        if (!Utils.sorted(lX)) {
            return false;
        }
        float[] lY = new float[] {cubeCoo.getY()*size ,touchY,(cubeCoo.getY() + 1)*size};
        if (!Utils.sorted(lY)) {
            return false;
        }
        return true;
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