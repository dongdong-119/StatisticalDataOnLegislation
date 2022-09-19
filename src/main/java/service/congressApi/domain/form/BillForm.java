package service.congressApi.domain.form;

import lombok.Data;

@Data
public class BillForm {

    private String billName;
    private String proposedDate;
    private String committee;
    //private

    public BillForm(String billName, String proposedDate, String committee) {
        this.billName = billName;
        this.proposedDate = proposedDate;
        this.committee = committee;
    }

    @Override
    public String toString() {
        return "BillForm{" +
                "법률안이름='" + billName + '\'' +
                ", 발의날짜='" + proposedDate + '\'' +
                ", 소속위원회='" + committee + '\'' +
                '}';
    }


}
