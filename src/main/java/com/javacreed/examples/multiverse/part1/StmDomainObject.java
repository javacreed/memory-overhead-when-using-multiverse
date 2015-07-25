package com.javacreed.examples.multiverse.part1;

import org.multiverse.api.StmUtils;
import org.multiverse.api.Txn;
import org.multiverse.api.callables.TxnLongCallable;
import org.multiverse.api.references.TxnLong;

public class StmDomainObject {

  private final TxnLong value;

  public StmDomainObject(final long value) {
    this.value = StmUtils.newTxnLong(value);
  }

  public long getValue() {
    return StmUtils.atomic(new TxnLongCallable() {
      @Override
      public long call(final Txn txn) throws Exception {
        return value.get(txn);
      }
    });
  }

  public void setValue(final long value) {
    StmUtils.atomic(new Runnable() {
      @Override
      public void run() {
        StmDomainObject.this.value.set(value);
      }
    });
  }
}
