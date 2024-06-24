package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        PlannerEntry existingEntry = repo.findById(id).orElse(null);
        if (existingEntry != null) {
            if (updatedEntry.getCourseName() != null) {
                existingEntry.setCourseName(updatedEntry.getCourseName());
            }
            if (updatedEntry.getWeekDay() != null) {
                existingEntry.setWeekDay(updatedEntry.getWeekDay());
            }
            if (updatedEntry.getPlace() != null) {
                existingEntry.setPlace(updatedEntry.getPlace());
            }
            if (updatedEntry.getCourseTime() != null) {
                existingEntry.setCourseTime(updatedEntry.getCourseTime());
            }
            if (updatedEntry.getStartDate() != null) {
                existingEntry.setStartDate(updatedEntry.getStartDate());
            }
            if (updatedEntry.getEndDate() != null) {
                existingEntry.setEndDate(updatedEntry.getEndDate());
            }
            if (updatedEntry.getManagement() != null) {
                existingEntry.setManagement(updatedEntry.getManagement());
            }
            if (updatedEntry.getSelected() != null) {
                existingEntry.setSelected(updatedEntry.getSelected());
            }
            if (updatedEntry.getColor() != null) {
                existingEntry.setColor(updatedEntry.getColor());
            }
            if (updatedEntry.getDescription() != null) {
                existingEntry.setDescription(updatedEntry.getDescription());
            }
            return repo.save(existingEntry);
        } else {
            throw new RuntimeException("Entry not found with id " + id);
        }
    }
}
