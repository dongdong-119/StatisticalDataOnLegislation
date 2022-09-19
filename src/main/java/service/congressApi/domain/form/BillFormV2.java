package service.congressApi.domain.form;

import lombok.Data;

@Data
public class BillFormV2 {

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
    private String publProposer;


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


