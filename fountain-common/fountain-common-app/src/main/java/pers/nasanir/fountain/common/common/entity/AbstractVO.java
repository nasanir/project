package pers.nasanir.fountain.common.common.entity;

import pers.nasanir.fountain.common.common.constant.CommonConstant;
import pers.nasanir.fountain.common.reflect.ClassInfo;
import pers.nasanir.fountain.common.reflect.Invoker;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public abstract class AbstractVO implements Serializable {

	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Object getValue(String name) {
		ClassInfo classInfo = ClassInfo.forClass(this.getClass());
		Invoker invoker = classInfo.getInvokerMap().get(CommonConstant.GET + name.toLowerCase(Locale.ROOT));
		if (invoker != null) {
			try {
				Object value = invoker.invoke(this, null);
				return value;
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setValue(String name, Object value) {
		ClassInfo classInfo = ClassInfo.forClass(this.getClass());
		Invoker invoker = classInfo.getInvokerMap().get(CommonConstant.SET + name.toLowerCase(Locale.ROOT));
		if (invoker != null) {
			Object[] args = { value };
			try {
				invoker.invoke(this, args);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
