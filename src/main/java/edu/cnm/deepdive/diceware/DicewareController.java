package edu.cnm.deepdive.diceware;

import java.util.Random;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceware")
public class DicewareController {

  private Generator generator;

  @Autowired
  public DicewareController (Random rng, ResourceBundle bundle) {
    generator = new Generator(bundle, rng);
  }


  @GetMapping(produces = "application/json")
  public String[] generate(
      @RequestParam(value= "length", defaultValue = "6") int length,
      @RequestParam( value= "duplicates", defaultValue = "true") boolean duplicates) {
    return generator.next(length, duplicates);

  }


  @GetMapping(produces = "text/plain")
  public String generate(
      @RequestParam(value = "length", defaultValue="6") int length,
      @RequestParam(value = "duplicates", defaultValue="true") boolean duplicates,
      @RequestParam(value = "delimiter", defaultValue = " ") String delimiter) {
    return String.join(delimiter, generator.next(length, duplicates));
  }

}
