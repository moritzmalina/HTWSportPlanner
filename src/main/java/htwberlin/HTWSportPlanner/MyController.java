package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// :)

@RestController
//@CrossOrigin(origins = "https://htwsportplannerfrontend.onrender.com/")
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
        return service.get(entryId);}

    @DeleteMapping("/entries/{id}")
    public void deleteEntry(@PathVariable String id) {
        Long entryId = Long.parseLong(id);
        service.delete(entryId);
    }
}