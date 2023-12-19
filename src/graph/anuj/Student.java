package graph.anuj;

import java.util.Objects;

public class Student {
    int id;
    String name;
    String city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;


    }
}
