package service.congressApi.domain.statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import service.congressApi.domain.BillApiV2;
import service.congressApi.domain.form.BillForm;
import service.congressApi.domain.form.BillFormV2;
import service.congressApi.domain.repository.MemberRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveBillRateTest {

    @Autowired
    private SaveBillRate saveBillRate;


    @Test
    @Transactional
    @Rollback(false)
    public void 저장() throws Exception {

        Member member = new Member("우상호");
        saveBillRate.save(member);

        Member member1 = new Member("안철수");
        saveBillRate.save(member1);
        //when

    }

    @Test
    @Transactional
    public void 법률안_확인() throws Exception{

        List<BillFormV2> entireBills = SaveBillRate.entireBills;

        List<BillFormV2> chulsu = BillApiV2.billByName("안철수", entireBills);

        for(BillFormV2 bill : chulsu){
            System.out.println(bill.getBillName());
        }
    }



}