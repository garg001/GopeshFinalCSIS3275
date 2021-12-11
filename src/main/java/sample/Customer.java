package sample;

public class Customer {
    private String custname,custno,savtype;
    private Double cdep;
    private int nyears;

    public Customer(String custno, String custname,  Double cdep, int nyears,String savtype) {
        this.custname = custname;
        this.custno = custno;
        this.savtype = savtype;
        this.cdep = cdep;
        this.nyears = nyears;
    }

    public Customer() {
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public String getSavtype() {
        return savtype;
    }

    public void setSavtype(String savtype) {
        this.savtype = savtype;
    }

    public Double getCdep() {
        return cdep;
    }

    public void setCdep(Double cdep) {
        this.cdep = cdep;
    }

    public int getNyears() {
        return nyears;
    }

    public void setNyears(int nyears) {
        this.nyears = nyears;
    }
}
