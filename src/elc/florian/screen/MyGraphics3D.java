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

        int midSize = (int) (Main.canvaSize*0.2/2);

        for (int i = 0; i < Main.canvaSize*0.2; i++) {
            for (int j = 0; j < Main.canvaSize*0.2; j++) {
                float angleW = (float) (i - midSize) /400;
                float angleH = (float) (j - midSize) /400;

                // créer une caméra temporaire et changer sa hauteur de vue
                Camera newCam = new Camera(camera);
                newCam.setOrientationH(newCam.getOrientationH() + angleH);

                // puis sa W
                Vector axeDeRotation = new Vector(newCam.getVector());
                Vector.oriToVec(axeDeRotation, (float) (newCam.getOrientationH() - Math.PI / 2), newCam.getOrientationW());

                newCam.setVector(Vector.rotation(newCam.getVector(), axeDeRotation, angleW));


                //camVector est égal au vecteur récemment calculé
                Vector camVector = newCam.getVector();
                Vector cubeCoo = cube.getVector();

                graphics2D.setColor(new Color(0, 0, 0));

                //tList est une liste de 6 facteurs qui représentent le nombre de fois qu'il faut multiplier celui-ci pour toucher chacune des 6 faces du cube
                float[] tList = getTList(camera, cubeCoo, camVector);

                //on vérifie si un face est touchée par le vecteur si oui laquelle
                int color = isRayTouching(tList, camVector, camera.getCoo(), cubeCoo, 0);

                //on définit la bonne couleur du pixel à la coordonnée i j
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

                graphics2D.fillRect((int) (i/0.2), (int) (j/0.2), 3, 3);

            }
        }
    }

    private static int isRayTouching(float[] tList, Vector camVector, Vector camCoo, Vector cubeCoo, int face) {
        if (face == 6) {
            return 0;
        }

        float t = Math.min(tList[face], tList[face+1]);

        if (t<0) {
                return isRayTouching(tList, camVector, camCoo, cubeCoo, face+2);
        }

        float touchY;
        float touchX;
        float touchZ;

        touchY = (camVector.getY()) * t + camCoo.getY();
        touchX = (camVector.getX()) * t + camCoo.getX();
        touchZ = (camVector.getZ()) * t + camCoo.getZ();

        if (touchSurface(touchY, touchX, touchZ, cubeCoo)) {
            return face/2 +1;
        } else {
            return isRayTouching(tList, camVector, camCoo, cubeCoo, face+2);
        }
    }

    private static float[] getTList(Camera camera, Vector cubeCoo, Vector camVector) {

        return new float[] {(cubeCoo.getY()- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getY()+size- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getX()- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getX()+size- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getZ()- camera.getCoo().getZ())/ camVector.getZ(),
                (cubeCoo.getZ()+size- camera.getCoo().getZ())/ camVector.getZ()};
    }

    private static Boolean touchSurface(float touchY, float touchX, float touchZ, Vector cubeCoo) {
        float[][] l = new float[3][3];
        l[0] = new float[] {cubeCoo.getX() * size, touchX, (cubeCoo.getX() + 1) * size};
        l[1] = new float[] {cubeCoo.getY() * size, touchY, (cubeCoo.getY() + 1) * size};
        l[2] = new float[] {cubeCoo.getZ() * size, touchZ, (cubeCoo.getZ() + 1) * size};

        for (float[] item : l) {
            if (!Utils.sorted(item)) {
                return false;
            }
        }
        return true;
    }
}