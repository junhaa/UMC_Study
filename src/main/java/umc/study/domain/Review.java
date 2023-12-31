package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text", nullable = false)
    private String title;

    @Column(nullable = false)
    private Float score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList = new ArrayList<>();

    // 연관 관계 편의 메서드 (필요한가 ?)
    public void setStore(Store store){
        if(this.store != null){
            this.store.getReviewList().remove(this);
        }
        this.store = store;
        store.getReviewList().add(this);
    }

    public void setMember(Member member){
        if(this.member != null){
            this.member.getReviewList().remove(this);
        }
        this.member = member;
        member.getReviewList().add(this);
    }
}