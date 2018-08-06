package gosker;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MyFooishHandler implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private List<String> allFooish = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        scanFooishClass();
        scanFooishMethod();
        System.out.println(allFooish);
    }

    /**
     * 查找 用 Fooish 注解的 类
     *
     * @throws Exception
     */
    private void scanFooishClass() throws Exception {
        final Map<String, Object> permissionMap = applicationContext.getBeansWithAnnotation(RestHystrix.class);
        for (final Object permissionObject : permissionMap.values()) {
            final Class<? extends Object> permissionClass = permissionObject.getClass();
            final RestHystrix annotation = permissionClass.getAnnotation(RestHystrix.class);
            if (annotation != null) {
                allFooish.addAll(Arrays.asList(annotation.tags()));
            }
        }
    }


    /**
     * 查找 用 Component 注解的 类 下面 用 Fooish 注解的方法
     *
     * @throws Exception
     */
    private void scanFooishMethod() throws Exception {
        final Map<String, Object> controllerMap = applicationContext.getBeansWithAnnotation(Component.class);
        for (final Object controllerObject : controllerMap.values()) {
            final Class<? extends Object> controllerClass = controllerObject.getClass();
            for (Method method : controllerClass.getDeclaredMethods()) {
                RestHystrix fooish = method.getAnnotation(RestHystrix.class);
                if (fooish != null) {
                    allFooish.addAll(Arrays.asList(fooish.tags()));
                }
            }
        }
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

}
