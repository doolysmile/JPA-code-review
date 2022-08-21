package com.likelionking.LikeLionKingSbb.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter             // 없으면 상속받은 객체에서 값을 가져올 수 없음
@MappedSuperclass // entity 공통 column(상속 용도로만 사용하므로 추상 클래스로)
@SuperBuilder
@NoArgsConstructor  // JPA Entity에서 이벤트 발생할 때마다 특정 로직 실행
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
