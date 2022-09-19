package service.congressApi.domain.statistics;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String partyName;

    /**
     * 법률안 발의 관련 통계 정보(21대 한정)
     * 1. 전체 법률안 발의 수
     * 2. 분야별 법률안 비율(number도 할 수 있으면)
     * 3. 처리상태별 법률안 비율
     * 4.
     */
    private int numberOfBill;


    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "AREA_RATE_ID")
    private RateByArea rateByArea;

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name= "PROCESS_RATE_ID")
    private RateByProcess rateByProcess;




    public Member(String name) {
        this.name = name;
        this.numberOfBill = numberOfBill;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partyName='" + partyName + '\'' +
                ", numberOfBill=" + numberOfBill +
                ", rateByArea=" + rateByArea +
                '}';
    }
}
