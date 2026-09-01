package repository;



import model.Product;

public class ProductRepository
        extends GenericRepository<Product> {

    public void printProductCount() {

        System.out.println(
                "Product count: " + entities.size()
        );
    }
}