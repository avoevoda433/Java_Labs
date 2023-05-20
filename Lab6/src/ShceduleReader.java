import java.io.*;
import java.util.ArrayList;
import java.util.List;

class ScheduleReader {
    private String filename;

    public ScheduleReader(String filename) {
        this.filename = filename;
    }

    public List<Schedule> readSchedules() {
        List<Schedule> schedules = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 7) {
                    String subject = parts[0];
                    String teacher = parts[1];
                    int course = Integer.parseInt(parts[2]);
                    int lectureCount = Integer.parseInt(parts[3]);
                    int practiceCount = Integer.parseInt(parts[4]);
                    String dayOfWeek = parts[5];
                    String time = parts[6];

                    Schedule schedule = new Schedule(subject, teacher, course, lectureCount, practiceCount,
                            dayOfWeek, time);
                    schedules.add(schedule);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return schedules;
    }
}