package org.example.structural.dynamicProxy;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class LoggingHandler implements InvocationHandler {
//    https://www.youtube.com/watch?v=T3VucYqdoRo

    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if (name.contains("toString")) {
            return calls.toString();
        }

        // if key does not exit ? initialise with default va lue : increment with default value
        calls.merge(name, 1, Integer::sum);
        return method.invoke(target, args);
    }
}
