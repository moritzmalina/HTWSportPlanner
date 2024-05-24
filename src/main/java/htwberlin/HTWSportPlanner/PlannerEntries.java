package htwberlin.HTWSportPlanner;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class PlannerEntries {
    private String courseName;
    private String management;
    private String weekDay;
    private LocalTime courseTime;
    private LocalDate startDate;
    private LocalDate endDate;

    public PlannerEntries(String courseName, String management, String weekDay, LocalTime courseTime, LocalDate startDate, LocalDate endDate) {
        this.courseName = courseName;
        this.management = management;
        this.weekDay = weekDay;
        this.courseTime = courseTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getManagement() {
        return management;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public LocalTime getCourseTime() {
        return courseTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

