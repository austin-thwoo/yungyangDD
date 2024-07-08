package com.austin.yungyangdd.domain.common.models;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAgeCount is a Querydsl query type for AgeCount
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAgeCount extends BeanPath<AgeCount> {

    private static final long serialVersionUID = 995170698L;

    public static final QAgeCount ageCount = new QAgeCount("ageCount");

    public final NumberPath<Long> fiftyCount = createNumber("fiftyCount", Long.class);

    public final NumberPath<Long> fortyCount = createNumber("fortyCount", Long.class);

    public final NumberPath<Long> sixtyCount = createNumber("sixtyCount", Long.class);

    public final NumberPath<Long> teenCount = createNumber("teenCount", Long.class);

    public final NumberPath<Long> thirtyCount = createNumber("thirtyCount", Long.class);

    public final NumberPath<Long> twentyCount = createNumber("twentyCount", Long.class);

    public QAgeCount(String variable) {
        super(AgeCount.class, forVariable(variable));
    }

    public QAgeCount(Path<? extends AgeCount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgeCount(PathMetadata metadata) {
        super(AgeCount.class, metadata);
    }

}

