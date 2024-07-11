package sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description: 排序接口
 */
public interface BaseSort {
    void sort(int[] arr);

    /**
     *
     * @param arr 要排序的数组
     * @param sortObj 排序方法的实现类
     * @param <T> 排序方法实现类的类型
     */
    static<T> void runSort(int[] arr, T sortObj) {
        try {
            Class<?> proxyFactory = Class.forName("ProxyFactory");
            Method method = proxyFactory.getMethod("getProxyInstance", Object.class);
            BaseSort proxy = (BaseSort) method.invoke(null, sortObj);
            proxy.sort(arr);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(arr));
    }
}
