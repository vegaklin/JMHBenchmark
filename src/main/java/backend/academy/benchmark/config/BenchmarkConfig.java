package backend.academy.benchmark.config;

import backend.academy.benchmark.benchmark.MethodAccessBenchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import java.util.concurrent.TimeUnit;

public class BenchmarkConfig {

    public static Options createBenchmarkOptions() {
        return new OptionsBuilder()
            .include(MethodAccessBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .threads(1)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(3)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(3)
            .measurementTime(TimeValue.seconds(5))
            .build();
    }
}
