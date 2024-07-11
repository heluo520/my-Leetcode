import java.lang.reflect.Proxy;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description:
 */
public class ProxyFactory {
    public static Object getProxyInstance(Object obj){
        Object o = Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("代理方法执行");
                    long l = System.currentTimeMillis();
                    Object invoke = method.invoke(obj, args);
                    long s = System.currentTimeMillis();
                    long sum = s - l;
                    StringBuilder builder = new StringBuilder("执行时间为：").append(sum).append("毫秒");
                    System.out.println(builder);
                    return invoke;
                }
        );
        return  o;
    }
}
