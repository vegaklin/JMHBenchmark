package backend.academy.benchmark.factory;

import backend.academy.benchmark.benchmark.BenchmarkRunner;
import backend.academy.benchmark.config.BenchmarkConfig;
import lombok.experimental.UtilityClass;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;

@UtilityClass
public class BenchmarkFactory {

    public static BenchmarkRunner createRunner(String benchmarkClassName) throws RunnerException {
        Options options = BenchmarkConfig.createBenchmarkOptions(benchmarkClassName);
        return new BenchmarkRunner(options);
    }
}
