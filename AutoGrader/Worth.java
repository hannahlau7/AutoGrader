import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Worth {
	int points();
	String feedback() default "";
} 