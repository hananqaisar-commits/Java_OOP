package Product_Sorting;

class Product implements Comparable<Product> {
    private String name;
    private int id;
    private double price;
    private double count_rating;
    private final double rating = 10.0;

    public Product(String name, int id, double price, double count_rating) {

        this.name = name;
        this.id = id;
        this.price = price;
        this.count_rating = count_rating;

    }

    public void setCount_rating(double count_rating) {
        this.count_rating = count_rating;
    }

    public double getCount_rating() {
        return count_rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product obj) {
        int result = Double.compare(this.getPrice(), obj.getPrice());

        return result;
    }

    @Override
    public String toString() {
        return String.format("  %-6d %-16s %-6f | %.2f/%.2f", getId(), getName(), getPrice(), getCount_rating(),
                rating);
    }
}
