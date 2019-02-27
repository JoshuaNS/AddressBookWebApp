package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "134 Street", "555-1234"));
            repository.save(new BuddyInfo("Chloe", "O'Brian Rd.", "555-4412"));
            repository.save(new BuddyInfo("Kim", "The Reas Lane", "555-555-2442"));
            repository.save(new BuddyInfo("Josh", "Lis Ave", "555-555-8954"));

            // fetch all customers
            log.info("BuddyInfo found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo bi : repository.findAll()) {
                log.info(bi.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("BuddyInfo found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("BuddyInfo found with findByName('Chloe'):");
            log.info("--------------------------------------------");
            repository.findByName("Chloe").forEach(chloe -> {
                log.info(chloe.toString());
            });

            // fetch customers by phone number
            log.info("BuddyInfo found with findByPhoneNumber('555-555-8954'):");
            log.info("--------------------------------------------");
            repository.findByPhoneNumber("555-555-8954").forEach(number -> {
                log.info(number.toString());
            });

            log.info("");
        };
    }
}
