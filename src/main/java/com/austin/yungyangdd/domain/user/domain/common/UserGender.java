package com.austin.yungyangdd.domain.user.domain.common;

public enum UserGender {
    MAN("남자"),
    WOMAN("여자");

    private final String value;

    UserGender(String value) {
        this.value = value;
    }
}
