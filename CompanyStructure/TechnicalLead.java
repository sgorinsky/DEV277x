import java.util.*;

public class TechnicalLead extends TechnicalEmployee {

  private ArrayList<SoftwareEngineer> reportList = new ArrayList<SoftwareEngineer>();
  private double BaseSalary;
  private int headcount;
  private static int directReportCount = 0;

  //Should create a new TechnicalLead that is a Manager. The TechnicalLead's base salary should be 1.3 times
  //that of a TechnicalEmployee. TechnicalLeads should have a default head count of 4.
  public TechnicalLead(String name) {

    super(name);
    this.BaseSalary = 75000*1.3;
    this.headcount = 4;

  }


  //Should return true if the number of direct reports this manager has is less than their headcount.
  public boolean hasHeadCount() {

    if (this.directReportCount < this.headcount) {
      return true;
    } else {
      return false;
    }
  }

  /* public void setsManager(SoftwareEngineer e) {
  //  super.setManager(e);
  } */

  //Should accept the reference to a SoftwareEngineer object, and if the TechnicalLead has head count left
  //should add this employee to their list of direct reports. If the employee is successfully added to the
  //TechnicalLead's direct reports true should be returned, false should be returned otherwise

  public boolean addReport(SoftwareEngineer e) {

    if (this.hasHeadCount()) {

      reportList.add(e); //adds to ArrayList<SoftwareEngineer> field
      e.setManager(this); //sets manager from employee class for each SoftwareEngineer reporting to TechnicalLead
      directReportCount++;
      return true;

    } else {
      return false;
    }

  }


  //Should see if the employee passed in does report to this manager and if their code access is
  //currently set to "true". If both those things are true, true is returned, otherwise false is returned
  public boolean approveCheckIn(SoftwareEngineer e) {
    //changes codeAccess field in TechnicalEmployee class; this method only works for TechnicalLead object instances

    e.setCodeAccess(this.Equals(e.getManager()) && e.getCodeAccess() == true);

    return e.getCodeAccess();

  }


  //Should check if the bonus amount requested would be approved by the BusinessLead supporting this
  //TechnicalLead. If it is, that employee should get that bonus and true should be returned.
  //False should be returned otherwise

  public boolean requestBonus(Accountant e, double bonus) {
    //approve is from businessLead supporting TechnicalLead?
    if (e.approveBonus(bonus)) {

      e.setSalary(e.getSalary() + bonus);
      return true;

    } else {
      return false;
    }

  }


  /* Should return a String that gives insight into this Manager and all their direct reports.
  It should return a string that is a combination of the TechnicalLead's employee status followed
  by each of their direct employee's status on subsequent lines. If the TechnicalLead has no reports it
  should print their employee status followed by the text " and no direct reports yet ".
  Example: "10 Kasey has 5 successful check ins and no direct reports yet".
  If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins
  and is managing: /n 5 Niky has 2 successful check ins" */

  public void getTeamStatus() {

    System.out.print(this.getName() + " has ");
    if (directReportCount == 0) {
      System.out.print("no direct reports yet.");

    } else {
      System.out.print(directReportCount + " engineers reporting and is managing: ");
      for (int i = 0; i < reportList.size(); i++) {
        System.out.print(reportList.get(i).employeeStatus() + " ");
      }
    }
    System.out.println("");

  }


}
