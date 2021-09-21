import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List <String> list = ReadFile.readListOfCities();
        List <City> cities = ReadFile.createCities(list);
        int option;

        while(true) {
            Console.consoleMessage();
                try{
                    Scanner scan = new Scanner(System.in);
                    option = scan.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Некорректный ввод, введите цифру от 1 до 6");
                    continue;
                }

            if(option == 6){break;}
            Console.choiceOption(option, cities);
        }

    }
}
