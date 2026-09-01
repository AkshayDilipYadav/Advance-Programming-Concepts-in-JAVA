//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import model.DigitalProduct;
import model.PhysicalProduct;
import model.Product;
import repository.ProductRepository;
import response.ApiResponse;
import util.GenericsUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // ========================================================
        // 1. CREATE PRODUCTS
        // ========================================================

        Product laptop =
                new Product(
                        1,
                        "MacBook",
                        150000
                );

        DigitalProduct course =
                new DigitalProduct(
                        2,
                        "Java Course",
                        5000,
                        2500
                );

        PhysicalProduct phone =
                new PhysicalProduct(
                        3,
                        "iPhone",
                        100000,
                        0.5
                );


        // ========================================================
        // 2. GENERIC REPOSITORY
        // ========================================================

        ProductRepository repository =
                new ProductRepository();

        repository.save(laptop);
        repository.save(course);
        repository.save(phone);

        repository.printProductCount();

        System.out.println();


        // ========================================================
        // 3. FIND ALL
        // ========================================================

        List<Product> products =
                repository.findAll();

        for (Product product : products) {

            System.out.println(product);
        }

        System.out.println();


        // ========================================================
        // 4. OPTIONAL<T>
        // ========================================================

        Optional<Product> result =
                repository.findById(1);

        result.ifPresent(
                product ->
                        System.out.println(
                                "Found: " + product
                        )
        );

        System.out.println();


        // ========================================================
        // 5. GENERIC API RESPONSE
        // ========================================================

        ApiResponse<Product> response =
                new ApiResponse<>(
                        true,
                        "Product fetched successfully",
                        laptop
                );

        System.out.println(response);

        System.out.println();


        // ========================================================
        // 6. NESTED GENERICS
        // ========================================================

        ApiResponse<List<Product>> listResponse =
                new ApiResponse<>(
                        true,
                        "Products fetched",
                        products
                );

        System.out.println(listResponse);

        System.out.println();


        // ========================================================
        // 7. GENERIC METHOD
        // ========================================================

        GenericsUtils.print("Hello Generics");

        GenericsUtils.print(100);

        GenericsUtils.print(99.99);

        GenericsUtils.print(laptop);

        System.out.println();


        // ========================================================
        // 8. GENERIC METHOD RETURNING T
        // ========================================================

        String firstName =
                GenericsUtils.getFirst(
                        List.of(
                                "Akshay",
                                "Rahul",
                                "Amit"
                        )
                );

        System.out.println(
                "First name: " + firstName
        );


        Integer firstNumber =
                GenericsUtils.getFirst(
                        List.of(
                                10,
                                20,
                                30
                        )
                );

        System.out.println(
                "First number: " + firstNumber
        );

        System.out.println();


        // ========================================================
        // 9. MULTIPLE TYPE PARAMETERS
        // ========================================================

        GenericsUtils.printPair(
                "Product ID",
                101
        );

        GenericsUtils.printPair(
                101,
                "MacBook"
        );

        GenericsUtils.printPair(
                "Price",
                150000.0
        );

        System.out.println();


        // ========================================================
        // 10. UNBOUNDED WILDCARD
        //
        // List<?>
        // ========================================================

        List<String> names =
                List.of(
                        "Akshay",
                        "Rahul",
                        "Amit"
                );

        List<Integer> numbers =
                List.of(
                        10,
                        20,
                        30
                );

        System.out.println(
                "Printing names:"
        );

        GenericsUtils.printAnyList(names);

        System.out.println();

        System.out.println(
                "Printing numbers:"
        );

        GenericsUtils.printAnyList(numbers);

        System.out.println();


        // ========================================================
        // 11. UPPER BOUNDED WILDCARD
        //
        // ? extends Product
        // ========================================================

        List<DigitalProduct> digitalProducts =
                List.of(
                        course
                );

        List<PhysicalProduct> physicalProducts =
                List.of(
                        phone
                );

        double digitalTotal =
                GenericsUtils.calculateTotalPrice(
                        digitalProducts
                );

        double physicalTotal =
                GenericsUtils.calculateTotalPrice(
                        physicalProducts
                );

        System.out.println(
                "Digital products total: ₹" +
                        digitalTotal
        );

        System.out.println(
                "Physical products total: ₹" +
                        physicalTotal
        );

        System.out.println();


        // ========================================================
        // 12. LOWER BOUNDED WILDCARD
        //
        // ? super Product
        // ========================================================

        List<Product> productList =
                new ArrayList<>();

        GenericsUtils.addProducts(
                productList
        );

        System.out.println(
                "Products after adding:"
        );

        for (Product product :
                productList) {

            System.out.println(product);
        }

        System.out.println();


        // ========================================================
        // 13. BOUNDED TYPE PARAMETER
        //
        // <T extends Number>
        // ========================================================

        double result1 =
                GenericsUtils.square(10);

        double result2 =
                GenericsUtils.square(10.5);

        double result3 =
                GenericsUtils.square(20L);

        System.out.println(
                "Square of 10: " + result1
        );

        System.out.println(
                "Square of 10.5: " + result2
        );

        System.out.println(
                "Square of 20L: " + result3
        );

        System.out.println();


        // ========================================================
        // 14. GENERIC METHOD WITH PRODUCT BOUND
        // ========================================================

        GenericsUtils.printProductDetails(
                laptop
        );

        GenericsUtils.printProductDetails(
                course
        );

        GenericsUtils.printProductDetails(
                phone
        );

        System.out.println();


        // ========================================================
        // 15. MAP<K, V>
        // ========================================================

        Map<Integer, Product> productMap =
                new HashMap<>();

        productMap.put(
                laptop.getId(),
                laptop
        );

        productMap.put(
                course.getId(),
                course
        );

        productMap.put(
                phone.getId(),
                phone
        );

        System.out.println(
                "Product Map:"
        );

        for (
                Map.Entry<Integer, Product> entry :
                productMap.entrySet()
        ) {

            System.out.println(
                    "Key = " +
                            entry.getKey() +
                            ", Value = " +
                            entry.getValue()
            );
        }

        System.out.println();


        // ========================================================
        // 16. NESTED GENERICS
        //
        // Map<String, List<Product>>
        // ========================================================

        Map<String, List<Product>>
                productsByCategory =
                new HashMap<>();

        productsByCategory.put(
                "Electronics",
                List.of(
                        laptop,
                        phone
                )
        );

        productsByCategory.put(
                "Digital",
                List.of(
                        course
                )
        );

        System.out.println(
                "Products by category:"
        );

        System.out.println(
                productsByCategory
        );

        System.out.println();


        // ========================================================
        // 17. DIAMOND OPERATOR
        // ========================================================

        List<Product> diamondExample =
                new ArrayList<>();

        diamondExample.add(laptop);

        System.out.println(
                "Diamond operator example:"
        );

        System.out.println(
                diamondExample
        );


        // ========================================================
        // 18. AUTObOXING
        // ========================================================

        List<Integer> integerList =
                new ArrayList<>();

        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        int value =
                integerList.get(0);

        System.out.println(
                "Autoboxing/unboxing example: " +
                        value
        );
    }
}