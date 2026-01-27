package com.son.learn.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, message = "Tên phải có ít nhất 5 ký tự")
    @Column(nullable = false)
    private String name;

    @Min(value = 100, message = "Lương tối thiểu là 100")
    private double salary;

    @Email(message = "Email phải đúng định dạng")
    private String email;

    private String gender;
    private String department;

    @ElementCollection
    @CollectionTable(
            name = "employee_skills",
            joinColumns = @JoinColumn(name = "employee_id")
    )
    @Column(name = "skill")
    private List<String> skills;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Employee() {

    }

    public Employee(int id, String name, double salary, String gender, String department, List<String> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.skills = skills;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", skills=" + skills +
                '}';
    }
}
