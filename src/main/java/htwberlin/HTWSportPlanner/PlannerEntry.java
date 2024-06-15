package htwberlin.HTWSportPlanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class PlannerEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String management;
    private String place;
    private String weekDay;
    private LocalTime courseTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean selected;
    public PlannerEntry(){}


    public PlannerEntry(Long id, String courseName, String management, String place, String weekDay, LocalTime courseTime, LocalDate startDate, LocalDate endDate, Boolean selected) {
        this.id = id;
        this.courseName = courseName;
        this.management = management;
        this.place = place;
        this.weekDay = weekDay;
        this.courseTime = courseTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.selected = selected;
    }

    public Long getId() {
        return id;
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

    public String getPlace() {
        return place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getSelected(){ return selected;}

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setManagement(String management) {
        this.management = management;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public void setCourseTime(LocalTime courseTime) {
        this.courseTime = courseTime;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}

