# Benchmark Results

| Benchmark                                                                              | Mode | Cnt | Score  | Error (+-) | Units |
|----------------------------------------------------------------------------------------|------|-----|--------|------------|-------|
| MethodAccessBenchmark.directAccess **(Direct Access)**                                 | avgt | 30  | 0.755  | 0.009      | ns/op |
| MethodAccessBenchmark.invokeLambdaMetafactory **(java.lang.invoke.LambdaMetafactory)** | avgt | 30  | 1.016  | 0.032      | ns/op |
| MethodAccessBenchmark.invokeMethodHandle **(java.lang.invoke.MethodHandles)**          | avgt | 30  | 5.175  | 0.565      | ns/op |
| MethodAccessBenchmark.reflection **(java.lang.reflect.Method)**                        | avgt | 30  | 11.076 | 0.083      | ns/op |


