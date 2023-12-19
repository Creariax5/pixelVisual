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

        int midSize = 80/2;

        for (int i = 0; i < 800/10; i++) {
            for (int j = 0; j < 800/10; j++) {
                float angleW = (float) (i - midSize) /200;
                float angleH = (float) (j - midSize) /200;

                Camera newCam = new Camera(camera);

                newCam.setOrientationH(newCam.getOrientationH() + angleH);
                newCam.setOrientationW(newCam.getOrientationW() + angleW);

                Vector camVector = newCam.getVector();
                Vector cubeCoo = cube.getVector();

                graphics2D.setColor(new Color(0, 0, 0));

                float[] tList = gettList(camera, cubeCoo, camVector);

                float t = tList[0];

                int color = 0;


                float touchY;
                float touchX;
                float touchZ;

                if (tList[0]<tList[1]) {
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceY(touchY, touchX, touchZ, cubeCoo)) {
                            color = 1;
                        }
                    }
                } else {
                    t = tList[1];
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceY(touchY, touchX, touchZ, cubeCoo)) {
                            color = 1;
                        }
                    }
                }

                if (tList[2]<tList[3]) {
                    t = tList[2];
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceX(touchY, touchX, touchZ, cubeCoo)) {
                            if (color == 0) {
                                color = 2;
                            } else {

                            }
                        }
                    }
                } else {
                    t = tList[3];
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceX(touchY, touchX, touchZ, cubeCoo)) {
                            if (color == 0) {
                                color = 2;
                            } else {

                            }
                        }
                    }
                }
                if (tList[4]<tList[5]) {
                    t = tList[4];
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceZ(touchY, touchX, touchZ, cubeCoo)) {
                            if (color == 0) {
                                color = 3;
                            } else {

                            }
                        }
                    }
                } else {
                    t = tList[5];
                    touchY = (camVector.getY()) * t + camera.getCoo().getY();
                    touchX = (camVector.getX()) * t + camera.getCoo().getX();
                    touchZ = (camVector.getZ()) * t + camera.getCoo().getZ();

                    if (t>0) {
                        if (touchSurfaceZ(touchY, touchX, touchZ, cubeCoo)) {
                            if (color == 0) {
                                color = 3;
                            } else {

                            }
                        }
                    }
                }

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

                graphics2D.fillRect(i*10, j*10, 10, 10);

            }
        }
    }

    private static float[] gettList(Camera camera, Vector cubeCoo, Vector camVector) {
        float[] tList = new float[] {(cubeCoo.getY()- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getY()+size- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getX()- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getX()+size- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getZ()- camera.getCoo().getZ())/ camVector.getZ(),
                (cubeCoo.getZ()+size- camera.getCoo().getZ())/ camVector.getZ()};

        int k = Utils.min(tList);
        return tList;
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