package model;



public class DigitalProduct extends Product {

    private final double fileSizeMB;

    public DigitalProduct(
            int id,
            String name,
            double price,
            double fileSizeMB) {

        super(id, name, price);

        this.fileSizeMB = fileSizeMB;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String toString() {
        return "DigitalProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", fileSizeMB=" + fileSizeMB +
                '}';
    }
}