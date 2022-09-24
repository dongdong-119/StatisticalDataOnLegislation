package service.congressApi.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.congressApi.domain.form.BillFormV2;
import service.congressApi.domain.repository.DataRepository;
import service.congressApi.domain.repository.MemberRepository;
import service.congressApi.domain.statistics.Member;
import service.congressApi.domain.statistics.RateByArea;
import service.congressApi.domain.statistics.RateByProcess;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StatController {

    private final MemberRepository memberRepository;
    private final DataRepository dataRepository;

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @PostMapping("/memberInfo")
    public String info(@RequestParam("memberName") String name,
                             @RequestParam("memberParty") String party,
                             Model model){


        List<Member> members = memberRepository.findByNameAndParty(name, party);

        boolean memberEmpty = members.isEmpty();

        //국회의원이 DB에 없으면 main에서 에러메시지 보여줌
        if(memberEmpty){

            model.addAttribute("nameErr", true);
            return "index";

        } else{
        // 국회의원이 DB에 있으면 관련 data들 뽑아서 memberInfo로 이동
            Member member = members.get(0);
            RateByArea areaData = dataRepository.findAreaData(member);
            RateByProcess processData = dataRepository.findProcessData(member);
            List<BillFormV2> fiveBills = dataRepository.findFive(member);


            model.addAttribute("member", member);
            model.addAttribute("areaData", areaData);
            model.addAttribute("processData", processData);
            model.addAttribute("fiveBills", fiveBills);

            return "memberInfo";
        }
    }


    @GetMapping("/chart-test")
    public String chart(){
        return "chart-test";
    }










}
