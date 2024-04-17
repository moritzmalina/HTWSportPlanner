package htwberlin.HTWSportPlanner;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class PlannerEntries {
    private String courseName;
    private String description;
    private String weekDay;
    private Time courseTime;
    private LocalDate startDate;
    private LocalDate endDate;

    public PlannerEntries(String courseName, String description, String weekDay, Time courseTime, LocalDate startDate, LocalDate endDate) {
        this.courseName = courseName;
        this.description = description;
        this.weekDay = weekDay;
        this.courseTime = courseTime;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDescription() {
        return description;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public Time getCourseTime() {
        return courseTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

