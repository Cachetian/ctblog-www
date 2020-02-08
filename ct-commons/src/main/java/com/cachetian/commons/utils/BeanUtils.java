package com.cachetian.commons.utils;

// import java.lang.reflect.Method;
import java.util.List;

public class BeanUtils {

	private static final Class<?> noparams[] = {};

	private static final Object novar[] = {};

	/**
	 * @param src
	 * @param dest
	 * @param props property name in first letter capital case. e.g. Id, UniqueName
	 */
	public static void copyProperties(Object src, Object dest, List<String> props) {
		try {
			for (String prop : props) {
				System.out.println("prop:" + prop);
				// Object value = getClassDeclaredMethodInheritance(src.getClass(), "get" + prop, noparams).invoke(src, novar);
				Object value = src.getClass().getMethod("get" + prop, noparams).invoke(src, novar);
				Class<?>[] paramType = new Class[1];
				paramType[0] = value.getClass();
				// getClassDeclaredMethodInheritance(dest.getClass(), "set" + prop, paramType).invoke(dest, value);
				dest.getClass().getMethod("set" + prop, paramType).invoke(dest, value);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// private static Method getClassDeclaredMethodInheritance(Class<?> clazz, String method, Class<?>[] params)
	// 		throws NoSuchMethodException, SecurityException {
	// 	Method methodInstance = getClassDeclaredMethodSafely(clazz, method, params);
	// 	System.out.println("method1:" + methodInstance);
	// 	Class<?> parentClazz = clazz.getSuperclass();
	// 	while (methodInstance == null && parentClazz != null) {
	// 		methodInstance = getClassDeclaredMethodSafely(parentClazz, method, params);
	// 		System.out.println("method:" + methodInstance);
	// 		if (methodInstance != null) {
	// 			break;
	// 		}
	// 		System.out.println("parent:" + parentClazz);
	// 		String lastName = parentClazz.getName();
	// 		parentClazz = clazz.getSuperclass();
	// 		// reach top
	// 		if (lastName.equals(parentClazz.getName())) {
	// 			break;
	// 		}
	// 	}
	// 	return methodInstance;
	// }

	// private static Method getClassDeclaredMethodSafely(Class<?> clazz, String method, Class<?>[] params) {
	// 	Method methodInstance = null;
	// 	try {
	// 		methodInstance = clazz.getDeclaredMethod(method, params);
	// 	} catch (Exception e) {
	// 		methodInstance = null;
	// 	}
	// 	return methodInstance;
	// }
}
