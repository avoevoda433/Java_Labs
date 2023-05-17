public class Drugstore {
    private String owner_name;
    private boolean license;
    private float profit;

    public Drugstore(){
        owner_name = "unknown";
        license = false;
        profit = 0f;
    }

    public Drugstore(String owner_name, boolean license, float profit) {
        this.owner_name = owner_name;
        this.license = license;
        this.profit = profit;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }
}
