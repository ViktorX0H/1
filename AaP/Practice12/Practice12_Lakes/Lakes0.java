package Practice12_Lakes;

import java.util.Scanner;

class Ozera {
    String name,loc;
    double square;
}
public class Lakes0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введите количество озер=> ");
        int n = sc.nextInt();
        Ozera[] lake = new Ozera[n];
        for (int i = 0; i < lake.length; i++) {
            lake[i] = new Ozera();
            sc.nextLine();
            System.out.print("Название " + (i + 1) + "го озера => ");
            lake[i].name = sc.nextLine();
            System.out.print("Местоположение " + (i + 1) + "го озера => ");
            lake[i].loc = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-го озера => ");
            lake[i].square = sc.nextDouble();
        }
        System.out.println("\nХарактеристики озёр:");
        for (int i = 0; i < lake.length; i++) {
            System.out.println("Name " + lake[i].name +" Location "+lake[i].loc+
                    " square " + lake[i].square + " сот кв. м");
        }
        int nommax = 0;
        double max = lake[nommax].square;
        for (int i = 0; i < lake.length; i++) {
            if (lake[i].square > max) {
                max = lake[i].square;
                nommax = i;
            }
        }
        System.out.println("\nОзеро с максимальной площадью :");
        System.out.println("" + lake[nommax].name +"\t"+lake[nommax].loc+
                "\t" + lake[nommax].square + "сот кв. м");

        for (int i = 0; i < lake.length - 1; i++) {
            for (int j = 0; j < lake.length - 1 - i; j++) {
                if (lake[j].square > lake[j + 1].square) {
                    Ozera rab1 = lake[j]; // rab – рабочая переменная для перестановки
                    lake[j] = lake[j + 1];
                    lake[j + 1] = rab1;
                }
            }
        }
        System.out.println("\nОтсортированный список по площади:");
        for (int i = 0; i < lake.length; i++) {
            System.out.println(""+lake[i].name+"\t"+lake[i].loc+
                    "\t"+lake[i].square+"сот кв. м");
        }
        for (int i = 0; i < lake.length-1; i++) {
            for (int j = 0; j < lake.length - i - 1; j++) {
                if (lake[j].name.compareTo(lake[i + 1].name) > 0) {
                    Ozera rab2 = lake[j]; // rab – рабочая переменная для перестановки
                    lake[j] = lake[j + 1];
                    lake[j + 1] = rab2;
                }
            }
        }
        System.out.println("\nОтсортированный список по названиям:");
        for (int i = 0; i < lake.length; i++) {
            System.out.println("" + lake[i].name + "\t"+lake[i].loc+
                    "\t" + lake[i].square + " сот кв. м");
        }
        double s = 0;
        for (int i = 0; i < lake.length; i++)
            s += lake[i].square;
        double sr = s / lake.length;

        System.out.println("Средняя площадь =" + sr);
        sc.nextLine();
        System.out.println("\nОзера, с площадью больше средней");
        for (int i = 0; i < lake.length; i++) {
            if (lake[i].square > sr | lake[i].square == sr)  {
                System.out.println(lake[i].name + "\t"+lake[i].loc+
                        "\t" + lake[i].square + " млн кв. км");
            }
        }
        System.out.print("Введите название искомого озера=> ");
        String name = sc.nextLine();
        sc.nextLine();
        int nom = -1;
        for (int i = 0; i < lake.length; i++)
            if (name.equalsIgnoreCase(lake[i].name))
                nom = i;
        if (nom != -1) {
            System.out.println("Такое озеро есть в списке. Это " + lake[nom].name);
            System.out.println("Желаете внести изменения в одно из полей, y или n?");
            String answer1 = sc.nextLine();
            switch (answer1) {
                case  "y":
                    System.out.println("В какое поле, name/square/location?");
                    String answer2 = sc.nextLine();
                    switch (answer2) {
                        case "name":
                            lake[nom].name = sc.nextLine();
                            break;
                        case "square":
                            lake[nom].square = sc.nextDouble();
                            break;
                        case "location":
                            lake[nom].loc = sc.nextLine();
                            break;
                    }
                    break;
                default:
                    System.out.println("Name " + lake[nom].name +" Location "+lake[nom].loc
                            +" square " + lake[nom].square + " сот кв. м");
                    break;
            }
            System.out.println("Name " + lake[nom].name +" Location "+lake[nom].loc
                    +" square " + lake[nom].square + " сот кв. м");
        }
        else System.out.println("Такой страны нет в списке");
}
}