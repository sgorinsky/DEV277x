public class CheckBusiness {

  public static void main(String[] args) {

    TechnicalLead tlA = new TechnicalLead("tlA");
    BusinessLead blA = new BusinessLead("blA");

    Accountant sam = new Accountant("sam");
    Accountant john = new Accountant("john");
    Accountant suzy = new Accountant("suzy");
    Accountant michelle = new Accountant("michelle");

    blA.addReport(sam, tlA);
    blA.addReport(john, tlA);
    blA.addReport(suzy, tlA);
    blA.addReport(michelle, tlA);

    blA.setBonusBudget(50000);
    blA.requestBonus(sam, 5000);

    System.out.println(sam.getTeamSupported() + " and " + john.getTeamSupported()
      + " are the same manager is " + sam.getTeamSupported().Equals(john.getTeamSupported()));

    System.out.println(blA.getBonusBudget());
    blA.getBusinessTeamStatus();
  }
}
