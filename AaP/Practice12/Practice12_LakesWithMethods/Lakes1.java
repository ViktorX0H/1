package Practice12_LakesWithMethods;

import java.util.Scanner;
class Lake {
    String name, location;
    double ploshad;
}
public class Lakes1 {
    static Scanner sc;

    public static Lake[] LakesArr(int c){
        Lake[] ozero = new Lake[c];
        for (int i = 0; i < ozero.length; i++) {
            ozero[i] = new Lake();
            System.out.println("Название => ");
            ozero[i].name = sc.nextLine();
            System.out.println("Местоположение => ");
            ozero[i].location = sc.nextLine();
            System.out.println("Площадь=> ");
            ozero[i].ploshad = sc.nextDouble();
            sc.nextLine();
        }
        return ozero;
    }

    private static void printInfoTeams(Lake[] ozero) {
        for (int i = 0; i < ozero.length; i++) {
            System.out.println("Название: " + ozero[i].name + "\t" + "Местоположение: " + ozero[i].location + "\t"+ "Площадь: " + ozero[i].ploshad);
        }
    }

    public static int maxp(Lake[] ozero) {
        int pmax = 0;
        double max = ozero[pmax].ploshad;
        for (int i = 0; i < ozero.length; i++)
            if (ozero[i].ploshad > max) {
                max = ozero[i].ploshad;
                pmax = i;
            }
        return pmax;
    }

    public static void sortLake(Lake[] ozero) {
        for (int i = 0; i < ozero.length - 1; i++)
            for (int j = 0; j < ozero.length - i - 1; j++)
                if (ozero[j].name.compareTo(ozero[i + 1].name) > 0) {
                    Lake rab = ozero[j];
                    ozero[j] = ozero[j + 1];
                    ozero[j + 1] = rab;
                }
    }

    public static double SRpl(Lake[] ozero) {
        double s = 0;
        for (int i = 0; i < ozero.length; i++) {
            s += ozero[i].ploshad;
        }
        double sr = s / ozero.length;
        return sr;
    }

    public static void printSR(Lake[] ozero, double avgWins) {
        for (int i = 0; i < ozero.length; i++) {
            if (ozero[i].ploshad > avgWins) {
                printInfoTeams(ozero[i]);
            }
        }
    }

    public static int findLake(Lake[] ozero, String searchName){
        String nameSearch = sc.nextLine();
        int searchIndex = -1;
        for (int i = 0; i < ozero.length; i++) {
            if (ozero[i].name.equals(nameSearch)) {
                searchIndex = i;
            }
        }
        return searchIndex;
    }
    public static void remake(Lake ozero) {
        System.out.println("Какое поле хотите изменить");
        System.out.println("name, location, place, ploshad");
        String pole = sc.nextLine();
        switch (pole) {
            case "name": {
                System.out.println("Введите новое имя");
                String newName = sc.nextLine();
                ozero.name = newName;
                break;
            }
            case "location": {
                System.out.println("Введите новый город");
                String newCity = sc.nextLine();
                ozero.location = newCity;
                break;
            }
            case "ploshad": {
                System.out.println("Введите новое количество побед");
                double newWin = sc.nextDouble();
                ozero.ploshad = (int) newWin;
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Co => ");
        sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        Lake[] ozero = new Lake[count];
        ozero = LakesArr(count);
        printInfoTeams(ozero);
        int Nommax = maxp(ozero);
        System.out.println("Команда с самым большим количеством побед: ");
        printInfoTeams(ozero[Nommax]);
        sortLake(ozero);
        System.out.println("\nОтсортированный список:");
        printInfoTeams(ozero);
        double AvgWins = SRpl(ozero);
        System.out.println("Среднее значение: ");
        System.out.println("SRpl =" + AvgWins);
        System.out.println("\nКоманды, с количеством побед больше средней");
        printSR(ozero, AvgWins);
        System.out.println("Enter name");
        String searchName = sc.nextLine();
        int searchIndex = findLake(ozero, searchName);
        if(searchIndex!=1){
            System.out.println("Найдена команда => ");
            printInfoTeams(ozero[searchIndex]);
            remake(ozero[searchIndex]);
            System.out.println("Отредактированная информация о команде:");
            printInfoTeams(ozero[searchIndex]);
        }
        else{
            System.out.println("Ничего не найдено");
        }
    }

}