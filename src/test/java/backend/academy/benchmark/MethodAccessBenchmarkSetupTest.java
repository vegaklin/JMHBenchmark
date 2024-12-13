package backend.academy.benchmark;

import backend.academy.benchmark.benchmark.MethodAccessBenchmarkSetup;
import backend.academy.benchmark.benchmark.lambda.LambdaMetafactoryInvoker;
import backend.academy.benchmark.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static backend.academy.benchmark.constant.BenchmarkConstants.NAME;
import static backend.academy.benchmark.constant.BenchmarkConstants.SURNAME;
import static org.junit.jupiter.api.Assertions.*;

class MethodAccessBenchmarkSetupTest {

    private final MethodAccessBenchmarkSetup benchmarkSetup = new MethodAccessBenchmarkSetup();

    private Object student;

    @BeforeEach
    void setUp() {
        student = benchmarkSetup.createStudent();
    }

    @Test
    void checkCreateStudent() {
        // given-when

        Student actualStudent = (Student) student;

        // then

        assertEquals(NAME, actualStudent.name());
        assertEquals(SURNAME, actualStudent.surname());
    }

    @Test
    void checkSetupReflection() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // given

        Method method = benchmarkSetup.setupReflection(student);

        // when

        String actualName = (String) method.invoke(student);

        // then

        assertEquals(NAME, actualName);
    }

    @Test
    void checkSetupMethodHandle() throws Throwable {
        // given

        MethodHandle methodHandle = benchmarkSetup.setupMethodHandle(student);

        // when

        String actualName = (String) methodHandle.invoke(student);

        // then

        assertEquals(NAME, actualName);
    }

    @Test
    void checkSetupLambdaMetafactory() throws Throwable {
        // given

        MethodHandle methodHandle = benchmarkSetup.setupMethodHandle(student);
        LambdaMetafactoryInvoker lambdaMetafactory = benchmarkSetup.setupLambdaMetafactory(methodHandle);

        // when

        String actualName = lambdaMetafactory.invoke(student);

        // then

        assertEquals(NAME, actualName);
    }
}
