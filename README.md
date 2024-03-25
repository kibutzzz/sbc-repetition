# Simulation of a Symmetric Binary Channel

## Description
The Bootstrap class serves as a simulation of a Symmetric Binary Channel, which replicates a communication channel with potential errors. This simulation is achieved through a series of steps, including data encoding, error introduction, and error correction.

### How it Works
1. Input Data: Users provide input data, which can be any string.

2. Data Encoding: The input data is encoded into binary format using the AsciiBinaryConverter class. This converts each character in the input string to its corresponding binary representation.

3. Repetition Factor: Users specify a repetition factor (Ri), indicating how many times each bit of the binary data should be repeated for error correction purposes.

4. Error Introduction: The binary data is replicated based on the repetition factor to increase error correction capabilities. Additionally, randomness is introduced to the replicated data using the RandomStringCalculator, simulating noise in the communication channel.

5. Error Correction: The MajorityCalculator class is used to correct errors in the data introduced by the symmetric binary channel. It employs a simple algorithm based on majority voting to determine the correct value of each bit.

6. Output: The corrected binary data is decoded back into its original format (text) using the AsciiBinaryConverter, providing the final output to the user.

## Prerequisites
- Java 17
- Apache Maven

## How to Run
1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the project using Maven:

```bash
mvn compile
```

4. Run the application:
```bash
mvn exec:java -Dexec.mainClass="br.unisinos.leonardo.sbc.Bootstrap"
```

5. Follow the prompts to input data and the repetition factor (Ri).

## Author
- Leonardo Meinerz Ramos
