
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
        Name n2 = new Name();
        System.out.print("1st way: \n\t");
        System.out.print(n1);// 1st Situation
        System.out.print("\nNow 2nd Way: \n\t" + "Hello " + n1);// 2nd situation(When perform operation on String +
                                                                // object)
        System.out.print("\n\t");
        System.out.print(n1.toString());// 3rd way
        System.out.println("\n");

        // now Methods for string
        String name = "Hanan QAIsAr, Its me ";
        String lower = name.toLowerCase();
        String upper = name.toUpperCase();
        char characterAt = name.charAt(3);
        int indexOf = name.toLowerCase().indexOf("it");// Case-Sensivity so, convert to lower then chack index
        String trimName = name.trim();// it can remmove spaces from beggning and ends
        boolean startsWith = name.startsWith("Han");// true bcz it look good
        boolean endsWith = name.endsWith("e");// return false bcz last is space

        System.out.println(lower);
        System.out.println(upper);
        System.out.println(characterAt);
        System.out.println(indexOf);
        System.out.println(trimName);
        System.out.println(endsWith);
        System.out.println(startsWith);
        System.out.println(endsWith);

        System.out.println("\nEquals Method in Student class: ");
        System.out.println(n1.equals(n2));// it will return false bcz in objects it judge on memory address
        System.out.println("\nEquals Method in College class: ");

        College Punjab1 = new College("PGC", 123);
        College Punjab2 = new College("PGC", 123);
        College Punjab3 = new College("PGC", 101);
        College Punjab4 = new College(null, 101);
        System.out.println(Punjab1.equals(Punjab2));// True
        System.out.println(Punjab1.equals(Punjab3));// False
        System.out.println(Punjab3.equals(Punjab3));// True
        System.out.println(Punjab3.equals(Punjab4));// False
    }
}

class Name {
    String name = "Hanan Qaisar";

    @Override
    public String toString() {
        return "Name: " + name + " Thanks for shopping";
    }
}

class College {
    public String clgName;
    public int clgcode;

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public void setClgcode(int clgcode) {
        this.clgcode = clgcode;
    }

    public College(String clgName, int clgcode) {
        this.clgName = clgName;
        this.clgcode = clgcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof College)) {
            return false;
        }
        College other = (College) obj;
        return this.clgcode == other.clgcode && (this.clgName == null ? other.clgName == null
                : this.clgName.equals(other.clgName));

        // 1. Focous on operator precedence

        // this.clgName == null ? other.clgName == null
        // : this.clgName.equals(other.clgName);

        // it mean if clgName is null then if condition run otherwise else condition run
        // and return boolean value
    }
}