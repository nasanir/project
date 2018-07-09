package pers.nasanir.fountain.common.reflect;

import java.lang.reflect.InvocationTargetException;

public interface Invoker {
	Object invoke(Object obj, Object[] args)throws IllegalAccessException, InvocationTargetException ;

}
