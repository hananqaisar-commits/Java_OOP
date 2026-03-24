
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
    }
}

class Name {
    String name = "Hanan Qaisar";

    @Override
    public String toString() {
        return "Name: " + name + " Thanks for shopping";
    }
}