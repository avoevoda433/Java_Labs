import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Schedule implements Comparable<Schedule> {
    private String subject;
    private String teacher;
    private int course;
    private int lectureCount;
    private int practiceCount;
    private String dayOfWeek;
    private String time;

    public Schedule(String subject, String teacher, int course, int lectureCount, int practiceCount,
                    String dayOfWeek, String time) {
        this.subject = subject;
        this.teacher = teacher;
        this.course = course;
        this.lectureCount = lectureCount;
        this.practiceCount = practiceCount;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }

    // Геттеры и сеттеры

    @Override
    public String toString() {
        return subject + " " + teacher + " " + course + " " + lectureCount + " " + practiceCount
                + " " + dayOfWeek + " " + time;
    }

    @Override
    public int compareTo(Schedule other) {
        return subject.compareTo(other.getSubject());
    }

    private String getSubject() {
        return subject;
    }
}
