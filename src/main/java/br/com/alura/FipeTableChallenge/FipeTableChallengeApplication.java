package br.com.alura.FipeTableChallenge;

import br.com.alura.FipeTableChallenge.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableChallengeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeTableChallengeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var main = new Main();
        main.showMenu();
    }
}
