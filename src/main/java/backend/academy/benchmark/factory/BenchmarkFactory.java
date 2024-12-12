package backend.academy.benchmark.factory;

import backend.academy.benchmark.config.BenchmarkConfig;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;

public class BenchmarkFactory {

    public static void createRunner(String benchmarkClassName) throws RunnerException {
        Options options = BenchmarkConfig.createBenchmarkOptions(benchmarkClassName);
        new Runner(options).run();
    }
}
