package com.austin.yungyangdd.domain.supplements.domain.type;

public enum ShopType {
    ONLINE("온라인"),
    OLIVEYOUNG("오리브영"),
    COUPANG("쿠팡"),
    FOREST("숲");

    private final String value;

    ShopType(String value) {
        this.value = value;
    }
}
