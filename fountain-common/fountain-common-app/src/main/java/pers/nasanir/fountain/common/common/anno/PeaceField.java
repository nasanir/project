package pers.nasanir.fountain.common.common.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
public @interface PeaceField {
	boolean isPk() default false;

	int lenght() default 50;

	boolean isVaild() default true;
}
