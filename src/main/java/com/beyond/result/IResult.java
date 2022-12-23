package com.beyond.result;

public interface IResult<T> {

    String getCode();

    String getMessage();

    T getData();

    long getElapsed();

    void setElapsed(long elapsed);

}
