import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lucas on 25/02/17.
 */
public class accenture {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Branches> ramas = new ArrayList<>();
    public static String[] ciudades = {"La Coruna", "Bilbao", "Barcelona", "Sevilla", "Valencia", "Madrid"};
    public static int[] coruna = {0, 544, 1088, 922, 948, 597};
    public static int[] bilbao = {544, 0, 609, 861, 611, 397};
    public static int[] bcn = {1088, 609, 0, 996, 351, 621};
    public static int[] sevilla = {922, 861, 996, 0, 654, 534};
    public static int[] valencia = {948, 611, 351, 654, 0, 355};
    public static int[] madrid = {597, 397, 621, 534, 355, 0};

    public static void main(String args[]) {
        String inicial = sc.nextLine();
        Branches w = new Branches(0);
        w.ar.add(inicial);
        ramas.add(w);

        build();

        int min = 99999;
        Branches sol = null;
        for (Branches z: ramas) {
            sol = (z.sum < min) ? z : sol;
            min = (z.sum < min) ? z.sum : min;
        }

        String solution = sol.ar.get(sol.ar.size()-1);
        for (int i = sol.ar.size()-2; i >= 0; i--) {
            solution += " -> " + sol.ar.get(i);
        }
        String xyz = String.valueOf(sol.sum);
        solution += " = " + xyz.charAt(0) + "." + xyz.substring(1,xyz.length()) + " km";

        System.out.println(solution);


    }

    public static void build() {
        int multiplicador = 5;
        while (ramas.get(0).ar.size() < 6) {
            ArrayList<Branches> temp = new ArrayList<>();
            ArrayList<Branches> temp2 = new ArrayList<>();
            for (Branches b : ramas) {
                for (int i = 0; i < ciudades.length; i++) {
                    if (b.ar.contains(ciudades[i])) {
                        continue;
                    }
                    Branches ch = new Branches(b);
                    ch.sum = b.sum + multiplicador * arr(b.ar.get(b.ar.size() - 1))[i];
                    ch.ar.add(ciudades[i]);
                    temp.add(ch);
                }
                temp2.add(b);
            }
            ramas.removeAll(temp2);
            ramas.addAll(temp);
            multiplicador--;
        }
    }

    public static int[] arr(String s) {
        switch (s) {
            case "La Coruna":
                return coruna;
            case "Bilbao":
                return bilbao;
            case "Barcelona":
                return bcn;
            case "Sevilla":
                return sevilla;
            case "Valencia":
                return valencia;
            case "Madrid":
                return madrid;
        }
        int[] a = null;
        return a;
    }


}

class Branches {
    int sum;
    ArrayList<String> ar = new ArrayList<>();

    public Branches(int c) {
        sum = c;
    }
    public Branches(Branches b) {
        sum = 0;
        for (String s: b.ar) {
            this.ar.add(s);
        }
    }

    public void add(int cart, String s) {
        sum += cart;
        ar.add(s);
    }

}