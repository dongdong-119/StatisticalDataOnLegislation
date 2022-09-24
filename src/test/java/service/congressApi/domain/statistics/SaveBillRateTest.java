package service.congressApi.domain.statistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import service.congressApi.domain.form.BillFormV2;
import service.congressApi.domain.repository.DataRepository;
import service.congressApi.domain.repository.MemberRepository;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaveBillRateTest {

    @Autowired
    private SaveBillRate saveBillRate;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DataRepository dataRepository;


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
    @Rollback(false)
    public void 기본데이터_저장() throws Exception{

        Member member = new Member("우상호");
        saveBillRate.save(member);
        Member member1 = new Member("정진석");
        saveBillRate.save(member1);

    }


    @Test
    @Transactional
    @Rollback(false)
    public void bring_Data() throws Exception{
        List<Member> member = memberRepository.findByNameAndParty("우상호", "더불어민주당");
        Member memberA = member.get(0);

        List<BillFormV2> fiveBills = dataRepository.findFive(memberA);


        for (BillFormV2 fiveBill : fiveBills) {
            String proposeDate = fiveBill.getProposeDate();
            System.out.println(proposeDate);
        }
    }



}