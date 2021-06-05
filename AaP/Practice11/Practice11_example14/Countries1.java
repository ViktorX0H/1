package Practice11_example14;

import java.util.Scanner;

class Strana {
    String name;
    double ploshad;
}
public class Countries1 {
    public static Strana[] setCountryArr(int k) {
        Scanner sc = new Scanner(System.in, "cp1251");
        Strana country[] = new Strana[k];

        System.out.println("Введите информацию о странах: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("Название " + (i + 1) + "-й страны => ");

            country[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й страны => ");

            country[i].ploshad = sc.nextDouble();
            sc.nextLine();
        }
        return country;
    }

    public static void showArray(Strana[] cntr) {
        for (int i = 0; i < cntr.length; i++) {
            System.out.println("" + cntr[i].name + " \t" + cntr[i].ploshad + " млн кв. км");
        }
    }

    public static void showCountry(Strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.ploshad + " млн кв. км");
    }

    public static int NomMax(Strana[] st) {
        int nommax = 0;
        double max = st[nommax].ploshad;
        for (int i = 0; i < st.length; i++)
            if (st[i].ploshad > max) {
                max = st[i].ploshad;
                nommax = i;
            }
        return nommax;
    }

    public static void sortSquare(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].ploshad > cntr[j + 1].ploshad) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static void sortName(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Strana rab = cntr[j];
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static double avgSquare(Strana[] cntr) {
        double s = 0;
        for (int i = 0; i < cntr.length; i++)
            s += cntr[i].ploshad;
        double sr = s / cntr.length;
        return sr;
    }

    public static Strana[] Bigger(Strana cntr[]) {
        double sred = avgSquare(cntr);
        int kol = 0;
        for (int i = 0; i < cntr.length; i++) {
            if (cntr[i].ploshad > sred)
                ++kol;
        }
        if (kol != 0) {
            Strana[] bigCountry = new Strana[kol];
            int n = -1;
            for (int i = 0; i < cntr.length; i++)
                if (cntr[i].ploshad > sred) {
                    bigCountry[++n] = cntr[i];
                }
            return bigCountry;
        } else return null;
    }

    public static Strana findForName(Strana cntr[], String name) {
        int n = -1;
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество стран=> ");
        int n = sc.nextInt();
        Strana country[] = setCountryArr(n);

        System.out.println("\nХарактеристики стран:");
        showArray(country);
        int nommax = NomMax(country);
        System.out.println("\nСтрана с максимальной площадью:");
        showCountry(country[nommax]);

        sortSquare(country);
        System.out.println("\nОтсортированный список по площади:");
        showArray(country);

        sortName(country);
        System.out.println("\nОтсортированный список по названиям:");
        showArray(country);

        System.out.println("\nСредняя площадь =" + avgSquare(country));

        System.out.println("\nСтраны, с площадью больше средней");
        Strana[] larger = Bigger(country);
        showArray(larger);

        System.out.println("\nПОИСК СТРАНЫ \n Введите название страны => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(country, sname);
        if (sfind != null) {
            showCountry(sfind);
        } else {
            System.out.println("Такой страны нет в списке!");
        }
    }
}
