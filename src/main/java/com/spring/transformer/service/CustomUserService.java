package com.spring.transformer.service;


public interface CustomUserService<T> {
    T searchUser(Long userId);
}
