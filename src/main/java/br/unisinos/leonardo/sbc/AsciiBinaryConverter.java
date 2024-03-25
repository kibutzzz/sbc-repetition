package br.unisinos.leonardo.sbc;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class AsciiBinaryConverter {

  private static final int LEFT_PADDING = 8;

  public String encode(String ascii) {
    return Arrays.stream(ascii.split(""))
        .map(character -> character.charAt(0))
        .map(Integer::toBinaryString)
        .map(byAddingLeadingSpaces())
        .map(byReplacingSpacesToZeroes())
        .collect(joining());
  }

  public String decode(String binary) {
    return Arrays.stream(binary.split("(?<=\\G.{" + LEFT_PADDING + "})"))
        .map(b -> Integer.parseInt(b, 2))
        .map(characterValue -> (char) characterValue.intValue())
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  private Function<String, String> byReplacingSpacesToZeroes() {
    return leftPadded -> leftPadded.replaceAll(" ", "0");
  }

  private Function<String, String> byAddingLeadingSpaces() {
    return binary -> String.format("%" + LEFT_PADDING + "s", binary);
  }
}
