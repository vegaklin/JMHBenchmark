package backend.academy.benchmark.benchmark;

import backend.academy.benchmark.benchmark.lambda.LambdaMetafactoryInvoker;
import backend.academy.benchmark.model.Student;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import static backend.academy.benchmark.constant.BenchmarkConstants.INTERFACE_METHOD_NAME;
import static backend.academy.benchmark.constant.BenchmarkConstants.METHOD_NAME;
import static backend.academy.benchmark.constant.BenchmarkConstants.NAME;
import static backend.academy.benchmark.constant.BenchmarkConstants.SURNAME;

public class MethodAccessBenchmarkSetup {

    public Object createStudent() {
        return new Student(NAME, SURNAME);
    }

    public Method setupReflection(Object student) throws NoSuchMethodException {
        return student.getClass().getMethod(METHOD_NAME);
    }

    public MethodHandle setupMethodHandle(Object student)
        throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class);

        return lookup.findVirtual(student.getClass(), METHOD_NAME, methodType);
    }

    public LambdaMetafactoryInvoker setupLambdaMetafactory(
        MethodHandle methodHandle
    ) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(LambdaMetafactoryInvoker.class);

        CallSite callSite = LambdaMetafactory.metafactory(
            lookup,
            INTERFACE_METHOD_NAME,
            methodType,
            LambdaMetafactoryInvoker.SIGNATURE,
            methodHandle,
            methodHandle.type()
        );
        return (LambdaMetafactoryInvoker) callSite.getTarget().invokeExact();
    }
}
