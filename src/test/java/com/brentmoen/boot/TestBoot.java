package com.brentmoen.boot;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoot {
    @Test
    public void test() {
        AtomicInteger counter = new AtomicInteger(0);
        Boot.boot(new String[] { "-v", "2" }, TestApp.class, TestConfig.class, new TestAppModule(counter));
        assertEquals(2, counter.get());
    }
}
