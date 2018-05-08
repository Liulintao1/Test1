package com.llt.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class FrigBefore {
	@Pointcut("execution(* com.llt.daoImpl.*.* (..))")
	public void p1(){};
	@Before(value="p1()")
  private void before(JoinPoint jp) throws Throwable{
	  //通过joinPoint获取目标方法传入的参数customer值
	  String customer=(String) jp.getArgs()[0];
	  //显示欢迎信息，在byFrig方法前调用
	  System.out.println("欢迎光临！"+customer+"!");
	  
  }
}
