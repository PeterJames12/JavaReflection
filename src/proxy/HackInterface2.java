package proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HackInterface2 {

    public static void main(String[] args) {

        InvocationHandler handler = new MyInvocation();

        IMyProxy proxy = (IMyProxy) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IMyProxy.class}, handler);

        proxy.setName("Peter");
        proxy.setAge(21);
        proxy.howAreYou("Nice");
        System.out.println(proxy);
    }
}
