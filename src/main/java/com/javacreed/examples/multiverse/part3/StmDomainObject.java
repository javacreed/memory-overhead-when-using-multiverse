package com.javacreed.examples.multiverse.part3;

import java.math.BigDecimal;

import org.multiverse.api.StmUtils;
import org.multiverse.api.Txn;
import org.multiverse.api.callables.TxnCallable;
import org.multiverse.api.references.TxnRef;

public class StmDomainObject {

  private final TxnRef<BigDecimal> value;

  public StmDomainObject(final long value) {
    this.value = StmUtils.newTxnRef(new BigDecimal(value));
  }

  public BigDecimal getValue() {
    return StmUtils.atomic(new TxnCallable<BigDecimal>() {
      @Override
      public BigDecimal call(final Txn txn) throws Exception {
        return value.get(txn);
      }
    });
  }

  public void setValue(final BigDecimal value) {
    StmUtils.atomic(new Runnable() {
      @Override
      public void run() {
        StmDomainObject.this.value.set(value);
      }
    });
  }
}
