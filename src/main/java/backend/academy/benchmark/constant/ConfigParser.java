package backend.academy.benchmark.constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConfigParser {

    private final Map<String, String> properties = new HashMap<>();

    public ConfigParser(String filePath) {
        loadConfig(filePath);
    }

    private void loadConfig(String filePath) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found in resources");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int colonIndex = line.indexOf(':');
                if (colonIndex != -1) {
                    String key = line.substring(0, colonIndex).trim();
                    String value = line.substring(colonIndex + 1).trim();
                    if (value.startsWith("\"") && value.endsWith("\"") && value.length() > 1) {
                        value = value.substring(1, value.length() - 1);
                    }
                    properties.put(key, value);
                }
            }
        } catch (IOException e) {
            log.error("IOException error", e);
        }
    }

    public <T> T get(String key, Class<T> type) {
        String value = properties.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Key not found: " + key);
        }
        return switch (type.getSimpleName()) {
            case "String" -> type.cast(value);
            case "Integer" -> type.cast(Integer.valueOf(value));
            case "Boolean" -> type.cast(Boolean.valueOf(value));
            case "Double" -> type.cast(Double.valueOf(value));
            default -> throw new IllegalArgumentException("Unsupported type: " + type);
        };
    }
}
