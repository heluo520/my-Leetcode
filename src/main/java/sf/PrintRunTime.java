package sf;

import sort.BaseSort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description:
 */
public interface PrintRunTime {
    /**
     *
     * @param args 代理方法需要的参数
     */
    void run(Object...args);

    /**
     *
     * @param target 被代理对象
     * @param args run方法需要的参数
     * @param <T> 被代理对象类型
     */
    static<T> void proxyRun(T target,Object...args) {
        try {
            Class<?> proxyFactory = Class.forName("ProxyFactory");
            Method method = proxyFactory.getMethod("getProxyInstance", Object.class);
            PrintRunTime proxy = (PrintRunTime) method.invoke(null, target);
            proxy.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
