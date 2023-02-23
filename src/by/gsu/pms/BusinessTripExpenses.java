package by.gsu.pms;

public class BusinessTripExpenses {
    // CLASS FIELDS
    private static final int RATE = 12;
    private String account;
    private float transport;
    private int days;


    // CONSTRUCTORS
    // Default constructor
    public BusinessTripExpenses(){
        account = "Example Employee Account";
        transport = 5.0f;
        days = 5;
    }

    // General-purpose constructor
    public BusinessTripExpenses(String account, float transport, int days)
    {
        this.account = account;
        this.transport = transport;
        this.days = days;
    }


    // METHODS
    // Getters and setters
    public String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account = account;
    }

    public float getTransport(){
        return transport;
    }
    public void setTransport(float transport){
        this.transport = transport;
    }

    public int getDays(){
        return days;
    }
    public void setDays(int days){
        this.days = days;
    }

    // Other methods
    public float getTotal(){
        return transport + RATE * days;
    }

    public void show(){
        System.out.format("Rate = %s\nAccount = %s\nTransport = %s\nDays = %s\nTotal = %s\n\n",
                          RATE, account, transport, days, getTotal());
    }

    public String toString(){
        return String.format("%s;%s;%s;%s;%s", RATE, account, transport, days, getTotal());
    }
}
