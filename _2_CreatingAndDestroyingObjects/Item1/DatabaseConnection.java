package _2_CreatingAndDestroyingObjects.Item1;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseConnection {
    private final String configString;

    private static final ConcurrentHashMap<String, DatabaseConnection> instances = new ConcurrentHashMap<String, DatabaseConnection>();

    private DatabaseConnection(String configString) {
        // this.configString = Objects.requireNonNull(configString, "Configuration
        // string cannot be null").trim();
        // if (this.configString.isEmpty()) {
        // throw new IllegalArgumentException("Configuration string cannot be empty");
        // }
        this.configString = validateAndNormalizeConnectionString(configString);
    }

    public static DatabaseConnection getConnection(String configString) {
        String normalizedConfig = validateAndNormalizeConnectionString(configString);
        // if (normalizedConfig.isEmpty()) {
        // throw new IllegalArgumentException("Configuration string cannot be empty");
        // }
        return instances.computeIfAbsent(normalizedConfig, k -> new DatabaseConnection(k));
    }

    private static String validateAndNormalizeConnectionString(String str) {
        Objects.requireNonNull(str, "Connection string cannot be null.");
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            throw new IllegalArgumentException("Connection string cannot be empty or just whitespace.");
        }
        return strTrim;
    }

    public String getConfigString() {
        return configString;
    }

    public void executeQuery(String query) {
        System.out.println(query);
    }
}
