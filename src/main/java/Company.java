
public class Company {

    private String nameC;
    private double totalYears;

    public Company(String nameC, double totalYears) {
        this.nameC = nameC;
        this.totalYears = totalYears;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public double getTotalYears() {
        return totalYears;
    }

    public void setTotalYears(double totalYears) {
        this.totalYears = totalYears;
    }
}
