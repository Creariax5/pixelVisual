package elc.florian.screen;

import elc.florian.Main;
import elc.florian.camera.Camera;
import elc.florian.cube.Cube;
import elc.florian.tool.Utils;
import elc.florian.tool.Vector;

import java.awt.*;

public class MyGraphics3D {
    static double size = 1;
    static double pixSize = 0.25;

    public static void drawCubes(Graphics g, Cube[] cubes, Camera camera) {
        Graphics2D graphics2D = (Graphics2D) g;

        int midSize = (int) (Main.canvaSize*pixSize/2);

        for (int i = 0; i < Main.canvaSize*pixSize; i++) {
            for (int j = 0; j < Main.canvaSize*pixSize; j++) {
                double angleW = (double) (i - midSize) / 400;
                double angleH = (double) (j - midSize) / 400;

                // créer une caméra temporaire et changer sa hauteur de vue
                Camera newCam = new Camera(camera);
                newCam.setOrientationH(newCam.getOrientationH() + angleH);

                // puis sa W
                Vector axeDeRotation = new Vector(newCam.getVector());
                Vector.oriToVec(axeDeRotation, newCam.getOrientationH() - Math.PI / 2, newCam.getOrientationW());

                newCam.setVector(Vector.rotation(newCam.getVector(), axeDeRotation, angleW));


                //camVector est égal au vecteur récemment calculé
                Vector camVector = newCam.getVector();

                graphics2D.setColor(new Color(0, 0, 0));

                int color = 0;

                //tList est une liste de 6 facteurs qui représentent le nombre de fois qu'il faut multiplier celui-ci pour toucher chacune des 6 faces du cube
                getTLists(camera, cubes, camVector);

                //on vérifie si un face est touchée par le vecteur si oui laquelle
                color = isRayTouching2(camVector, camera.getCoo(), cubes, 0);


                //on définit la bonne couleur du pixel à la coordonnée i j
                setPix(color, i, j, graphics2D);
            }
        }
    }

    private static void setPix(int color, double i, double j, Graphics2D graphics2D) {
        switch(color){
            case 0:
                break;

            case 1:
                graphics2D.setColor(new Color(0, 0, 200));
                graphics2D.fillRect((int) (i/pixSize), (int) (j/pixSize), 2, 2);
                break;

            case 2:
                graphics2D.setColor(new Color(0, 200, 0));
                graphics2D.fillRect((int) (i/pixSize), (int) (j/pixSize), 2, 2);
                break;

            case 3:
                graphics2D.setColor(new Color(200, 0, 0));
                graphics2D.fillRect((int) (i/pixSize), (int) (j/pixSize), 2, 2);
                break;
        }
    }

    private static int isRayTouching(double[] tList, Vector camVector, Vector camCoo, Vector cubeCoo, int face) {
        if (face == 6) {
            return 0;
        }

        double t = Math.min(tList[face], tList[face+1]);

        if (t<0) {
                return isRayTouching(tList, camVector, camCoo, cubeCoo, face+2);
        }

        double touchY;
        double touchX;
        double touchZ;

        touchY = camVector.getY() * t + camCoo.getY();
        touchX = camVector.getX() * t + camCoo.getX();
        touchZ = camVector.getZ() * t + camCoo.getZ();

        if (touchSurface(touchY, touchX, touchZ, cubeCoo)) {
            return face/2 +1;
        } else {
            return isRayTouching(tList, camVector, camCoo, cubeCoo, face+2);
        }
    }

    private static int isRayTouching2(Vector camVector, Vector camCoo, Cube[] cubes, int face) {
        if (face == 6) {
            return 0;
        }
        
        int i = 0;
        while (i!=cubes.length) {
            double t = Math.min(cubes[i].getTList()[face], cubes[i].getTList()[face+1]);


            if (t<0) {
                return isRayTouching2(camVector, camCoo, cubes, face+2);
            }

            double touchY;
            double touchX;
            double touchZ;

            touchY = camVector.getY() * t + camCoo.getY();
            touchX = camVector.getX() * t + camCoo.getX();
            touchZ = camVector.getZ() * t + camCoo.getZ();

            if (touchSurface2(touchY, touchX, touchZ, cubes[i])) {
                return face/2 +1;
            }

            i++;
        }

        return isRayTouching2(camVector, camCoo, cubes, face+2);
    }

    private static double[] getTList(Camera camera, Vector cubeCoo, Vector camVector) {

        return new double[] {(cubeCoo.getY()- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getY()+size- camera.getCoo().getY())/ camVector.getY(),
                (cubeCoo.getX()- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getX()+size- camera.getCoo().getX())/ camVector.getX(),
                (cubeCoo.getZ()- camera.getCoo().getZ())/ camVector.getZ(),
                (cubeCoo.getZ()+size- camera.getCoo().getZ())/ camVector.getZ()};
    }

    private static void getTLists(Camera camera, Cube[] cubes, Vector camVector) {
        for (Cube cube : cubes) {
            Vector cubeCoo = cube.getVector();
            cube.setTList(
                    new double[] {
                            (cubeCoo.getY()- camera.getCoo().getY())/ camVector.getY(),
                            (cubeCoo.getY()+size- camera.getCoo().getY())/ camVector.getY(),
                            (cubeCoo.getX()- camera.getCoo().getX())/ camVector.getX(),
                            (cubeCoo.getX()+size- camera.getCoo().getX())/ camVector.getX(),
                            (cubeCoo.getZ()- camera.getCoo().getZ())/ camVector.getZ(),
                            (cubeCoo.getZ()+size- camera.getCoo().getZ())/ camVector.getZ()
                    }
            );
        }
        //Utils.tri_fusion(cubes);
    }

    private static Boolean touchSurface(double touchY, double touchX, double touchZ, Vector cubeCoo) {
        double[][] l = new double[3][3];
        l[0] = new double[] {cubeCoo.getX() * size, touchX, (cubeCoo.getX() + 1) * size};
        l[1] = new double[] {cubeCoo.getY() * size, touchY, (cubeCoo.getY() + 1) * size};
        l[2] = new double[] {cubeCoo.getZ() * size, touchZ, (cubeCoo.getZ() + 1) * size};

        for (double[] item : l) {
            if (!Utils.sorted(item)) {
                return false;
            }
        }
        return true;
    }

    private static Boolean touchSurface2(double touchY, double touchX, double touchZ, Cube cube) {
        Vector cubeCoo = cube.getVector();

        double[][] l = new double[3][3];
        l[0] = new double[] {cubeCoo.getX() * size, touchX, (cubeCoo.getX() + 1) * size};
        l[1] = new double[] {cubeCoo.getY() * size, touchY, (cubeCoo.getY() + 1) * size};
        l[2] = new double[] {cubeCoo.getZ() * size, touchZ, (cubeCoo.getZ() + 1) * size};

        for (double[] item : l) {
            if (!Utils.sorted(item)) {
                return false;
            }
        }
        return true;
    }
}