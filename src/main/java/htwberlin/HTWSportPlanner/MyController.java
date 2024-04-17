package htwberlin.HTWSportPlanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

// :)

@RestController
public class MyController {

    @GetMapping("/entries")
    public List<PlannerEntries> greeting() {
        PlannerEntries entry = new PlannerEntries("Test", "Test", "Monday", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry1 = new PlannerEntries("Test", "Test", "Monday", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry2 = new PlannerEntries("Test", "Test", "Monday", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry3 = new PlannerEntries("Test", "Test", "Monday", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry4 = new PlannerEntries("Test", "Test", "Monday", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        return List.of(entry, entry1, entry2, entry3, entry4);
    }

}