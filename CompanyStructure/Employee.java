import java.util.*;

public class Employee {

  private static int count = 0;
  private int id;
  private double BaseSalary;
  private String Name;
  private Employee Manager;


  public Employee(String name, double baseSalary) {
    count += 1;
    this.id = count;
    this.Name = name;
    this.BaseSalary = baseSalary;

  }



  public String getName() {
    return Name;
  }

  public int getID() {
    return id;
  }

  public void setManager(Employee e) { //needs to be able to set a manager to apporve check-ins
    Manager = e;
  }

  public Employee getManager() {
    return Manager;

  }

  public void setSalary(double amount) {
    BaseSalary = amount;
  }

  public double getSalary() {
    return BaseSalary;
  }

  public boolean Equals(Employee other) {
    if (this.id == other.id) {
      return true;
    } else {
      return false;
    }
  }

  public String toString() {
    return this.id + " " + this.Name + " makes " + this.BaseSalary;
  }

  public String employeeStatus() {
    return this.toString();
  }





}
