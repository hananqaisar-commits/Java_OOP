
public class toString {
    public static void main(String[] args) {
        System.out.println("==========Welcome===========");
        // toString() is called automatically when an object needs to be converted into
        // a String.
        // Situation toString() called?
        // System.out.println(object) ✅ Yes
        // "Text " + object ✅ Yes
        // Direct call ✅ Yes
        // Just creating object ❌ No

        Name n1 = new Name();
        System.out.print("!st way: \n\t");
        System.out.print(n1);// 1st Situation
        System.out.print("Now 2nd Way: \n\t" + n1);// 2nd situation
        System.out.print("\n\t");
        System.out.print(n1.toString());// 3rd waay
        System.out.println("\n");

        // now Methods for string
        String name = "Hanan QAIsAr, Its me ";
        String lower = name.toLowerCase();
        String upper = name.toUpperCase();
        char characterAt = name.charAt(3);
        int indexOf = name.indexOf("it");
        String trimName = name.trim();// it can remmove spaces from beggning and ends
        boolean startsWith = name.startsWith("Han");// true bcz it look good
        boolean endsWith = name.startsWith("e");// return false bcz last is space

        System.out.println(lower);
        System.out.println(upper);
        System.out.println(characterAt);
        System.out.println(indexOf);
        System.out.println(trimName);
        System.out.println(endsWith);
        System.out.println(startsWith);
        System.out.println(endsWith);

    }
}

class Name {
    String name = "Hanan Qaisar";

    @Override
    public String toString() {
        return "Name: " + name + " Thanks for shopping";
    }
}