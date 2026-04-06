import java.util.ArrayList;

class Order {
    private String CustomerName;
    private static int orderid;
    private double totalprice;
    ArrayList<Menuitem> items;

    public Order(String CustomerName) {
        {
            this.items = new ArrayList<>();
            this.CustomerName = CustomerName;
            ++orderid;
        }
    }

    public void addOrder(Menuitem item) {
        items.add(item);
    }

    public void setCustomerName(String customerName) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            CustomerName = customerName;
        }
    }

    public static int getOrderid() {
        return orderid;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setItems(Menuitem name) {
        if (items == null) {
            System.out.println("No item is selected");

        } else {
            items.add(name);
        }
    }

    public ArrayList<Menuitem> getItems() {
        return items;
    }

    public void setTotalprice(double totalprice) {
        if (totalprice == 0.0) {
            System.out.println("No order yet");

        } else {
            this.totalprice = totalprice;
        }
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void display() {
        double total = 0.0;
        for (Menuitem m : items) {
            System.out.println(m.getName() + " ");
            total += m.getPrice();
        }
        System.out.println("\nTotal Price: " + total);
    }

    @Override
    public String toString() {
        return String.format("CustomerName: %-10s\nitem %d:", getCustomerName(), getOrderid());
    }
}