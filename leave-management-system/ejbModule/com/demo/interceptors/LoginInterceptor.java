package com.demo.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LoginInterceptor {

	@AroundInvoke
	public Object preLoginInterceptor(InvocationContext invocationContext) throws Exception {
		String methodName = invocationContext.getMethod().getName();
		System.out.println("=========================================================");
		System.out.println("======== Method Name [ " + methodName + " ] =============");
		System.out.println("=========================================================");
		return invocationContext.proceed();
	}
}
