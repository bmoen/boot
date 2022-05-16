package com.brentmoen.boot;

import com.brentmoen.commons.logging.Logger;
import com.brentmoen.commons.logging.LoggerFactory;

import javax.inject.Inject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TestApp implements Runnable {
    private final TestConfig config;
    private final AtomicInteger counter;
    private final Logger logger;

    @Inject
    public TestApp(TestConfig config, AtomicInteger counter, LoggerFactory loggerFactory) {
        this.config = Objects.requireNonNull(config);
        this.counter = Objects.requireNonNull(counter);
        this.logger = loggerFactory.create(getClass());
    }

    @Override
    public void run() {
        counter.set(config.getValue());
        logger.info("Hello " + config.getName());
    }
}
