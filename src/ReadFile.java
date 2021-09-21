import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadFile {
    public static List<String> readListOfCities(){
        List <String> cities = new ArrayList<>();

        try(Scanner scan = new Scanner(Path.of("src/Cities.txt"))){

            while (scan.hasNextLine()){
                String city = scan.nextLine();
                cities.add(city);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public static List <City> createCities(List<String> list){
        List <City> cities = new ArrayList<>();

        List<String[]> collect = list.stream().
                map(c -> c.split(";")).
                peek(c -> cities.add(new City(Integer.parseInt(c[0]),c[1],c[2],c[3],Integer.parseInt(c[4]),c[5]))).
                collect(Collectors.toList());

        return cities;
    }

}
