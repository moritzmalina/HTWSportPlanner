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
}
