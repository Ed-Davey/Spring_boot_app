package com.example.app;

public interface IHttpLib {
    Response call(String url) throws Exception;
}