import java.util.Scanner;

/**
 * Created by lucas on 25/02/17.
 */
public class Paquetes {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            int size = s.length() * 8;
            if (size > 240) {
                System.out.println("NO");
            } else {
                System.out.println("SI");
            }
        }
    }
}
