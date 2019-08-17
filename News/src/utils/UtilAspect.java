package utils;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class UtilAspect {
	static Logger logger = Logger.getLogger(UtilAspect.class);

	@Around("execution(* dao.*.*(..))")
	public Object doLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info(">>DEBUT : "+ pjp.getSignature().toLongString());
		long td = System.nanoTime();
		Object objRes = pjp.proceed();
		logger.info("<<FIN : "+ pjp.getSignature().toShortString() + " [" + (System.nanoTime() - td)/ 1000000.0 + " ms]");
		return objRes;
	}
}