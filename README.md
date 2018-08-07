# SpringAOPAnnotationBasedProject

##Creating Aspect class
```java
	@Aspect
	@Component
	public class Audience {}
```
	
## Using @Before advice
```java	
	@Before("execution(public void com.spring.aop.concert.Performance.perform())")
	public void silenceCellPhones(){
		System.out.println("Silencing cell Phones");
	}
```

##Using @After advice
```java	
	@AfterReturning("execution(public void com.spring.aop.concert.Performance.perform())")
	public void applause(){
		System.out.println("Now, Clap Clap Clap");
	}
```
##Using @@AfterThrowing advice
```java	
	@AfterThrowing("execution(public void com.spring.aop.concert.Performance.perform())")
	public void demandRefund(){
		System.out.println("Demanding a return!");
	}
```

##Using @Pointcut to use more generic Expressions
```java
	@Pointcut("execution(public * com.spring.aop.concert.Performance.perform(..))")
	public void performance(){}
	
	@Before("performance()"), @AfterThrowing("performance()"), etc.
```

##Using @Around advice
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
