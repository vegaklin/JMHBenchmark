package backend.academy.benchmark.factory;

import backend.academy.benchmark.benchmark.BenchmarkRunner;
import backend.academy.benchmark.option.BenchmarkOptions;
import lombok.experimental.UtilityClass;
import org.openjdk.jmh.runner.options.Options;

@UtilityClass
public class BenchmarkFactory {

    public static BenchmarkRunner createRunner() {
        Options options = BenchmarkOptions.createBenchmarkOptions();
        return new BenchmarkRunner(options);
    }
}
