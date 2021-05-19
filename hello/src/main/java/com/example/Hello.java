package com.example;

public interface Hello {
  public default void hello() {
    System.out.print("Hello World!");
  }
}
