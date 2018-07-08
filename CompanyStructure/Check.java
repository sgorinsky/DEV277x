// Employee Check
import java.util.*;

public class Check {

  public static void main(String[] args) {

    Employee Sam = new Employee("Sam", 20000);
    Employee Alex = new Employee("Alex", 30000);
    System.out.println(Sam.employeeStatus());
    System.out.println(Alex.employeeStatus());
    System.out.println(Sam.Equals(Alex));

    Employee Jack = new TechnicalEmployee("Jack");
    Employee David = new TechnicalEmployee("David");
    System.out.println(Jack.employeeStatus());
    System.out.println(David.employeeStatus());
    System.out.println(Jack.Equals(David));

    SoftwareEngineer John = new SoftwareEngineer("John");
    SoftwareEngineer Kerry = new SoftwareEngineer("Kerry");

    TechnicalLead Ellie = new TechnicalLead("Ellie");
    TechnicalEmployee Mariana = new TechnicalLead("Mariana");

    //when TechnicalLead adds a report, this is made manager
    Ellie.addReport(John);
    Ellie.addReport(Kerry);

    //John and Kerry are checking in code: John 2; Kerry 1
    John.checkInCode();
    John.checkInCode();
    Kerry.checkInCode();

    System.out.println(Ellie.hasHeadCount());
    System.out.println(Ellie.employeeStatus());
    Ellie.getTeamStatus();

    System.out.println(John.getManager().getName()); //Ellie is John's manager
    System.out.println(Ellie.approveCheckIn(John)); //if Ellie.isEqual(John) == true && codeAccess == true, approves
  }
}
