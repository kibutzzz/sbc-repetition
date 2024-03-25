package br.unisinos.leonardo.sbc;

/**
 * @author Leonardo Meinerz Ramos
 */
public class Bootstrap {

  private static final double RANDOMNESS_FACTOR = 0.05;

  public static void main(String[] args) {

    final var reader = new Reader();
    System.out.print("Type the data: ");
    final var input = reader.readLine();

    System.out.print("Type the Ri (repetition factor): ");
    final var repetitionFactor = Integer.valueOf(reader.readLine());
    System.out.printf("input:\t\t\t\t\t\t%s%n", input);

    final var converter = new AsciiBinaryConverter();
    final var binaryInput = converter.encode(input);
    System.out.printf("binary:\t\t\t\t\t\t%s%n", binaryInput);

    final var repetitionFactorCalculator = new RepetitionFactorCalculator();
    final var repeatedData = repetitionFactorCalculator.calculate(binaryInput, repetitionFactor);
    System.out.printf("repeated binary:\t\t\t%s%n", repeatedData);


    final var randomStringCalculator = new RandomStringCalculator(RANDOMNESS_FACTOR);
    final var randomnessAddedBinary = randomStringCalculator.calculator(repeatedData);
    System.out.printf("after adding randomness:\t%s%n", randomnessAddedBinary);

    final var majorityCalculator = new MajorityCalculator();
    final var errorRemovedBinary = majorityCalculator.calculate(randomnessAddedBinary, repetitionFactor);
    System.out.printf("unrepeated binary:\t\t\t%s%n", errorRemovedBinary);

    final var output = converter.decode(errorRemovedBinary);
    System.out.printf("output:\t%s%n", output);
  }
}
