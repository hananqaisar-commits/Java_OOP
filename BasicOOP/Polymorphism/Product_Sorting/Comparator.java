package Product_Sorting;

import java.util.Comparator;

class sortByPrice implements Comparator<Product> {

    @Override
    public int compare(Product t, Product other) {
        int result = Double.compare(other.getPrice(), t.getPrice());
        return result;
    }

}

class sortByRating implements Comparator<Product> {

    @Override
    public int compare(Product t, Product other) {
        int result = Double.compare(other.getCount_rating(), t.getCount_rating());
        return result;
    }

}

class sortByAlphabets implements Comparator<Product> {

    @Override
    public int compare(Product t, Product other) {
        int result = t.getName().compareToIgnoreCase(other.getName());
        return result;
    }

}
