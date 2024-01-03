package elc.florian.tool;

import elc.florian.cube.Cube;

public class Utils {
    public static Boolean sorted(double[] l) {
        double a = l[0];
        for (double b : l) {
            if (!(a <= b+0.0000001)) {
                return false;
            }
            a = b;
        }

        return true;
    }

    public static double[][] sort(double[][] tLists) {
        int a = 0;
        int b = 1;

        double tmp;
        for (int i = 0; i<tLists.length; i++) {
            if (!sorted(new double[]{tLists[0][0], tLists[1][0]})) {
                tmp = tLists[a][0];
                tLists[a][0] = tLists[b][0];
                tLists[b][0] = tmp;
            }
        }
        return tLists;
    }

    public static Cube[] tri_fusion(Cube[] cubes) {
        int milieu;
        if (cubes.length > 1){
            milieu = cubes.length/2;

            Cube[] gauche = new Cube[milieu];
            Cube[] droite = new Cube[cubes.length - milieu];
            System.arraycopy(cubes, 0, gauche, 0, milieu);
            System.arraycopy(cubes, milieu, droite, 0, cubes.length - milieu);

            gauche = tri_fusion(gauche);
            droite = tri_fusion(droite);

            cubes = fusion(cubes, gauche, droite);
        }
        return cubes;
    }


    static Cube[] fusion(Cube[] tableau, Cube[] gauche, Cube[] droite) {
        int i = 0, j = 0, k = 0;

        while (i < gauche.length && j < droite.length) {
            if (gauche[i].getTList()[0] < droite[j].getTList()[0]) {
                tableau[k] = gauche[i];
                i = i + 1;
            } else {
                tableau[k] = droite[j];
                j = j + 1;
            }
            k = k + 1;
        }

        // Ajouter les éléments restants à la fin du tableau
        while (i < gauche.length) {
            tableau[k] = gauche[i];
            i++;
            k++;
        }

        while (j < droite.length) {
            tableau[k] = droite[j];
            j++;
            k++;
        }
        return tableau;
    }
}
