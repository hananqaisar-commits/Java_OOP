import java.util.ArrayList;

public class StringList {
    public static void main(String[] args) {

        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("Hanan Qaisar");
        arraylist.add("Waqar Younis");
        arraylist.add("AHTISHAM");
        arraylist.add("AHMAD");
        System.out.println(arraylist);

        arraylist.replaceAll(name -> name.toLowerCase());
        System.out.println(arraylist);

        // remove names less then 6 alphabets
        arraylist.removeIf(name -> name.length() < 6);
        System.out.println(arraylist);

        // print name if it start with alphabet H only and print in uppercase
        for (String string : arraylist) {
            if (string.startsWith("H")) {
                System.out.println(string.toUpperCase());
            }
        }

    }
}
