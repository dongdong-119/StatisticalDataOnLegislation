package service.congressApi.domain.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import service.congressApi.domain.statistics.Member;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

@Data
@Entity
@NoArgsConstructor
public class BillFormV2 {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // 법안명
    private String billName;
    // 제안날짜
    private String proposeDate;
    // 발의 위원회
    private String committee;
    // 처리 상태(null 많음)
    private String procResult;
    // 대표 발의자
    private String rstProposer;
    // 공동 발의자
    @Column(length = 1000)
    private String publProposer;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public BillFormV2(String billName, String proposeDate, String committee,
                      String procResult, String rstProposer, String publProposer) {
        this.billName = billName;
        this.proposeDate = proposeDate;
        this.committee = committee;
        this.procResult = procResult;
        this.rstProposer = rstProposer;
        this.publProposer = publProposer;
    }

    @Override
    public String toString() {
        return "BillFormV2{" +
                "billName='" + billName + '\'' +
                ", proposeDate='" + proposeDate + '\'' +
                ", committee='" + committee + '\'' +
                ", procResult='" + procResult + '\'' +
                ", rstProposer='" + rstProposer + '\'' +
                ", publProposer='" + publProposer + '\'' +
                '}';
    }
}


