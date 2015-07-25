package com.javacreed.examples.multiverse.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;

import com.javacreed.examples.multiverse.utils.LoggerUtils;

public class Example3 {

  public static final Logger LOGGER = LoggerUtils.getLogger(Example3.class);

  public static void main(final String[] args) throws InterruptedException {

    final int limit = 10000000;
    final List<PojoDomainObject> list = new ArrayList<>(limit);
    for (int i = 0; i < limit; i++) {
      list.add(new PojoDomainObject(i));
    }

    Example3.LOGGER.debug("Done.");
    TimeUnit.SECONDS.sleep(5);
  }

}
