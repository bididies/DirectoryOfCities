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
        List <Integer> counts = new ArrayList<>();

        List <String> districtsAll = cities.stream().
                map(City::getDistrict).
                collect(Collectors.toList());
        List <String> districts = districtsAll.stream().
                distinct().
                collect(Collectors.toList());

        for (String district1: districts) {
            int count = 0;
            for (String district2: districtsAll) {
                if(district1.equals(district2)){
                    count++;
                }
            }
            counts.add(count);
        }

        Map <String, Integer> countCities = new HashMap<>();
        for (int i = 0; i < districts.size(); i++) {
            countCities.put(districts.get(i), counts.get(i));
        }

        for (Map.Entry <String, Integer> entry: countCities.entrySet()) {
            System.out.println(entry.getKey()+ " - " + entry.getValue());
        }
    }

}
