package com.austin.yungyangdd.domain.user.persistance;

import com.austin.yungyangdd.domain.user.domain.User;
import com.austin.yungyangdd.domain.user.domain.common.UserType;
import com.austin.yungyangdd.domain.user.exception.UserNotFoundException;
import com.austin.yungyangdd.global.dto.DateDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

import static com.austin.yungyangdd.domain.user.domain.QUser.user;


@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {


    private JPAQueryFactory queryFactory;


    public UserRepositorySupport(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }


    public User findById(Long userId){
        User result=queryFactory.selectFrom(user)
                .where(user.id.eq(userId)).fetchOne();
        if (result ==null){
            throw new UserNotFoundException(userId.toString());
        }
        return result;
    }
    public User findUserById(Long userId) {

        User result= queryFactory.selectFrom(user)
                .where(user.id.eq(userId)).fetchOne();

        if (result==null){
            throw new UserNotFoundException(userId.toString());
        }


        return result;
    }


    public User findByUserName(String username) {
        User result = queryFactory.selectFrom(user)
                .where(user.userName.eq(username)).fetchOne();
        if (result == null){
            throw new UserNotFoundException(username);
        }
        return result;
    }
    public List<User> findAll(String userType, String query, DateDTO dateDTO, Long userId) {
        return queryFactory.selectFrom(user)
                .where(user.id.isNotNull()
                        .and(userTypeCondition(userType,userId))
                        .and(searchQuery(query))
                        .and(dateQuery(dateDTO)))
                .fetch();
    }
    private BooleanExpression userTypeCondition(String userType, Long userId) {
        if(userType==null){
            return null;
        }
        if (userType.equals("agent")){
            return user.userType.eq(UserType.SEED)
                    .and(user.roles.isNotEmpty());
        }
        if (userType.equals("manufacturer")){
            return user.userType.eq(UserType.SEED)
                    .and(user.roles.isNotEmpty());
        }
        if (userType.equals("unapproved")){
            return user.roles.isEmpty();
        }
        return null;
    }
    private BooleanExpression searchQuery(String query) {
        if(query==null){
            return null;
        }
        return user.userName.contains(query)
//                .or(user.company.name.contains(query)
                        .or(user.userName.contains(query));
    }private BooleanExpression dateQuery(DateDTO dateDTO) {
        if (dateDTO.getStartedDate()==null){
            return null;
        }
        if (dateDTO.getEndedDate()==null){
            return null;
        }

        return user.createdDate.between(dateDTO.getStartedDate(),dateDTO.getEndedDate());
    }
}
