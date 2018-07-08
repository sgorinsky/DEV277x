public class BusinessEmployee extends Employee {

  private double BonusBudget;
  private double budget;

  public BusinessEmployee(String name) {
    super(name, 50000);
  }

  public double getBonusBudget() {

    return BonusBudget;

  }

  public void setBonusBudget(double bonus) {
    this.BonusBudget = bonus;
  }

  public void setBudget(double amount) {
    this.budget = amount;
  }

  public double getBudget() {
    return budget;
  }

  public String employeeStatus() {
    return super.employeeStatus() + " with a budget of " + BonusBudget;
  }
}
