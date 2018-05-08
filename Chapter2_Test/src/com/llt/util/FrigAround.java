package com.llt.util;

import java.util.HashSet;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class FrigAround {
  private Set<String> customers=new HashSet<String>();

  @Pointcut("execution(* com.llt.daoImpl.*.* (..))")
  public void p1(){}
  @Around("p1()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable{
	  Object[] argsObjects=pjp.getArgs();//目标方法所有参数
	  String customer=(String) argsObjects[0];
	  String frig=(String) argsObjects[1];
	  if (customers.contains(customer)) {
		throw new BuyFrigException("一名顾客只能购买一台冰箱，您已经购买过一台"+frig+"冰箱了");
		
	}
	  try {
			return pjp.proceed();
		} finally {
			// TODO: handle finally clause
			customers.add(customer);
		}
  }
}
