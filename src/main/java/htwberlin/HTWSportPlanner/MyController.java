package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// :)

@RestController
@RequestMapping("/")
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

    @GetMapping("/entries")
    public List<PlannerEntry> getAllEntries() {
        return service.getAll();
    }

    @PatchMapping("/entries/{id}")
    public PlannerEntry updateEntry(@PathVariable Long id, @RequestBody PlannerEntry updatedEntry) {
        return service.update(id, updatedEntry);
    }
}