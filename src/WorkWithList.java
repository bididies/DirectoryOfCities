import java.util.*;
import java.util.stream.Collectors;

public class WorkWithList {
    public static void sortByName(List<City> cities){
        cities.stream().
                sorted((c1, c2) -> c2.getName().toLowerCase().compareTo(c1.getName().toLowerCase())).
                forEach(System.out::println);
    }

    public static void sortByDistrictAndName(List<City> cities){
        cities.stream().
                sorted((c1, c2) -> c2.getDistrict().compareTo(c1.getDistrict())).
                sorted((c1, c2) -> {
                    if(c1.getDistrict().equals(c2.getDistrict())){
                      return c2.getName().compareTo(c1.getName());
                    }
                    return 0;}).
                forEach(System.out::println);
    }

    public static void searchMoreCity(List<City> cities){
        City city = cities.stream().
                max(Comparator.comparingInt(City::getPopulation)).
                get();
        System.out.println("[" + city.getId() + "] = " + city.getPopulation());
    }

    public static void numberOfCities(List<City> cities){
        Map <String, List <City>> countCities= cities.stream().
                 collect(Collectors.groupingBy(City::getDistrict, Collectors.toList()));

        for (Map.Entry <String, List <City>> entry: countCities.entrySet()) {
            System.out.println(entry.getKey()+ " - " + entry.getValue().size());
        }
    }

}
