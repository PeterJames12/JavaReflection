package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class HackInterface {

    public static void main(String[] args) {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Method name: " + method.getName() +
                "args: " + Arrays.toString(args));
                return null;
            }
        };

        IMyProxy myProxy = (IMyProxy) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IMyProxy.class}, handler);

        myProxy.setName("Igor");
        myProxy.setAge(21);
        myProxy.howAreYou("Good");
    }
}
