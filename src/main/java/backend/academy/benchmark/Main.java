package backend.academy.benchmark;

import backend.academy.benchmark.factory.BenchmarkFactory;
import org.openjdk.jmh.runner.RunnerException;

public class Main {
    public static void main(String[] args) throws RunnerException {
        BenchmarkFactory.createRunner("MethodAccessBenchmark");
    }
}
