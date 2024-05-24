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
        PlannerEntries entry = new PlannerEntries("Kickboxen", "Ingo", "Montag", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry1 = new PlannerEntries("Badminton", "Farhan", "Dienstag", LocalTime.of(11, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry2 = new PlannerEntries("Cha Cha", "Adnan", "Freitag", LocalTime.of(19, 00), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry3 = new PlannerEntries("Karate", "Dominik", "Mittwoch", LocalTime.of(20, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntries entry4 = new PlannerEntries("Bouldern", "Moritz", "Donnerstag", LocalTime.of(13, 00), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        return List.of(entry, entry1, entry2, entry3, entry4);
    }

}