package com.likelionking.sbbstudy.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // BaseEntity를 상속한 엔티티들은 아랲 ㅣㄹ드들을 컬럼으로 인식
@SuperBuilder
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // Auditing(자동으로 값 매핑) 기능 추가
public abstract class BaseTimeEntity {


    @CreatedDate
    private LocalDateTime createdDate;


    @LastModifiedDate
    private LocalDateTime updateDate;

}
