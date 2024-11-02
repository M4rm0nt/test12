import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        Map<Integer, List<List<Map<Integer, String>>>> mapOfRegions = new HashMap<>();

        int regionId1 = 1;
        List<List<Map<Integer, String>>> branchesRegion1 = new ArrayList<>();

        List<Map<Integer, String>> branch1Region1 = new ArrayList<>();

        Map<Integer, String> category1Branch1 = new HashMap<>();
        category1Branch1.put(1001, "Produkt A");
        category1Branch1.put(1002, "Produkt B");
        branch1Region1.add(category1Branch1);

        Map<Integer, String> category2Branch1 = new HashMap<>();
        category2Branch1.put(1003, "Produkt C");
        category2Branch1.put(1004, "Produkt D");
        branch1Region1.add(category2Branch1);
        branchesRegion1.add(branch1Region1);


        List<Map<Integer, String>> branch2Region1 = new ArrayList<>();

        Map<Integer, String> category1Branch2 = new HashMap<>();
        category1Branch2.put(1005, "Produkt E");
        category1Branch2.put(1006, "Produkt F");
        branch2Region1.add(category1Branch2);
        branchesRegion1.add(branch2Region1);

        mapOfRegions.put(regionId1, branchesRegion1);

        int regionId2 = 2;
        List<List<Map<Integer, String>>> branchesRegion2 = new ArrayList<>();

        List<Map<Integer, String>> branch1Region2 = new ArrayList<>();

        Map<Integer, String> category1Branch3 = new HashMap<>();
        category1Branch3.put(2001, "Produkt G");
        category1Branch3.put(2002, "Produkt H");
        branch1Region2.add(category1Branch3);
        branchesRegion2.add(branch1Region2);


        List<Map<Integer, String>> branch2Region2 = new ArrayList<>();

        Map<Integer, String> category1Branch4 = new HashMap<>();
        category1Branch4.put(2003, "Produkt I");
        category1Branch4.put(2004, "Produkt J");
        branch2Region2.add(category1Branch4);
        branchesRegion2.add(branch2Region2);

        mapOfRegions.put(regionId2, branchesRegion2);

        /*
        for (Map.Entry<Integer, List<List<Map<Integer, String>>>> regionEntry : mapOfRegions.entrySet()) {
            Integer regionId = regionEntry.getKey();
            System.out.println("Region ID: " + regionId);
            List<List<Map<Integer, String>>> branches = regionEntry.getValue();
            int branchNumber = 1;
            for (List<Map<Integer, String>> branch : branches) {
                System.out.println("  Filiale " + branchNumber + ":");
                int categoryNumber = 1;
                for (Map<Integer, String> category : branch) {
                    System.out.println("    Kategorie " + categoryNumber + ":");
                    for (Map.Entry<Integer, String> productEntry : category.entrySet()) {
                        Integer productId = productEntry.getKey();
                        String productName = productEntry.getValue();
                        System.out.println("      Produkt ID: " + productId + ", Produktname: " + productName);
                    }
                    categoryNumber++;
                }
                branchNumber++;
            }
        }
         */

        mapOfRegions.entrySet().stream().forEach(regionEntry -> {
            Integer regionId = regionEntry.getKey();
            System.out.println("Region ID: " + regionId);
            List<List<Map<Integer, String>>> branches = regionEntry.getValue();

            AtomicInteger branchCounter = new AtomicInteger(1);
            branches.stream().forEach(branch -> {
                System.out.println("  Filiale " + branchCounter.getAndIncrement() + ":");

                AtomicInteger categoryCounter = new AtomicInteger(1);
                branch.stream().forEach(category -> {
                    System.out.println("    Kategorie " + categoryCounter.getAndIncrement() + ":");

                    category.entrySet().stream().forEach(productEntry -> {
                        Integer productId = productEntry.getKey();
                        String productName = productEntry.getValue();
                        System.out.println("      Produkt ID: " + productId + ", Produktname: " + productName);
                    });
                });
            });
        });

    }
}