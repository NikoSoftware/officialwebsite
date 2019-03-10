package top.nikochen.officialwebsite.conf;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/***
 *@作者
 *@功能描述
 *@时间9:45
 *@方法09
 *2018/9/10
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface CORS {
    String value() default "";
}
