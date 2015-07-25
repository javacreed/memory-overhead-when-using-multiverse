package com.javacreed.examples.multiverse.part2;

import org.multiverse.api.StmUtils;
import org.multiverse.api.Txn;
import org.multiverse.api.callables.TxnCallable;
import org.multiverse.api.references.TxnRef;

public class StmDomainObject {

  private final TxnRef<String> value;

  public StmDomainObject(final long value) {
    this.value = StmUtils.newTxnRef(String.valueOf(value));
  }

  public String getValue() {
    return StmUtils.atomic(new TxnCallable<String>() {
      @Override
      public String call(final Txn txn) throws Exception {
        return value.get(txn);
      }
    });
  }

  public void setValue(final String value) {
    StmUtils.atomic(new Runnable() {
      @Override
      public void run() {
        StmDomainObject.this.value.set(value);
      }
    });
  }
}
