package Ex22;

import java.util.Scanner;

public class ex2_2 {
    public static void dectoBin(int x) {
        if (x / 2 != 0) {
            dectoBin(x / 2);
        }
        System.out.println(x % 2);
    }

    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int x = sc.nextInt();
        dectoBin(x);
    }
}
