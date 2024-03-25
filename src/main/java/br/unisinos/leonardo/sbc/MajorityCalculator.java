package br.unisinos.leonardo.sbc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class MajorityCalculator {

  public String calculate(String input, int repetitionFactor) {
    return Arrays.stream(input.split("(?<=\\G.{" + repetitionFactor + "})"))
        .map(byMajority())
        .collect(joining());
  }

  private Function<String, String> byMajority() {
    return repeatedCharacters -> {

      final var mapOfOccurrences = Arrays.stream(repeatedCharacters.split(""))
          .collect(toMap(Function.identity(), value -> 1, Integer::sum));

      return Collections.max(mapOfOccurrences.entrySet(), Map.Entry.comparingByValue())
          .getKey();
    };
  }
}
