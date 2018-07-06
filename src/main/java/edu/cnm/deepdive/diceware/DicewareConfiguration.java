package edu.cnm.deepdive.diceware;

import java.security.SecureRandom;
import java.util.Random;
import java.util.ResourceBundle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DicewareConfiguration {


  @Bean
  public Random getRandom() {
    return new SecureRandom();
  }

  @Bean
  public ResourceBundle getBundler() {
    return ResourceBundle.getBundle("wordlist");
  }
}
