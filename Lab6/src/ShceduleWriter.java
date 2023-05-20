import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class ScheduleWriter {
    private String filename;

    public ScheduleWriter(String filename) {
        this.filename = filename;
    }

    public void writeSchedules(List<Schedule> schedules) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Schedule schedule : schedules) {
                writer.write(schedule.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}