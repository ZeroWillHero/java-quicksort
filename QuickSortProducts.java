import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickSortProducts {

    public static void quickSortProducts(List<Map<String, Object>> products, int low, int high, boolean ascending) {
        if (low < high) {
            int pivotIndex = partition(products, low, high, ascending);
            quickSortProducts(products, low, pivotIndex - 1, ascending);
            quickSortProducts(products, pivotIndex + 1, high, ascending);
        }
    }

    private static int partition(List<Map<String, Object>> products, int low, int high, boolean ascending) {
        double pivot = (double) products.get(high).get("price"); // Use 'price' as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            double currentPrice = (double) products.get(j).get("price");
            if ((currentPrice <= pivot && ascending) || (currentPrice >= pivot && !ascending)) {
                i++;
                // Swap products[i] and products[j]
                Map<String, Object> temp = products.get(i);
                products.set(i, products.get(j));
                products.set(j, temp);
            }
        }

        // Place the pivot in its correct position
        Map<String, Object> temp = products.get(i + 1);
        products.set(i + 1, products.get(high));
        products.set(high, temp);

        return i + 1;
    }

    public static void main(String[] args) {
        // Sample product catalog
        List<Map<String, Object>> products = new ArrayList<>();

        Map<String, Object> product1 = new HashMap<>();
        product1.put("name", "Laptop");
        product1.put("price", 800.0);

        Map<String, Object> product2 = new HashMap<>();
        product2.put("name", "Headphones");
        product2.put("price", 50.0);

        Map<String, Object> product3 = new HashMap<>();
        product3.put("name", "Keyboard");
        product3.put("price", 30.0);

        Map<String, Object> product4 = new HashMap<>();
        product4.put("name", "Smartphone");
        product4.put("price", 500.0);

        Map<String, Object> product5 = new HashMap<>();
        product5.put("name", "Monitor");
        product5.put("price", 200.0);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        // Sort products by price (low to high)
        quickSortProducts(products, 0, products.size() - 1, true);
        System.out.println("Products sorted by price (low to high):");
        printProducts(products);

        // Sort products by price (high to low)
        quickSortProducts(products, 0, products.size() - 1, false);
        System.out.println("Products sorted by price (high to low):");
        printProducts(products);
    }

    private static void printProducts(List<Map<String, Object>> products) {
        for (Map<String, Object> product : products) {
            System.out.println("Name: " + product.get("name") + ", Price: " + product.get("price"));
        }
    }
}
