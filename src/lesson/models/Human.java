package lesson.models;

public class Human {

    int id;
    int age;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human() {
    }

    public Human(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
