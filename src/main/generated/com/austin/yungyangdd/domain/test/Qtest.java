package com.austin.yungyangdd.domain.test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * Qtest is a Querydsl query type for test
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qtest extends EntityPathBase<test> {

    private static final long serialVersionUID = -2070259019L;

    public static final Qtest test = new Qtest("test");

    public final NumberPath<Long> brand = createNumber("brand", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public Qtest(String variable) {
        super(test.class, forVariable(variable));
    }

    public Qtest(Path<? extends test> path) {
        super(path.getType(), path.getMetadata());
    }

    public Qtest(PathMetadata metadata) {
        super(test.class, metadata);
    }

}

