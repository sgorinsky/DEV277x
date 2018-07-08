public class SoftwareEngineer extends TechnicalEmployee {

  boolean codeAccess = true; //all software engineers begin with codeAccess unless it's revoked


  public SoftwareEngineer(String name) {

    super(name);

  }

  //Should return whether or not this SoftwareEngineer has access to make changes to the code base
  public boolean getCodeAccess() 	{
    return codeAccess;
  }

  //Should allow an external piece of code to update the SoftwareEngineer's code privileges to either true or false
  public void setCodeAccess(boolean access) {
    this.codeAccess = access;
  }

  //Should return the current count of how many times this SoftwareEngineer has successfully checked in code
  public int getSuccessfulCheckIns()  {

    return checkIn;

  }



  /*Should check if this SoftwareEngineer's manager approves of their check in.
  If the check in is approved their successful checkin count should be increased
  and the method should return "true". If the manager does not approve the check in the SoftwareEngineer's
  code access should be changed to false and the method should return "false" */

  public boolean checkInCode() {

    //does Manager.approveCheckIn()?
    if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {


      checkIn++;
      return true;

    } else {
      this.setCodeAccess(false);
      return false;
    }

  }





}
