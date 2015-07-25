package com.javacreed.examples.multiverse.part2;

public class PojoDomainObject {

  private String value;

  public PojoDomainObject(final long value) {
    this.value = String.valueOf(value);
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }
}
