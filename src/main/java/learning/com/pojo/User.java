package learning.com.pojo;

import lombok.Data;

import java.util.Objects;

/**
 * Create by HuQiuYue on 2019-11-13
 */
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private double salary;

    public User(){}

    public User(Long id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if(getClass() != o.getClass()) return  false;
        User user = (User) o;
        if(id != user.getId()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "User [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ']';
    }
}
