package com.drugstore;
import java.util.Scanner;
import com.drugstore.exeption.InsufficientMemoryException;

public class CreateDrugstore {
    public static Drugstore[] createDrugstores() throws InsufficientMemoryException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество аптек: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        try {
            Drugstore[] drugstores = new Drugstore[count];
            for (int i = 0; i < count; i++) {
                System.out.print("Введите фамилию владельца для аптеки " + (i + 1) + ": ");
                String ownerSurname = scanner.nextLine();

                System.out.print("Есть ли лицензия для аптеки " + (i + 1) + " (true/false): ");
                boolean hasLicense = scanner.nextBoolean();
                scanner.nextLine();

                System.out.print("Введите месячную прибыль для аптеки " + (i + 1) + ": ");
                double monthlyProfit = scanner.nextDouble();
                scanner.nextLine();

                drugstores[i] = new Drugstore(ownerSurname, hasLicense, monthlyProfit);
            }

            return drugstores;
        } catch (OutOfMemoryError e) {
            throw new InsufficientMemoryException("Ошибка: недостаточно памяти для создания массива объектов.");
        }
    }
}
