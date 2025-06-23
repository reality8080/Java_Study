package _2_CreatingAndDestroyingObjects.Item1;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    private final String name;

    private static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<String, Logger>();

    private Logger(String name) {
        this.name = validAndNormalizedString(name);
    }

    private static String validAndNormalizedString(String str) {
        Objects.requireNonNull(str, "Logger name cannot be null.");
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            throw new IllegalArgumentException("Logger name cannot be empty or just whitespace.");
        }
        return strTrim;
    }

    public static Logger getInstance(String name) {
        return instances.computeIfAbsent(validAndNormalizedString(name), Logger::new);
    }

    public String getName() {
        return name;
    }
}