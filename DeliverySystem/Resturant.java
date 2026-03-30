import java.util.ArrayList;

class Resturant {
    ArrayList<Menuitem> menu = new ArrayList<>();
    private String cityName;
    private double dishRating;
    private String Resturantname;

    public Resturant() {

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

    @Override
    public String toString() {
        String result = "";
        for (Menuitem menuitem : menu) {
            result += getResturantname() + "(" + getCityName() + ") Dish: ";
            result += menuitem.getName() + " price: "// += bcz string is immutable a new string is returned in result
                    + menuitem.getPrice() + " Rating: "
                    + getDishRating() + " Category: " + menuitem.getCategory() + "\n";
        }
        return result;
    }
}