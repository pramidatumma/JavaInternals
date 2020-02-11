package internals;

import java.util.List;
import java.util.Map;

public class Person {
    public String name;

    public int age;

    @JsonIgnore
    private float salary;

    private int id;

    public Job job;

    public List<String> favBooks;
//
//    public Map<Integer, String> friends;

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }
}
