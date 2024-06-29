package htwberlin.HTWSportPlanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private PlannerService service;

    @InjectMocks
    private MyController controller;

    PlannerEntry badminton = new PlannerEntry(1L,"Badminton","Test","Test","Mo", LocalTime.of(10, 0), LocalDate.of(2024, 8, 20),LocalDate.of(2024, 9, 20),true,true,"Test");
    PlannerEntry kickboxen = new PlannerEntry(2L,"Kickboxen","Test","Test","Mo", LocalTime.of(10, 0), LocalDate.of(2024, 8, 20),LocalDate.of(2024, 9, 20),true,true,"Test");

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getAllRecords() throws Exception {
        List<PlannerEntry> records = new ArrayList<>(Arrays.asList(badminton, kickboxen));

        Mockito.when(service.getAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllRecordsSize() throws Exception {
        List<PlannerEntry> records = new ArrayList<>(Arrays.asList(badminton, kickboxen));

        Mockito.when(service.getAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getAllRecordsName() throws Exception {
        List<PlannerEntry> records = new ArrayList<>(Arrays.asList(badminton, kickboxen));

        Mockito.when(service.getAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/entries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].courseName", is("Kickboxenn")));
    }

    @Test
    public void getRecordById() throws Exception {
        Mockito.when(service.get(1L)).thenReturn(badminton);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/entries/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getRecordByIdName() throws Exception {
        Mockito.when(service.get(1L)).thenReturn(badminton);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/entries/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.courseName", is("Badminton")));
    }

}
