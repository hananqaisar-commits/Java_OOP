import java.util.ArrayList;

class Resturant {
    ArrayList<Menuitem> menu = new ArrayList<>();
    private String cityName;
    private double dishRating;
    private String Resturantname;

    public Resturant(Menuitem menu, String cityName, double dishRating, String Resturantname) {
        this.Resturantname = Resturantname;
        this.dishRating = dishRating;
        this.cityName = cityName;
    }

    public Resturant(String cityName, double dishRating, String Resturantname) {

        this.Resturantname = Resturantname;
        this.dishRating = dishRating;
        this.cityName = cityName;
    }

    public void setCityName(String cityName) {
        if (cityName == null || cityName.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.cityName = cityName;
        }
    }

    public String getCityName() {
        return cityName;
    }

    public void setDishRating(double dishRating) {
        this.dishRating = dishRating;
    }

    public double getDishRating() {
        return dishRating;
    }

    public void setMenu(Menuitem menu) {
        this.menu.add(menu);
    }

    public ArrayList<Menuitem> getMenu() {
        return menu;
    }

    public void setResturantname(String resturantname) {
        Resturantname = resturantname;
    }

    public String getResturantname() {
        return Resturantname;
    }

    public String toString() {
        return getResturantname() + "(" + getCityName() + ") Dish: " + menu.getName() + " price: "
                + menu.getPrice() + " Rating: "
                + getDishRating() + " Category: " + menu.getCategory();
    }
}