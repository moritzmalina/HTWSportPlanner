package htwberlin.HTWSportPlanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ScraperScheduler {

    private static final Logger logger = LoggerFactory.getLogger(ScraperScheduler.class);

    @Autowired
    private PlannerService plannerService;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String scraperUrl = "https://htw-scraper.onrender.com/scraper";

    @Scheduled(fixedRate = 3600000) // Run every 1 hour
    public void updateCoursesFromScraper() {
        logger.info("Starting to update courses from scraper");

        ScraperEntry[] newEntries;
        try {
            newEntries = restTemplate.getForObject(scraperUrl, ScraperEntry[].class);
            if (newEntries == null) {
                logger.warn("No entries found from scraper");
                return;
            }
        } catch (Exception e) {
            logger.error("Error accessing scraper URL: " + scraperUrl, e);
            return;
        }

        for (ScraperEntry entry : newEntries) {
            try {
                if (!plannerService.existsByTitleAndDay(entry.getTitel(), entry.getTag())) {
                    logger.info("Saving new entry: " + entry.getTitel() + " on " + entry.getTag());
                    plannerService.save(convertToPlannerEntry(entry));
                } else {
                    logger.info("Entry already exists: " + entry.getTitel() + " on " + entry.getTag());
                }
            } catch (Exception e) {
                logger.error("Error processing entry: " + entry, e);
            }
        }

        logger.info("Finished updating courses from scraper");
    }

    private PlannerEntry convertToPlannerEntry(ScraperEntry scraperEntry) {
        PlannerEntry plannerEntry = new PlannerEntry();
        plannerEntry.setCourseName(truncate(scraperEntry.getTitel(), 255));
        plannerEntry.setWeekDay(truncate(scraperEntry.getTag(), 255));
        plannerEntry.setPlace(truncate(scraperEntry.getOrt(), 255));
        plannerEntry.setCourseTime(parseLocalTime(scraperEntry.getZeit().split("-")[0].trim()));

        // Assuming zeitraum is in the format "dd.MM.-dd.MM."
        LocalDate[] dates = parseZeitraum(scraperEntry.getZeitraum());
        plannerEntry.setStartDate(dates[0]);
        plannerEntry.setEndDate(dates[1]);

        plannerEntry.setManagement(truncate(scraperEntry.getLeitung(), 255));
        plannerEntry.setDescription(truncate(scraperEntry.getBeschreibung(), 1000));
        return plannerEntry;
    }

    private String truncate(String value, int length) {
        if (value == null) {
            return null;
        }
        return value.length() > length ? value.substring(0, length) : value;
    }
    private LocalTime parseLocalTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }

    private LocalDate[] parseZeitraum(String zeitraum) {
        String[] dates = zeitraum.split("-");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int currentYear = LocalDate.now().getYear();
        LocalDate startDate = LocalDate.parse(dates[0].trim() + currentYear, formatter);
        LocalDate endDate = LocalDate.parse(dates[1].trim() + currentYear, formatter);
        return new LocalDate[]{startDate, endDate};
    }
}