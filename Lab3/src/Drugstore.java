import java.io.Serializable;

class Drugstore implements Serializable {
    private String ownerSurname;
    private boolean hasLicense;
    private int monthlyProfit;

    public Drugstore() {
        this.ownerSurname = "unknown";
        this.hasLicense = false;
        this.monthlyProfit = 0;
    }

    public Drugstore(String ownerSurname, boolean hasLicense, int monthlyProfit) {
        this.ownerSurname = ownerSurname;
        this.hasLicense = hasLicense;
        this.monthlyProfit = monthlyProfit;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public boolean hasLicense() {
        return hasLicense;
    }

    public int getMonthlyProfit() {
        return monthlyProfit;
    }

    @Override
    public String toString() {
        return "Drugstore{" +
                "ownerSurname='" + ownerSurname + '\'' +
                ", hasLicense=" + hasLicense +
                ", monthlyProfit=" + monthlyProfit +
                '}';
    }
}