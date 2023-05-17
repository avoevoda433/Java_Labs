public class Main {
    public static void main(String[] args) {
        float all_profit = 0f;
        int no_license_count = 0;
        Drugstore[] drugstores = {new Drugstore(),
                new Drugstore("Воевода", true, 594.3f),
                new Drugstore("Чвалов", true, 425.4f),
                new Drugstore("Гореликов", false, 123.4f),
                null};
        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                all_profit += drugstore.getProfit();
                if (!drugstore.isLicense()) {
                    no_license_count++;
                }
            }
        }
        System.out.println("Общая прибыль: " + all_profit);
        System.out.println("Количество аптек без лицензии: " + no_license_count);
    }
}
