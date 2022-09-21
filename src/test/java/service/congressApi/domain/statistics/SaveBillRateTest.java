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
import service.congressApi.domain.repository.DataRepository;
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

        Member member1 = new Member("우상호");
        member1.setPartyName("더불어민주당");
        saveBillRate.save(member1);

        Member member2 = new Member("정진석");
        member2.setPartyName("국민의힘");
        saveBillRate.save(member2);

    }


    @Test
    @Transactional
    public void bring_Data() throws Exception{
        //given
        List<Member> members = memberRepository.findByNameAndParty("우상호", "더불어민주당");

        if(!members.isEmpty()){
            Member member = members.get(0);
            RateByArea areaData = dataRepository.findAreaData(member);
            System.out.println(areaData.getDiplomacy());

            RateByProcess processData = dataRepository.findProcessData(member);
            System.out.println(processData.getEtc());
        }

        //when

        //then

    }



}