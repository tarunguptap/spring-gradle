
package com.spring.transformer.inf;


public interface Transformer<T, F> {

    F converts(T obj);
}
