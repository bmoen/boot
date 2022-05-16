package com.brentmoen.boot;

import picocli.CommandLine;

public class TestConfig implements AppConfig {
    @CommandLine.Option(names = {"-n", "--name"}, description = "Name")
    String name;

    @CommandLine.Option(names = {"-v", "--value"}, description = "Value")
    int value;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this message")
    boolean helpRequested = false;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean isHelpRequested() {
        return false;
    }

    @Override
    public void run() {
    }
}
