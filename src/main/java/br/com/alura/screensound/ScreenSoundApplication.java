package br.com.alura.screensound;

import br.com.alura.screensound.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenSoundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main.showMenu();
    }
}
