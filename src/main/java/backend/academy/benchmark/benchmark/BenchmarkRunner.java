package backend.academy.benchmark.benchmark;

import lombok.extern.log4j.Log4j2;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;

@Log4j2
public class BenchmarkRunner {
    private final Options options;

    public BenchmarkRunner(Options options) {
        this.options = options;
    }

    public void start() {
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            log.error("RunnerException error: ", e);
        }
    }
}
