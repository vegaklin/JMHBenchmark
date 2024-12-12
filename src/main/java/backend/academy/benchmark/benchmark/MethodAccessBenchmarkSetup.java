package backend.academy.benchmark.benchmark;

import backend.academy.benchmark.benchmark.lambda.LambdaMetafactoryInvoker;
import backend.academy.benchmark.model.Student;
import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodAccessBenchmarkSetup {

    public Object createStudent() {
        return new Student("Ruslan", "Gimaev");
    }

    public Method setupReflection(Object student) throws NoSuchMethodException {
        return student.getClass().getMethod("name");
    }

    public MethodHandle setupMethodHandle(Object student)
        throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(String.class);

        return lookup.findVirtual(student.getClass(), "name", methodType);
    }

    public LambdaMetafactoryInvoker setupLambdaMetafactory(
        MethodHandle methodHandle
    ) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(LambdaMetafactoryInvoker.class);

        CallSite callSite = LambdaMetafactory.metafactory(
            lookup,
            "invoke",
            methodType,
            LambdaMetafactoryInvoker.SIGNATURE,
            methodHandle,
            methodHandle.type()
        );
        return (LambdaMetafactoryInvoker) callSite.getTarget().invokeExact();
    }
}
