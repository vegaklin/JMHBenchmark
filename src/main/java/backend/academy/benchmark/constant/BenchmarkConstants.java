package backend.academy.benchmark.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BenchmarkConstants {
    private static final String YAML_FILE_PATH = "application.yaml";

    private final ConfigParser configParser = new ConfigParser(YAML_FILE_PATH);

    public static final String BENCHMARK_CLASS_NAME = configParser.get("BENCHMARK_CLASS_NAME", String.class);
    public static final String METHOD_NAME = configParser.get("METHOD_NAME", String.class);

    public static final int THREADS_COUNT = configParser.get("THREADS_COUNT", Integer.class);
    public static final int FORKS_COUNT = configParser.get("FORKS_COUNT", Integer.class);

    public static final int WARMUP_FORKS_COUNT = configParser.get("WARMUP_FORKS_COUNT", Integer.class);
    public static final int WARMUP_ITERATIONS = configParser.get("WARMUP_ITERATIONS", Integer.class);
    public static final int WARMUP_TIME = configParser.get("WARMUP_TIME", Integer.class);

    public static final int MEASUREMENT_ITERATIONS = configParser.get("MEASUREMENT_ITERATIONS", Integer.class);
    public static final int MEASUREMENT_TIME = configParser.get("MEASUREMENT_TIME", Integer.class);
}
