package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.InMemoryTimeEntryRepository;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class,args);
    }

    @Bean
    public TimeEntryRepository timeEntryRepository() {
        return new JdbcTimeEntryRepository(dataSource);
    }
}