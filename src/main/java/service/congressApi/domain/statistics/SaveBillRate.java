package service.congressApi.domain.statistics;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.congressApi.domain.BillApiV2;
import service.congressApi.domain.form.BillFormV2;
import service.congressApi.domain.repository.MemberRepository;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SaveBillRate {

    @Autowired
    MemberRepository memberRepository;

    public static List<BillFormV2> entireBills;

    static {
        try {
            entireBills = BillApiV2.billInfo();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * 1. member이름에 맞는 BillFormV2들 찾습니다. ( -> speicifedBillForm이라는 List에 넣음)
     * 2. 그 정보들을 바탕으로 RateByArea 객체를 만들고, 통계값 넣은 뒤 member에 매핑합니다.
     * 3. RateByProcess객체 만들고, 통계값 넣은 뒤 member에 매핑합니다.
     *
     *
     * n. member를 DB에 저장합니다.(
     */
    public void save(Member member) throws UnsupportedEncodingException, ParseException, IllegalAccessException, NoSuchFieldException {

        //해당 이름을 가진 국회의원이 발의한 법률안(BillForm 형태로 저장)
        List<BillFormV2> specifiedBillForm = BillApiV2.billByName(member.getName(), entireBills);

        //전체 법률안 개수
        int numOfBill = specifiedBillForm.size();

        member.setNumberOfBill(numOfBill);


        /*
         * RateByArea 설정
         */

        // 위원회 별 법률안 카운트 세는 MAP
        Map<String, Integer> committeeCount = new HashMap<>();


        committeeCount.put("congress", 0);
        committeeCount.put("law", 0);
        committeeCount.put("stateAffairs", 0);
        committeeCount.put("finance", 0);
        committeeCount.put("education", 0);
        committeeCount.put("scienceAndTech", 0);
        committeeCount.put("diplomacy", 0);
        committeeCount.put("military", 0);
        committeeCount.put("administration", 0);
        committeeCount.put("culture", 0);
        committeeCount.put("food", 0);
        committeeCount.put("industry", 0);
        committeeCount.put("health", 0);
        committeeCount.put("environment", 0);
        committeeCount.put("traffic", 0);
        committeeCount.put("information", 0);
        committeeCount.put("gender", 0);
        committeeCount.put("budget", 0);
        committeeCount.put("etc", 0);



        // 위원회 별 법률안 개수 카운트
        for(BillFormV2 billForm : specifiedBillForm){

            String committeeName = billForm.getCommittee();

            if(committeeName == null){
                int etcCount = committeeCount.get("etc");
                committeeCount.put("etc", ++etcCount);
            } else{

                // Map or Enum 활용해서 리팩토링
                // switch 문 끝
                switch (committeeName) {
                    case "국회운영위원회" -> {
                        int congressCount = committeeCount.get("congress");
                        committeeCount.put("congress", ++congressCount);
                    }
                    case "법제사법위원회" -> {
                        int lawCount = committeeCount.get("law");
                        committeeCount.put("law", ++lawCount);
                    }
                    case "정무위원회" -> {
                        int stateCount = committeeCount.get("stateAffairs");
                        committeeCount.put("stateAffairs", ++stateCount);
                    }
                    case "기획재정위원회" -> {
                        int financeCount = committeeCount.get("finance");
                        committeeCount.put("finance", ++financeCount);
                    }
                    case "교육위원회" -> {
                        int educationCount = committeeCount.get("education");
                        committeeCount.put("education", ++educationCount);
                    }
                    case "과학기술정보방송통신위원회" -> {
                        int techCount = committeeCount.get("scienceAndTech");
                        committeeCount.put("scienceAndTech", ++techCount);
                    }
                    case "외교통일위원회" -> {
                        int diplomacyCount = committeeCount.get("diplomacy");
                        committeeCount.put("diplomacy", ++diplomacyCount);
                    }
                    case "국방위원회" -> {
                        int militaryCount = committeeCount.get("military");
                        committeeCount.put("military", ++militaryCount);
                    }
                    case "행정안전위원회" -> {
                        int administrationCount = committeeCount.get("administration");
                        committeeCount.put("administration", ++administrationCount);
                    }
                    case "문화체육관광위원회" -> {
                        int cultureCount = committeeCount.get("culture");
                        committeeCount.put("culture", ++cultureCount);
                    }
                    case "농림축산식품해양수산위원회" -> {
                        int foodCount = committeeCount.get("food");
                        committeeCount.put("food", ++foodCount);
                    }
                    case "산업통상자원중소벤처기업위원회" -> {
                        int industryCount = committeeCount.get("industry");
                        committeeCount.put("industry", ++industryCount);
                    }
                    case "보건복지위원회" -> {
                        int healthCount = committeeCount.get("health");
                        committeeCount.put("health", ++healthCount);
                    }
                    case "환경노동위원회" -> {
                        int environmentCount = committeeCount.get("environment");
                        committeeCount.put("environment", ++environmentCount);
                    }
                    case "국토교통위원회" -> {
                        int trafficCount = committeeCount.get("traffic");
                        committeeCount.put("traffic", ++trafficCount);
                    }
                    case "정보위원회" -> {
                        int informationCount = committeeCount.get("information");
                        committeeCount.put("information", ++informationCount);
                    }
                    case "여성가족위원회" -> {
                        int genderCount = committeeCount.get("gender");
                        committeeCount.put("gender", ++genderCount);
                    }
                    case "예산결산특별위원회" -> {
                        int budgetCount = committeeCount.get("budget");
                        committeeCount.put("budget", ++budgetCount);
                    }
                    default -> {
                        int etcCount = committeeCount.get("etc");
                        committeeCount.put("etc", ++etcCount);
                    }
                }
            }
        } // for문 끝


        // 분야별 통계값 담는 객체
        RateByArea rateByArea = new RateByArea();

        try{

            Field[] fields = rateByArea.getClass().getDeclaredFields();

            for(Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();

                if (name != "id") {

                    Integer billCount = committeeCount.get(name);

                    if(billCount != 0){
                        float result = (float)billCount / numOfBill;
                        field.set(rateByArea, result);
                    } else{
                        field.set(rateByArea, 0F);
                    }
                }
            } //for문 끝

        } catch(Exception e){

            e.printStackTrace();

        }

        member.setRateByArea(rateByArea);




        /*
         * RateByProcess 설정
         */
        Map<String, Integer> processCount = new HashMap<>();


        processCount.put("passNotRevised", 0);
        processCount.put("passRevised", 0);
        processCount.put("alternative", 0);
        processCount.put("rejected", 0);
        processCount.put("withdrawal", 0);
        processCount.put("discard", 0);
        processCount.put("etc", 0);


        for(BillFormV2 billForm : specifiedBillForm){

            String procResult = billForm.getProcResult();

            if(procResult == null){
                int etcCount = processCount.get("etc");
                processCount.put("etc", ++etcCount);
            } else {


                switch (procResult) {
                    case "원안가결" -> {
                        int passNotRevisedCount = processCount.get("passNotRevised");
                        processCount.put("passNotRevised", ++passNotRevisedCount);
                    }
                    case "수정가결" -> {
                        int passRevisedCount = processCount.get("passRevised");
                        processCount.put("passRevised", ++passRevisedCount);
                    }
                    case "대안반영폐기" -> {
                        int alternativeCount = processCount.get("alternative");
                        processCount.put("alternative", ++alternativeCount);
                    }
                    case "부결" -> {
                        int rejectedCount = processCount.get("rejected");
                        processCount.put("rejected", ++rejectedCount);
                    }
                    case "철회" -> {
                        int withdrawalCount = processCount.get("withdrawal");
                        processCount.put("withdrawal", ++withdrawalCount);
                    }
                    case "폐기" -> {
                        int discardCount = processCount.get("discard");
                        processCount.put("discard", ++discardCount);
                    }
                    default -> {
                        int etcCount = processCount.get("etc");
                        processCount.put("etc", ++etcCount);
                    }
                } // switch문 끝

            }

        } // for문 끝


        // 처리상태별 통계값 담는 객체
        RateByProcess rateByProcess = new RateByProcess();

        try{

            Field[] fields = rateByProcess.getClass().getDeclaredFields();

            for(Field field : fields){
                field.setAccessible(true);
                String name = field.getName();

                if(name != "id"){

                    Integer billCount = processCount.get(name);

                    if(billCount != 0){
                        float result = (float) billCount / numOfBill;
                        field.set(rateByProcess, result);
                    } else {
                        field.set(rateByProcess, 0F);
                    }
                }
            } //for문


        } catch(Exception e){
            e.printStackTrace();
        }

        member.setRateByProcess(rateByProcess);


        /*
         * member를 DB에 저장
         */
        memberRepository.save(member);

    }
}
