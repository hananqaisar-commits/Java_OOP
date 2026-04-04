package University_Staff_Management;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Invalid");
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("Name: %s | Age: %2d", getName());
    }
}
