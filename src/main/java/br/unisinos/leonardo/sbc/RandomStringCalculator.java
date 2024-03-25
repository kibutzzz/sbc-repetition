package br.unisinos.leonardo.sbc;

import java.util.Arrays;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class RandomStringCalculator {

  private final double randomnessFactor;
  private final RandomGenerator generator;

  public RandomStringCalculator(Double randomnessFactor) {
    this.randomnessFactor = randomnessFactor;
    this.generator = RandomGenerator.getDefault();
  }

  public String calculator(String input) {
    return Arrays.stream(input.split("")).map(toRandomlyFlipped()).collect(Collectors.joining());
  }

  private Function<String, String> toRandomlyFlipped() {
    return number -> {
      final var randomValue = generator.nextDouble(0, 1);

      if (randomValue > randomnessFactor) {
        return number;
      }

      if ("0".equals(number)) {
        return "1";
      }

      return "0";
    };
  }
}
