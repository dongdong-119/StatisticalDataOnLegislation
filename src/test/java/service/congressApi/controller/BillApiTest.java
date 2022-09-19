package service.congressApi.controller;

import org.junit.jupiter.api.Test;
import service.congressApi.domain.BillApi;
import service.congressApi.domain.BillApiV2;
import service.congressApi.domain.form.BillForm;
import service.congressApi.domain.form.BillFormV2;

import java.util.ArrayList;
import java.util.List;

class BillApiTest {

    @Test
    public void 단일_출력() throws Exception{
        //given
        BillApi bill = new BillApi("우상호");
        BillForm info = bill.info();

        //when
        System.out.println(info.toString());

        //then

    }


    @Test
    public void 복수_출력() throws Exception{
        //given
        BillApi bill = new BillApi("안철수");
        List<BillForm> billList = bill.formListResult();

        //when
        for (BillForm billForm : billList) {
            System.out.println(billForm.toString());
        }

        //then

    }
    @Test
    public void 처리상태() throws Exception{

        List<BillFormV2> entireBills = BillApiV2.billInfo();

        //given
        List<BillFormV2> billList = BillApiV2.billByName("송재호", entireBills);

        for(int i = 0; i<billList.size(); i++){
            System.out.println(i+"번째 법률안 : " + billList.get(i).getBillName());
        }

        System.out.println(billList);

        List<String> processList = new ArrayList<>();

        for(BillFormV2 billForm : billList) {
            String process = billForm.getProcResult();

            if(process == null){process = "null";}


            //해당 처리 상태 없는 경우에만 proccess에 집어 넣음.
            if (!processList.contains(process)) {
                processList.add(process);
            }

        }

        for(String result : processList){
            System.out.println(result);
        }

    }


}