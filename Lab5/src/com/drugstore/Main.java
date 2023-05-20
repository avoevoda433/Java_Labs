package com.drugstore;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Drugstore[] drugstores = CreateDrugstore.createDrugstores();

            // Сохранение созданных объектов в файл
            saveDrugstoresToFile(drugstores, "drugstores.dat");

            // Чтение объектов из файла
            Drugstore[] loadedDrugstores = loadDrugstoresFromFile("drugstores.dat");

            // Вывод информации о загруженных объектах
            for (Drugstore drugstore : loadedDrugstores) {
                System.out.println(drugstore);
            }

            // Подсчет общей прибыли и количества аптек без лицензии
            double totalProfit = 0;
            int unlicensedCount = 0;
            for (Drugstore drugstore : loadedDrugstores) {
                totalProfit += drugstore.getMonthlyProfit();
                if (!drugstore.hasLicense()) {
                    unlicensedCount++;
                }
            }

            System.out.println("Общая прибыль: " + totalProfit);
            System.out.println("Количество аптек без лицензии: " + unlicensedCount);
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static void saveDrugstoresToFile(Drugstore[] drugstores, String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(drugstores);
            System.out.println("Объекты успешно сохранены в файл " + fileName);
        }
    }

    private static Drugstore[] loadDrugstoresFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Drugstore[]) inputStream.readObject();
        }
    }
}
