package br.unisinos.leonardo.sbc;

import java.util.Scanner;

public class Reader {

  private Scanner scanner;

  public Reader() {
    this.scanner = new Scanner(System.in) ;
  }
  public String readLine() {

    return scanner.nextLine();
  }
}
