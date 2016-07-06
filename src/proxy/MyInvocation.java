package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;


public class MyInvocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method name: " + method.getName() +
                "args: " + Arrays.toString(args));
        return null;
    }
}
