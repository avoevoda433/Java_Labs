import by.gsu.pms.BusinessTripExpenses;

public class Runner {
    public static void main(String[] args) {

        float expensesSum = 0;
        float maxExpenses = 0.0f;
        String employeeAccount = "";
        BusinessTripExpenses[] employeeBusinessTrips = new BusinessTripExpenses[]
                {new BusinessTripExpenses("Voevoda Alexey", 10.0f, 10),
                 new BusinessTripExpenses("Chvalov Kastus", 7.0f, 6),
                 null,
                 new BusinessTripExpenses("Gorelikov Eduard", 15.5f, 4),
                 new BusinessTripExpenses("Gerasenko Nikolay", 5.6f, 18),
                 new BusinessTripExpenses("Mihalchenko Nikita", 8.9f, 3),
                 new BusinessTripExpenses()};

        for (BusinessTripExpenses trip : employeeBusinessTrips){
            if (trip == null) continue;
            trip.show();
        }

        int duration = employeeBusinessTrips[0].getDays() + employeeBusinessTrips[1].getDays();
        System.out.printf("Duration = %s\n\n", duration);

        for (BusinessTripExpenses trip : employeeBusinessTrips){
            if (trip == null) continue;
            System.out.println(trip.toString());
        }

        for (BusinessTripExpenses trip : employeeBusinessTrips){
            if (trip == null) continue;
            expensesSum += trip.getTotal();
        }
        System.out.printf("\nTotal expenses: %s\n", expensesSum);

        for (BusinessTripExpenses trip : employeeBusinessTrips){
            if (trip == null) continue;
            else {
                if (trip.getTotal() > maxExpenses){
                    maxExpenses = trip.getTotal();
                    employeeAccount = trip.getAccount();
                }
            }
        }
        System.out.println(employeeAccount);
    }
}
