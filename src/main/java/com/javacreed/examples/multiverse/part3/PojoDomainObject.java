package com.javacreed.examples.multiverse.part3;

import java.math.BigDecimal;

public class PojoDomainObject {

  private BigDecimal value;

  public PojoDomainObject(final long value) {
    this.value = new BigDecimal(value);
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(final BigDecimal value) {
    this.value = value;
  }
}
