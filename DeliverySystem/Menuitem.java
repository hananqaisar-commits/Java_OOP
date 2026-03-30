
class Menuitem {
    private String name;
    private String category;
    private double price;

    public Menuitem() {
        name = "Unknown";
        category = "Unknown";
        price = 0.0;
    }

    public Menuitem(String name, String category, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Menuitem(Menuitem other) {
        this.category = other.category;
        this.name = other.name;
        this.price = other.price;
    }

    public void setCategory(String category) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.category = category;
        }
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price == 0.0) {
            System.out.println("Invalid");
        } else {
            this.price = price;
        }
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

}