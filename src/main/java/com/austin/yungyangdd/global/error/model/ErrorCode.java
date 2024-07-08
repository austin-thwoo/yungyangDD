package com.austin.yungyangdd.global.error.model;

public enum ErrorCode {




    INVALID_INPUT_VALUE(400, "C001", "올바르지 않은 형식입니다."),
    METHOD_NOT_ALLOWED(405, "C002", "지원하지 않는 메소드입니다."),
    ENTITY_NOT_FOUND(400, "C003", "해당 엔티티를 찾을 수가 없습니다."),
    INTERNAL_SERVER_ERROR(500, "C004", "알 수 없는 에러 (서버 에러)"),
    INVALID_TYPE_VALUE(400, "C005", "타입이 올바르지 않습니다."),
    HANDLE_ACCESS_DENIED(403, "C006", "권한이 없습니다."),
    HANDLE_INVALID_TOKEN(401, "C007", "토큰이 없거나 올바르지 않습니다."),
    DATE_WRONG(401, "C008", "비교날짜가 올바르지 않습니다."),


    USER_NOT_FOUND(400, "U000", "해당 유저를 찾을 수 없습니다"),
    DUPLICATED_NICKNAME(500, "U001", "중복된 닉네임 입니다."),
    DUPLICATED_ID(500, "U002", "사용 불가능한 아이디 입니다."),
    USER_DELETED(400, "U000", "탈퇴한 유저입니다."),

    NOT_MATCH_PASSWORD(500, "U004", "비밀번호를 확인 해 주세요"),

    //Ingredient
    SYMPTOM_NOT_FOUND(500, "I001", "해당 증상을 찾을 수 없습니다."),
    INGREDIENT_NOT_FOUND(500, "I002", "해당 증상을 찾을 수 없습니다."),
    SUPPLEMENT_NOT_FOUND(500, "I003", "해당 영양제를 찾을 수 없습니다."),
    INGREDIENT_NOT_MATCH(500, "I004", "성분 고유값을 확인해주세요."),



    //Board
    BOARD_NOT_FOUND(500, "B001", "해당 게시글이 존재하지 않습니다."),
    BOARD_DELETED(500, "B002", "삭제된 게시글입니다."),
    //Shop
    SHOP_NOT_FOUND(400, "S001", "해당 매장을 찾을 수 없습니다."),
    MANUFACTURER_NOT_FOUND(400, "S002", "해당 제조사를 찾을 수 없습니다."),
    MANUFACTURER_OVERLAP(400, "S003", "해당 제조사 이름은 이미 사용중입니다."),

    USER_MIS_MATCH(500, "R9721", "로그인한 유저의 정보가 다릅니다.");


    private final int status;
    private final String code;
    private final String message;


    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }


}
