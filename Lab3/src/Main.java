import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Drugstore[] drugstores = new Drugstore[10];
        int totalProfit = 0;
        int pharmaciesWithoutLicense = 0;

//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < drugstores.length; i++) {
//            System.out.println("Введите данные для аптеки " + (i + 1));
//            System.out.print("Фамилия владельца: ");
//            String ownerSurname = scanner.nextLine();
//            System.out.print("Наличие лицензии (true/false): ");
//            boolean hasLicense = scanner.nextBoolean();
//            System.out.print("Месячная прибыль: ");
//            int monthlyProfit = scanner.nextInt();
//            scanner.nextLine(); // Чтение символа новой строки после ввода числа
//
//            drugstores[i] = new Drugstore(ownerSurname, hasLicense, monthlyProfit);
//        }
        drugstores[0] = new Drugstore();  // Объект созданный конструктором по умолчанию
        drugstores[1] = new Drugstore("Smith", true, 5000);
        drugstores[2] = new Drugstore("Chvalov", true, 5400);
        drugstores[3] = new Drugstore("Johnson", false, 3000);
        drugstores[4] = new Drugstore("Williams", true, 4000);
        drugstores[5] = new Drugstore("Brown", true, 2000);
        drugstores[6] = new Drugstore("Jones", false, 1000);
        drugstores[7] = new Drugstore("Voevoda", false, 1400);;
        drugstores[8] = new Drugstore("Davis", true, 6000);
        drugstores[9] = new Drugstore("Taylor", false, 1500);

        // Сериализация объектов в файл
        DrugstoreSerializationUtil.serialize(drugstores, "data/drugstore.ser");

        // Сортировка массива по возрастанию
        Arrays.sort(drugstores, Comparator.comparing(Drugstore::getOwnerSurname)
                .thenComparingInt(Drugstore::getMonthlyProfit));

        // Десериализация объектов из файла
        Drugstore[] deserializedDrugstores = DrugstoreSerializationUtil.deserialize("data/drugstore.ser");
        if (deserializedDrugstores != null) {
            // Вывод десериализованных объектов
            for (Drugstore drugstore : deserializedDrugstores) {
                System.out.println(drugstore);
            }
        }

        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                totalProfit += drugstore.getMonthlyProfit();
                if (!drugstore.hasLicense()) {
                    pharmaciesWithoutLicense++;
                }
            }
        }

        System.out.println("Общая прибыль: " + totalProfit);
        System.out.println("Количество аптек без лицензии: " + pharmaciesWithoutLicense);
    }
}
