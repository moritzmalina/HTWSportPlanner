package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {
    @Autowired
    EntriesRepository repo;

    public PlannerEntry save(PlannerEntry entry){
        return repo.save(entry);
    }

    public PlannerEntry get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void delete(Long id) {repo.deleteById(id);
    }
}
