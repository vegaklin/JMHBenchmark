package backend.academy.benchmark.benchmark.lambda;

import java.lang.invoke.MethodType;

@FunctionalInterface
public interface LambdaMetafactoryInvoker {
    MethodType SIGNATURE = MethodType.methodType(String.class, Object.class);

    String invoke(Object obj);
}
