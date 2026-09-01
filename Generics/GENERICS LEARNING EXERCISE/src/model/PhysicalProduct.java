package model;



public class PhysicalProduct extends Product {

    private final double weightKg;

    public PhysicalProduct(
            int id,
            String name,
            double price,
            double weightKg) {

        super(id, name, price);

        this.weightKg = weightKg;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public String toString() {
        return "PhysicalProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", weightKg=" + weightKg +
                '}';
    }
}