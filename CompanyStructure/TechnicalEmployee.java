public class TechnicalEmployee extends Employee {

  public int checkIn = 0;


  public TechnicalEmployee(String name) {
    super(name, 75000);

  }

  public String employeeStatus() {

    return super.employeeStatus() + " and has " + checkIn + " successful check in(s).";
    
  }

}
