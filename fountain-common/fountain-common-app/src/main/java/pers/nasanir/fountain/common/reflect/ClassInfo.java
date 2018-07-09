package pers.nasanir.fountain.common.reflect;

import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.exception.ReflectRuntimeException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;


public class ClassInfo {
	private static HashMap<Class<?>, ClassInfo> CACHEMAP = new HashMap<Class<?>, ClassInfo>();
	private Class<?> clz;
	private HashMap<String, Invoker> InvokerMap = new HashMap<String, Invoker>();
	private HashMap<String, Object> AnnotationMap = new HashMap<String, Object>();
	

	ClassInfo(Class<?> clz) {
		this.clz = clz;
		init();
	}

	private void init() {
		addMethods(clz);
		addAnnotation(clz);
	}

	public static ClassInfo forClass(Class<?> clz) {
		if (clz != null) {
			if (!CACHEMAP.containsKey(clz)) {
				CACHEMAP.put(clz, new ClassInfo(clz));
			}
			return CACHEMAP.get(clz);
		} else {
			throw new ReflectRuntimeException("forClass is null");
		}
	}

	private void addMethods(Class<?> clz) {
		Method[] methodArr = clz.getMethods();
		for (Method method : methodArr) {
			String name = method.getName().toLowerCase(Locale.ROOT);
			if ((name.startsWith(CommonConstant.GET) && method.getParameterTypes().length == 0)
					|| name.startsWith(CommonConstant.SET)) {
				InvokerMap.put(name, new MethodInvoker(method));
			}
		}
	}

	private void addAnnotation(Class<?> clz) {
		Annotation[] annoArr = clz.getAnnotations();
		for (Annotation anno : annoArr) {
			String name = anno.annotationType().getName();
			AnnotationMap.put(name, anno);
		}
	}

	public Class<?> getClz() {
		return clz;
	}

	public HashMap<String, Invoker> getInvokerMap() {
		return InvokerMap;
	}

	public HashMap<String, Object> getAnnotationMap() {
		return AnnotationMap;
	}

	public <A extends Annotation> Object getAnnotation(Class<A> clz) {
		if (AnnotationMap.containsKey(clz.getName())) {
			return AnnotationMap.get(clz.getName());
		}
		return null;
	}

}
