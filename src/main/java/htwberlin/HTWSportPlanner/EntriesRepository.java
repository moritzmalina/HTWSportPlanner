package htwberlin.HTWSportPlanner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EntriesRepository extends CrudRepository<PlannerEntry, Long> {
    boolean existsByCourseNameAndWeekDay(String courseName, String weekDay);
}
