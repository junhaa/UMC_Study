package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.foodCategory;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private foodCategory foodCategory;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}