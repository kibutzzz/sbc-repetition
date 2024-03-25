package br.unisinos.leonardo.sbc;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RepetitionFactorCalculator {

  public String calculate(String input, int repetitionFactor) {
    return Arrays.stream(input.split(""))
        .map(character -> character.repeat(repetitionFactor))
        .collect(Collectors.joining());
  }
}
