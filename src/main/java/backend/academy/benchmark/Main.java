package backend.academy.benchmark;

import backend.academy.benchmark.benchmark.BenchmarkRunner;
import backend.academy.benchmark.factory.BenchmarkFactory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        BenchmarkRunner benchmarkRunner = BenchmarkFactory.createRunner();
        benchmarkRunner.start();
    }
}
