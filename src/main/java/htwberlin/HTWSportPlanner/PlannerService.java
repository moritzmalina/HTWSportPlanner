package htwberlin.HTWSportPlanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {
    @Autowired
    EntriesRepository repo;

    public PlannerEntries save(PlannerEntries entry){
        return repo.save(entry);
    }

    public PlannerEntries get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
