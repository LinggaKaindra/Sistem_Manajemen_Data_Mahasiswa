package model;

public class Person {
    protected String name; // menggunakan protected agar bisa diakses langsung oleh subclass
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Umur: " + age);
    }

    // Getter dan Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}