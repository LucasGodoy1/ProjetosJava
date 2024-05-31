package lucasgodoy1.com.github.nakedapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NakedApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NakedApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
