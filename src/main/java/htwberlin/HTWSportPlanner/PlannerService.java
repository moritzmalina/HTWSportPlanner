package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlannerService {
    @Autowired
    EntriesRepository repo;

    public PlannerEntry save(PlannerEntry entry){
        return repo.save(entry);
    }

    public List<PlannerEntry> getAll() {return (List<PlannerEntry>) repo.findAll();}

    public PlannerEntry get(Long id){
        return repo.findById(id).orElseThrow(RuntimeException::new);}

    public void delete(Long id) {repo.deleteById(id);
    }

    public PlannerEntry update(Long id, PlannerEntry updatedEntry) {
        Optional<PlannerEntry> optionalEntry = repo.findById(id);
        if (optionalEntry.isPresent()) {
            PlannerEntry existingEntry = optionalEntry.get();
            existingEntry.setCourseName(updatedEntry.getCourseName());
            existingEntry.setWeekDay(updatedEntry.getWeekDay());
            existingEntry.setPlace(updatedEntry.getPlace());
            existingEntry.setCourseTime(updatedEntry.getCourseTime());
            existingEntry.setStartDate(updatedEntry.getStartDate());
            existingEntry.setEndDate(updatedEntry.getEndDate());
            existingEntry.setManagement(updatedEntry.getManagement());
            existingEntry.setSelected(updatedEntry.getSelected());
            return repo.save(existingEntry);
        } else {
            throw new RuntimeException("Entry not found with id " + id);
        }
    }
}
