package com.austin.yungyangdd.global.domain;

import com.austin.yungyangdd.global.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "T_LOGHISTORY")
public class LogHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;

    private String url;

    public static LogHistory create(String ip, String url) {


        return LogHistory.builder()
                .ipAddress(ip)
                .url(url)
                .build();
    }

}
