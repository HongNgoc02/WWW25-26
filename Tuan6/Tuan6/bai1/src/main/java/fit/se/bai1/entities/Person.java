package fit.se.bai1.entities;

import java.util.List;

public class Person {
    private int age;
    private String name;
    private List<Address> addresses;
    private List<String> emails;

    public Person() {
    }

    public Person(List<Address> addresses, int age, List<String> emails, String name) {
        this.addresses = addresses;
        this.age = age;
        this.emails = emails;
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "addresses=" + addresses +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", emails=" + emails +
                '}';
    }
}
