public class RationalNumber {
    private int num;
    private int den; // den != 0


    public RationalNumber(int n, int d) {
        num = n;
        den = d;
    }

    /** Multiplies this RationalNumber by r.
    *  @param r a RationalNumber object
    *  Precondition: this.den() != 0
    */
    public RationalNumber multiply(RationalNumber r) {
      /* num = num * r.num;
       * den = den * r.den; // works */

      /* this.num = this.num * r.num;
       * this.den = this.den * r.den; //works */

       num = num * r.getNum();
       den = den * r.getDen(); //works also

      return this;
    }

    /** @return the numerator
    */
    public int getNum() {
        return this.num;/* implementation not shown */
    }

    /** @return the denominator
    */
    public int getDen() {
        return this.den;/* implementation not shown */
    }

    public String toString() {
      return this.num + "/" + this.den;
    }
}
