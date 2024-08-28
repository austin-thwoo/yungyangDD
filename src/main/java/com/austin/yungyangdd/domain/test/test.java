package com.austin.yungyangdd.domain.test;

import com.austin.yungyangdd.domain.common.models.Address;
import com.austin.yungyangdd.domain.user.domain.common.UserGender;
import com.austin.yungyangdd.domain.user.domain.common.UserType;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_TEST")
public class test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long brand;



}
