package backend.academy.benchmark;

import backend.academy.benchmark.benchmark.BenchmarkRunner;
import backend.academy.benchmark.benchmark.MethodAccessBenchmark;
import backend.academy.benchmark.factory.BenchmarkFactory;
import lombok.experimental.UtilityClass;
import org.openjdk.jmh.runner.RunnerException;

@UtilityClass
public class Main {
    public static void main(String[] args) throws RunnerException {
        BenchmarkRunner benchmarkRunner = BenchmarkFactory.createRunner(
            MethodAccessBenchmark.class.getSimpleName()
        );
        benchmarkRunner.start();
    }
}
