package com.brentmoen.boot;

import com.brentmoen.commons.logging.LoggerFactory;
import com.brentmoen.commons.logging.NoOpLoggerFactory;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAppModule extends AbstractModule {
    private final AtomicInteger counter;

    public TestAppModule(AtomicInteger counter) {
        this.counter = counter;
    }

    @Provides
    LoggerFactory provideLoggerFactory(NoOpLoggerFactory loggerFactory) {
        return loggerFactory;
    }

    @Provides
    @Singleton
    AtomicInteger provideCounter() {
        return counter;
    }
}
