package ua.itea;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.*;


public final class CounterMethods {

    private static int counter = 1;

    public static void main(String[] args) {

        Map<String, Integer> wasInvoke = new HashMap<>();
        final Object[][] parameters = new Object[1][1];

        InvocationHandler invoke = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                wasInvoke.put(method.getName(), counter++);
                parameters[0] = args;

                return null;
            }
        };

        IHandler handler = (IHandler) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IHandler.class}, invoke);

        handler.handle();
        handler.handle();
        handler.handle();
        handler.handle();
        handler.handle();
        handler.sendStatusCode(200);
        handler.sendStatusCode(200);
        handler.sendStatusCode(200);

        if (wasInvoke.isEmpty()) {
            System.out.println("0 * handle()");
            System.out.println("0 * sendStatusCode() certainly without parameters");
            return;
        }

        Integer handle = wasInvoke.get("handle");
        Integer sendStatusCode = wasInvoke.get("sendStatusCode");

        System.out.println(MessageFormat.format("{0} * handle()", handle));
        System.out.println(MessageFormat.format("{0} * statusCode() with parameters: {1}", sendStatusCode - handle, Arrays.deepToString(parameters)));
    }

    public interface IHandler {
        void handle();
        void sendStatusCode(int status);
    }
}
