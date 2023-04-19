package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;
@Configuration
@EnableScheduling
@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "oussama", new Date(), false, 12));
            patientRepository.save(new Patient(null, "saad", new Date(), true, 15));
            patientRepository.save(new Patient(null, "ali", new Date(), false, 16));
            patientRepository.save(new Patient(null, "hamza", new Date(), true, 2));

            patientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom());
            });

        };

    }
}
