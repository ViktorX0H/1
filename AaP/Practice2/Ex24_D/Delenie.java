package Ex24_D;
import java.util.Scanner;
public class Delenie {
    static double eps = 0.00000001;

    public static double funcia(double x) {

        return (Math.pow(x, 3) -3.5 * Math.pow(x, 2) + 0.5 * x + 5);
    }

    public static void solve(double m, double n) {
        System.out.println((m + n) / 2);
        if (Math.abs(n - m) > eps) {
            double x = (m + n) / 2;
            if (funcia(m) * funcia(n) > 0) {
                m = x;
            } else {
                n = x;
            }
            solve(m, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input m: ");
        double m = sc.nextDouble();
        System.out.println("Input n: ");
        double n = sc.nextDouble();
        solve(m, n);

    }
}
