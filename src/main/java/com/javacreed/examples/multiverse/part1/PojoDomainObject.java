package com.javacreed.examples.multiverse.part1;

public class PojoDomainObject {

  private long value;

  public PojoDomainObject(final long value) {
    this.value = value;
  }

  public long getValue() {
    return value;
  }

  public void setValue(final long value) {
    this.value = value;
  }
}
