package gosker;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface RestHystrix {

    String[] tags() default { "all" };
}
