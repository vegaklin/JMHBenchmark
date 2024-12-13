package backend.academy.benchmark.option;

import java.util.concurrent.TimeUnit;
import lombok.experimental.UtilityClass;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import static backend.academy.benchmark.constant.BenchmarkConstants.BENCHMARK_CLASS_NAME;
import static backend.academy.benchmark.constant.BenchmarkConstants.FORKS_COUNT;
import static backend.academy.benchmark.constant.BenchmarkConstants.MEASUREMENT_ITERATIONS;
import static backend.academy.benchmark.constant.BenchmarkConstants.MEASUREMENT_TIME;
import static backend.academy.benchmark.constant.BenchmarkConstants.THREADS_COUNT;
import static backend.academy.benchmark.constant.BenchmarkConstants.WARMUP_FORKS_COUNT;
import static backend.academy.benchmark.constant.BenchmarkConstants.WARMUP_ITERATIONS;
import static backend.academy.benchmark.constant.BenchmarkConstants.WARMUP_TIME;

@UtilityClass
public class BenchmarkOptions {

    public static Options createBenchmarkOptions() {
        return new OptionsBuilder()
            .include(BENCHMARK_CLASS_NAME)
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .threads(THREADS_COUNT)
            .forks(FORKS_COUNT)
            .warmupForks(WARMUP_FORKS_COUNT)
            .warmupIterations(WARMUP_ITERATIONS)
            .warmupTime(TimeValue.seconds(WARMUP_TIME))
            .measurementIterations(MEASUREMENT_ITERATIONS)
            .measurementTime(TimeValue.seconds(MEASUREMENT_TIME))
            .build();
    }
}
