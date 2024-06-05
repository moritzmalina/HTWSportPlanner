package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// :)

@RestController
@CrossOrigin(origins = "https://htwsportplannerfrontend.onrender.com/")
public class MyController {

    @Autowired
    PlannerService service;

    @PostMapping("/entries")
    public PlannerEntry createEntry(@RequestBody PlannerEntry entry) {
        return service.save(entry);
    }

    @GetMapping("entries/{id}")
    public PlannerEntry getEntry(@PathVariable String id){
        Long entryId = Long.parseLong(id);
        return service.get(entryId);
    }

    /*
    @GetMapping("/entries")
    public List<PlannerEntry> greeting() {
        PlannerEntry entry = new PlannerEntry(1L, "Kickboxen", "Ingo", "Treskowallee","Montag", LocalTime.of(15, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntry entry1 = new PlannerEntry(2L, "Badminton", "Farhan", "Treskowallee","Dienstag",  LocalTime.of(11, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntry entry2 = new PlannerEntry(3L, "Cha Cha", "Adnan", "Treskowallee","Freitag", LocalTime.of(19, 00), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntry entry3 = new PlannerEntry(4L, "Karate", "Dominik", "Treskowallee","Mittwoch", LocalTime.of(20, 30), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        PlannerEntry entry4 = new PlannerEntry(5L, "Bouldern", "Moritz", "Treskowallee","Donnerstag", LocalTime.of(13, 00), LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 1));
        return List.of(entry, entry1, entry2, entry3, entry4);
    }
*/
}