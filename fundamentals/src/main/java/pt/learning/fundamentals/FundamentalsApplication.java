package pt.learning.fundamentals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import pt.learning.fundamentals.entity.Application;
import pt.learning.fundamentals.entity.Release;
import pt.learning.fundamentals.entity.Ticket;
import pt.learning.fundamentals.repository.ApplicationRepository;
import pt.learning.fundamentals.repository.ReleaseRepository;
import pt.learning.fundamentals.repository.TicketRepository;

@SpringBootApplication
public class FundamentalsApplication {

    private static final Logger log = LoggerFactory.getLogger(FundamentalsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FundamentalsApplication.class, args);
    }

    @Bean
    @Profile("local")
    public CommandLineRunner demo(ApplicationRepository applicationRepository, TicketRepository ticketRepository,
                                  ReleaseRepository releaseRepository) {
        return (args) -> {

            Application application1 = Application.builder().name("App One").description("App One Description")
                    .owner("Jose Ferreira").build();
            Application application2 = Application.builder().name("App Two").description("App Two Description")
                    .owner("Pedro Ferreira").build();

            Release release1 = Release.builder().description("Release One").releaseDate("One").build();
            Release release2 = Release.builder().description("Release Two").releaseDate("Two").build();

            application1 = applicationRepository.save(application1);
            application2 = applicationRepository.save(application2);

            release1 = releaseRepository.save(release1);
            release2 = releaseRepository.save(release2);

            ticketRepository.save(Ticket.builder().application(application1).release(release1)
                    .description("Desc 1").title("Title 1").build());
            ticketRepository.save(Ticket.builder().application(application2).release(release2)
                    .description("Desc 2").title("Title 2").build());

            for(Application application : applicationRepository.findAll()) {
                log.info(application.toString());
            }

            for(Release release : releaseRepository.findAll()) {
                log.info(release.toString());
            }

            for (Ticket ticket : ticketRepository.findAll()) {
                log.info(ticket.toString());
            }
        };
    }
}
