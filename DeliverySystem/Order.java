import java.util.ArrayList;

class Order {
    private String CustomerName;
    private static int orderid;
    private double totalprice;
    ArrayList<Menuitem> items = new ArrayList<>();

    public Order(String CustomerName) {
        {
            this.CustomerName = CustomerName;
            ++orderid;
        }
    }

    public Order(String CustomerName, Menuitem items) {
        {
            this.CustomerName = CustomerName;
            this.items.add(items);
            ++orderid;
        }
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

    @Override
    public String toString() {
        return String.format("CustomerName: %-10s\nitem %d: %s\nPrice: %s", getCustomerName(), getOrderid(),
                getItems(), getTotalprice());
    }
}