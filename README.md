# SpringAOPAnnotationBasedProject

### Creating Aspect class
* Aspect bean should also be registered in IOC
* @Aspect and @Component must be used
```java
	@Aspect
	@Component
	public class Audience {}
```
	
### Using @Before advice
* Running before the adviced method
```java	
	@Before("execution(public void com.spring.aop.concert.Performance.perform())")
	public void silenceCellPhones(){
		System.out.println("Silencing cell Phones");
	}
```

### Using @@AfterReturning advice
* Running after returning successfully from the adviced method
```java	
	@AfterReturning("execution(public void com.spring.aop.concert.Performance.perform())")
	public void applause(){
		System.out.println("Now, Clap Clap Clap");
	}
```

### Using @AfterThrowing advice
* Running after throwing exception from the adviced method
```java	
	@AfterThrowing("execution(public void com.spring.aop.concert.Performance.perform())")
	public void demandRefund(){
		System.out.println("Demanding a return!");
	}
```

### Using @Pointcut to use more generic Expressions
* To make a common ragular expression
```java
	@Pointcut("execution(public * com.spring.aop.concert.Performance.perform(..))")
	public void performance(){}
	
	@Before("performance()"), @AfterThrowing("performance()"), etc.
```

### Using @Around advice
* Have to use ProceedingJoinPoint class
* statements before ProceedingJoinPoint.proceed() are considered as @Before("") advice
* statements after ProceedingJoinPoint.proceed() are considered as @AfterThrowing advice
* if anything fails in ProceedingJoinPoint.proceed() {running adviced method then} its considered as @AfterThrowing advice

```java
	@Around("performance()")
	public void watchperformance(ProceedingJoinPoint jp){
		try {
			System.out.println("Silencing cell Phones");
			System.out.println("Taking Seats!");
			jp.proceed();
			System.out.println("Now, Clap Clap Clap");
		} catch (Throwable e) {
			System.out.println("Demanding a return!");
		}
	}
```	
