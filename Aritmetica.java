import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lucas on 25/02/17.
 */
public class Aritmetica {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        BigInteger a = sc.nextBigInteger();
        List<BigInteger> f = primeDecomp(a);

        int exp = 1;
        BigInteger prev = null;
        String sol = "";
        for (int i = 0; i < f.size(); i++) {
            BigInteger b = f.get(i);
            if (prev != b) {
                if (prev != null) {
                    sol += prev.toString();
                    if (exp > 1) {
                        sol += "^" + exp;
                    }
                    if (i < f.size()) {
                        sol += "*";
                    }
                }
                exp = 1;
                prev = b;
            } else {
                exp++;
            }
        }
        sol += f.get(f.size()-1).toString();
        System.out.println(sol);

    }

    private static final BigInteger two = BigInteger.valueOf(2);

    public  static List<BigInteger> primeDecomp(BigInteger a) {
        // impossible for values lower than 2
        if (a.compareTo(two) < 0) {
            return null;
        }

        //quickly handle even values
        List<BigInteger> result = new ArrayList<BigInteger>();
        while (a.and(BigInteger.ONE).equals(BigInteger.ZERO)) {
            a = a.shiftRight(1);
            result.add(two);
        }

        //left with odd values
        if (!a.equals(BigInteger.ONE)) {
            BigInteger b = BigInteger.valueOf(3);
            while (b.compareTo(a) < 0) {
                if (b.isProbablePrime(10)) {
                    BigInteger[] dr = a.divideAndRemainder(b);
                    if (dr[1].equals(BigInteger.ZERO)) {
                        result.add(b);
                        a = dr[0];
                    }
                }
                BigInteger[] dr = a.divideAndRemainder(b);
                if (!dr[1].equals(BigInteger.ZERO)) {
                    b = b.add(two);
                }
            }
            result.add(b); //b will always be prime here...
        }
        return result;
    }
}
