package calc;

class Calculator {
    enum operations {
        Add, subtract, multiply, divide, modulus
    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);

        Operations add = (x, y) -> x + y;
        System.out.println(add);

        Operations sub = (a, b) -> a - b;
        System.out.println(sub);

        Operations multiply = (int q, int w) -> q * w;
        System.out.println(multiply);

        Operations divide = (int a, int b) -> a / b;
        System.out.println(divide);

        Operations mod = (a, b) -> a % b;
        System.out.println(mod);
    }
}