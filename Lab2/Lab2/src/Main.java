import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Disk disk = new Disk();

        // Создаем несколько песен и добавляем их на диск
        Song song1 = new Song("Song 1", "Artist 1", 180, "Pop");
        Song song2 = new Song("Song 2", "Artist 2", 240, "Rock");
        Song song3 = new Song("Song 3", "Artist 3", 200, "Pop");
        Song song4 = new Song("Song 4", "Artist 4", 300, "Hip Hop");

        disk.addComposition(song1);
        disk.addComposition(song2);
        disk.addComposition(song3);
        disk.addComposition(song4);

        int choice;
        do {
            System.out.println("=== Меню ===");
            System.out.println("1. Добавить композицию на диск");
            System.out.println("2. Вывести список композиций на диск");
            System.out.println("3. Переставить композиции по стилю");
            System.out.println("4. Найти композицию по диапазону длительности");
            System.out.println("5. Подсчитать общую продолжительность композиций на диске");
            System.out.println("0. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Считываем символ новой строки
                    System.out.print("Введите название композиции: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите исполнителя: ");
                    String artist = scanner.nextLine();
                    System.out.print("Введите длительность (в секундах): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки

                    System.out.print("Введите стиль композиции: ");
                    String style = scanner.nextLine();

                    MusicComposition composition = new Song(title, artist, duration, style);
                    disk.addComposition(composition);

                    System.out.println("Композиция успешно добавлена на диск.");
                    break;
                case 2:
                    System.out.println("Список композиций на диске:");
                    disk.printCompositions();
                    break;
                case 3:
                    scanner.nextLine(); // Считываем символ новой строки
                    System.out.print("Введите стиль для перестановки: ");
                    String targetStyle = scanner.nextLine();
                    disk.rearrangeCompositionsByStyle(targetStyle);
                    System.out.println("Композиции на диске переставлены по стилю " + targetStyle);
                    break;
                case 4:
                    System.out.print("Введите минимальную длительность (в секундах): ");
                    int minDuration = scanner.nextInt();
                    System.out.print("Введите максимальную длительность (в секундах): ");
                    int maxDuration = scanner.nextInt();
                    scanner.nextLine(); // Считываем символ новой строки

                    MusicComposition foundComposition = disk.findCompositionByDurationRange(minDuration, maxDuration);
                    if (foundComposition != null) {
                        System.out.println("Найденная композиция:");
                        WriterInfo.printInfo(foundComposition);
                    } else {
                        System.out.println("Композиция в заданном диапазоне длительности не найдена.");
                    }
                    break;
                case 5:
                    int totalDuration = disk.getTotalDuration();
                    System.out.println("Общая продолжительность композиций на диске: " + totalDuration + " секунд");
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}

