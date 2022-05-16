package com.brentmoen.boot;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import picocli.CommandLine;

import java.lang.reflect.InvocationTargetException;

public class Boot {
    public static <T extends AppConfig> void boot(String[] args, Class<? extends Runnable> appClass, Class<T> configClass, AbstractModule... modules) {
        try {
            T config = (T) configClass.getConstructors()[0].newInstance();

            CommandLine commandLine = new CommandLine(config);
            int exitCode = commandLine.execute(args);

            if (config.isHelpRequested() || exitCode != 0) {
                System.out.println();
                return;
            }

            AbstractModule[] combined = new AbstractModule[modules.length + 1];
            combined[0] = new AbstractModule() {
                @Override
                protected void configure() {
                    bind(configClass).toInstance(config);
                }
            };

            for (int i = 0; i < modules.length; i++) {
                combined[i + 1] = modules[i];
            }

            Guice.createInjector(combined)
                .getInstance(appClass)
                .run();
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
