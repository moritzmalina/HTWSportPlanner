package htwberlin.HTWSportPlanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class HtwSportPlannerApplicationTests {

@Autowired
    private PlannerService service;

@MockBean
    private EntriesRepository repository;

@BeforeEach
    void setUpMockRepository(){
    final PlannerEntry badminton = new PlannerEntry(1L,"Badminton","Test","Test","Mo", LocalTime.of(10, 0), LocalDate.of(2024, 8, 20),LocalDate.of(2024, 9, 20),true,true,"Test");
    final PlannerEntry kickboxen = new PlannerEntry(2L,"Kickboxen","Test","Test","Mo", LocalTime.of(10, 0), LocalDate.of(2024, 8, 20),LocalDate.of(2024, 9, 20),true,true,"Test");

    when(repository.findById(1L)).thenReturn(Optional.of(badminton));
    when(repository.findById(2L)).thenReturn(Optional.of(kickboxen));
}
/*
    @Test
    void getAllRecords() throws Exception {}

 */
}
