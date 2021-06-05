package Ex24_N;

import java.util.Scanner;

public class Newton {
    static double eps = 0.00000001;

    public static double funcia(double x) {

        return (Math.pow(x, 3) -3.5 * Math.pow(x, 2) + 0.5 * x +5);
    }

    public static double dfuncia(double x) {

        return (3 * x * x - 7 * x +0.5);
    }

    public static void solve(double x0) {
        double x1 = x0 - funcia(x0) / dfuncia(x0);
        System.out.println(x1);
        x1 = x0 - funcia(x0) / dfuncia(x0);
        if (Math.abs(x1 - x0) > eps) {
            x0 = x1;
            x1 = x0 - funcia(x0) / dfuncia(x0);
            solve(x0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input x0");
        double x0 = sc.nextDouble();
        solve(x0);
    }
}
