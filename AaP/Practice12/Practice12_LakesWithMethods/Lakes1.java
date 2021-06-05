package Practice12_LakesWithMethods;

import java.util.Scanner;

class Ozera {
    String name,loc;
    double square;
}

public class Lakes1 {
    static Scanner sc = new Scanner(System.in, "cp1251");

    public static Ozera[] setLakeArr(int k) {
        Ozera lake[] = new Ozera[k];
        System.out.println("Введите информацию об озерах: ");
        for (int i = 0; i < lake.length; i++) {
            lake[i] = new Ozera();
            System.out.print("Название " + (i + 1) + "-го озера => ");
            lake[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-го озера => ");
            lake[i].square = sc.nextDouble();
            System.out.print("Местоположение " + (i + 1) + "го озера => ");
            lake[i].loc = sc.nextLine();
            sc.nextLine();
        }
        return lake;
    }

    public static void showArray(Ozera[] lk) {
        for (int i = 0; i < lk.length; i++) {
            System.out.println("Name " + lk[i].name +" Location "+lk[i].loc+
                    " square " + lk[i].square + " сот кв. м");
        }
    }
    public static void showLake(Ozera[] lk, int n) {
        System.out.println("" + lk[n].name +"\t"+lk[n].loc+
                "\t" + lk[n].square + "сот кв. м");
    }

    public static int NomMax(Ozera[] lk) {
        int nommax = 0;

        double max = lk[nommax].square;
        for (int i = 0; i < lk.length; i++)
            if (lk[i].square > max) {
                max = lk[i].square;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSquare(Ozera[] lk) {
        for (int i = 0; i < lk.length - 1; i++)
            for (int j = 0; j < lk.length - 1 - i; j++)
                if (lk[j].square > lk[j + 1].square) {
                    Ozera rab = lk[j];
                    lk[j] = lk[i + 1];
                    lk[j + 1] = rab;
                }
    }

    public static void sortName(Ozera[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Ozera rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static double avgSquare(Ozera[] cntr) {
        double s = 0;
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].square;
        double sr = s / cntr.length;
        return sr;
    }

    public static Ozera[] Larger(Ozera cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0;
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].square > sred)
                ++kol;
        }
        if (kol != 0) {
            Ozera[] bigLake = new Ozera[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].square > sred) {
                    bigLake[++n] = cntr[i];
                }
            return bigLake;
        } else return null;
    }

    public static int findForName(Ozera cntr[], String name) {
        int n = -1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return n;
        } else return 0;
    }

    public static Ozera Changes(Ozera lk[], String answer, int nom) {
        switch (answer) {
            case "y":
                System.out.println("В какое поле, name/square/location?");
                String answer2 = sc.nextLine();
                switch (answer2) {
                    case "name":
                        lk[nom].name = sc.nextLine();
                        break;
                    case "square":
                        lk[nom].square = sc.nextDouble();
                        break;
                    case "location":
                        lk[nom].loc = sc.nextLine();
                        break;
                }
                break;
            default:
                return null;
        }
        return lk[nom];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество озер=> ");
        int n = sc.nextInt();
        Ozera country[] = setLakeArr(n);

        System.out.println("\nХарактеристики озер:");
        showArray(country);
        int nommax = NomMax(country);
        System.out.println("\nОзеро с максимальной площадью:");
        showLake(country,nommax);

        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);

        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);

        System.out.println("Средняя площадь =" + avgSquare(country));

        System.out.println("\nОзера, с площадью больше средней");
        Ozera[] larger = Larger (country);
        showArray(larger);

        System.out.println("\nПОИСК СТРАНЫ \n Введите название озера => ");
        sc.nextLine();
        String sname = sc.nextLine();
        int sfind = findForName(country, sname);
        if (sfind != 0) {
            System.out.println("Желаете внести изменения в одно из полей, y или n?");
            String answer = sc.nextLine();
            Changes(country, answer,sfind);
            showLake(country,n);
        } else {
            System.out.println("Такого озера нет в списке!");
        }

    }
}