package util;



import model.Product;

import java.util.List;

public class GenericsUtils {

    // ============================================================
    // 1. GENERIC METHOD
    // ============================================================

    public static <T> void print(T value) {

        System.out.println(
                "Value: " + value
        );
    }


    // ============================================================
    // 2. GENERIC METHOD WITH RETURN TYPE
    // ============================================================

    public static <T> T getFirst(List<T> list) {

        if (list == null || list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }


    // ============================================================
    // 3. MULTIPLE TYPE PARAMETERS
    // ============================================================

    public static <K, V> void printPair(
            K key,
            V value) {

        System.out.println(
                "Key = " + key +
                        ", Value = " + value
        );
    }


    // ============================================================
    // 4. UNBOUNDED WILDCARD
    // ============================================================

    public static void printAnyList(
            List<?> list) {

        for (Object item : list) {

            System.out.println(
                    "Item: " + item
            );
        }
    }


    // ============================================================
    // 5. UPPER BOUNDED WILDCARD
    //
    // Producer Extends
    // ============================================================

    public static double calculateTotalPrice(
            List<? extends Product> products) {

        double total = 0;

        for (Product product : products) {

            total += product.getPrice();
        }

        return total;
    }


    // ============================================================
    // 6. LOWER BOUNDED WILDCARD
    //
    // Consumer Super
    // ============================================================

    public static void addProducts(
            List<? super Product> products) {

        products.add(
                new Product(
                        100,
                        "Generic Product",
                        999
                )
        );

        products.add(
                new Product(
                        101,
                        "Another Product",
                        1999
                )
        );
    }


    // ============================================================
    // 7. BOUNDED TYPE PARAMETER
    // ============================================================

    public static <T extends Number>
    double square(T number) {

        double value = number.doubleValue();

        return value * value;
    }


    // ============================================================
    // 8. GENERIC METHOD WITH UPPER BOUND
    // ============================================================

    public static <T extends Product>
    void printProductDetails(T product) {

        System.out.println(
                "Product ID: " + product.getId()
        );

        System.out.println(
                "Product Name: " + product.getName()
        );

        System.out.println(
                "Product Price: ₹" + product.getPrice()
        );
    }
}