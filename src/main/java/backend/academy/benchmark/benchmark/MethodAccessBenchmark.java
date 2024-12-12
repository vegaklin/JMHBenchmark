package backend.academy.benchmark.benchmark;

import backend.academy.benchmark.benchmark.lambda.LambdaMetafactoryInvoker;
import backend.academy.benchmark.model.Student;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Thread)
public class MethodAccessBenchmark {

    private Object student;

    private Method method;

    private MethodHandle methodHandle;

    private LambdaMetafactoryInvoker lambdaMetafactory;

    @Setup
    public void setup() throws Throwable {
        MethodAccessBenchmarkSetup benchmarkSetup = new MethodAccessBenchmarkSetup();

        student = benchmarkSetup.createStudent();

        method = benchmarkSetup.setupReflection(student);
        methodHandle = benchmarkSetup.setupMethodHandle(student);
        lambdaMetafactory = benchmarkSetup.setupLambdaMetafactory(methodHandle);
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = ((Student) student).name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void methodHandle(Blackhole bh) throws Throwable {
        String name = (String) methodHandle.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void lambdaMetafactory(Blackhole bh) {
        String name = lambdaMetafactory.invoke(student);
        bh.consume(name);
    }
}
