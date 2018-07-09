package pers.nasanir.fountain.common.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvoker implements Invoker {
	private Method method;
	
	public MethodInvoker(Method method) {
		// TODO Auto-generated constructor stub
		this.method=method;
	}
	
	public Object invoke(Object obj,Object[] args) throws IllegalAccessException, InvocationTargetException {
		return method.invoke(obj, args);
	}
}
