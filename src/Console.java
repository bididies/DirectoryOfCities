import java.util.List;
import java.util.Scanner;

public class Console {

    public static void consoleMessage(){
        System.out.println();
        System.out.println("1.Показать весь список городов.");
        System.out.println("2.Показать список городов, отсортированный по убыванию в алфавитном порядке.");
        System.out.println("3.Показать список городов, отсортированный по федеральному округу и наименованию города.");
        System.out.println("4.Показать город с наибольшим количеством жителей.");
        System.out.println("5.Показать количество городов в разрезе регионов.");
        System.out.println("6.Выход");
        System.out.println();
        System.out.println("Введите цифру необходимого пункта меню:");
    }

    public static void choiceOption(int number, List<City> cities){
        switch (number){
            case 1: cities.forEach(System.out::println); break;
            case 2: WorkWithList.sortByName(cities); break;
            case 3: WorkWithList.sortByDistrictAndName(cities); break;
            case 4: WorkWithList.searchMoreCity(cities); break;
            case 5: WorkWithList.numberOfCities(cities); break;
            default:
                System.out.println("Некорректный ввод, введите цифру от 1 до 6");
        }
    }

}
