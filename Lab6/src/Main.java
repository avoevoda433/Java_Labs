import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Чтение данных из файла
        List<Schedule> scheduleList = readSchedulesFromFile("input.txt");

        // Сортировка расписания по названию предмета
        Collections.sort(scheduleList);

        // Запись отсортированного расписания в файл
        writeSchedulesToFile("output.txt", scheduleList);
    }

    private static List<Schedule> readSchedulesFromFile(String filename) {
        List<Schedule> scheduleList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 7) {
                    String subject = parts[0];
                    String teacher = parts[1];
                    int course = Integer.parseInt(parts[2]);
                    int numLectures = Integer.parseInt(parts[3]);
                    int numPracticals = Integer.parseInt(parts[4]);
                    String dayOfWeek = parts[5];
                    String time = parts[6];

                    Schedule schedule = new Schedule(subject, teacher, course, numLectures, numPracticals, dayOfWeek, time);
                    scheduleList.add(schedule);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return scheduleList;
    }

    private static void writeSchedulesToFile(String filename, List<Schedule> scheduleList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Schedule schedule : scheduleList) {
                writer.write(schedule.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
