package service.congressApi.domain;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.congressApi.domain.form.BillFormV2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description : 법률안과 관련된 통신이나 내부처리를 담당합니다.
 *
 */
public class BillApiV2 {


    /**
     * name 입력하면, 해당 이름을 가진 국회의원이 발의한 법률안 BillFormV2에 담아서 가져옴
     *
     * <특정한 국회의원이 법률안 발의한 경우>
     * 1. 대표 발의자인 경우,
     * 2. 공동 발의자에 속하는 경우
     */
    public static List<BillFormV2> billByName(String name, List<BillFormV2> entireBills) throws UnsupportedEncodingException, ParseException {

        // 매번 호출할 필요 없음
        // DB에 데이터 넣을 때에는 처음 한번만 호출하고 그 데이터들 계속 갖다 쓰면됨
        List<BillFormV2> specifiedBills = new ArrayList<>();

        for (BillFormV2 billForm : entireBills) {

            String rstProposer = billForm.getRstProposer();
            String publProposer = billForm.getPublProposer();

            if (publProposer == null) {
                if (name.equals(rstProposer)) {
                    specifiedBills.add(billForm);
                }
            } else if (publProposer.contains(name) || name.equals(rstProposer)) {

                specifiedBills.add(billForm);
            }
        } // for문 끝

        return specifiedBills;
    }



    //상임위 이름 출력하는 메소드
    public static void committeeNames(List<BillFormV2> entireBills) throws UnsupportedEncodingException, ParseException {

        List<String> committees = new ArrayList<>();

        for (BillFormV2 billForm : entireBills) {

            if(billForm.getCommittee() == null){

            } else if (!committees.contains(billForm.getCommittee())) {
                committees.add(billForm.getCommittee());
            }
        }// for문 끝


        for (String committee : committees) {
            System.out.println(committee);
        }
    }




    // 21대 국회에서 지금까지 발의된 법류안 모두를 가져오는 메소드(List<BillFormV2>에 담아서 반환)
    public static List<BillFormV2> billInfo() throws ParseException {


        //String proposerName = this.name + "의원";
        //String encodedName = URLEncoder.encode(proposerName, "UTF-8");

        boolean flag = true;
        // 전체 법률안 담을 List
        List<BillFormV2> billList = new ArrayList<>();

        int index = 1;

        while (flag) {

            JSONArray jsonArray = makeJsonArray(index);


            if (jsonArray != null) {
                JSONObject secondObject = (JSONObject) jsonArray.get(1);
                JSONArray row = (JSONArray) secondObject.get("row");

                for (int i = 0; i < row.size(); i++) {
                    JSONObject bill = (JSONObject) row.get(i);
                    BillFormV2 billForm = new BillFormV2((String) bill.get("BILL_NAME"),
                            (String) bill.get("PROPOSE_DT"),
                            (String) bill.get("COMMITTEE"),
                            (String) bill.get("PROC_RESULT"),
                            (String) bill.get("RST_PROPOSER"),
                            (String) bill.get("PUBL_PROPOSER")
                    );
                    billList.add(billForm);
                }

                index++;

            } else {
                break;
            }
        }

        System.out.println(billList.size());
        System.out.println("ASDf");
        return billList;

    }




    // pIndex(index)로 가지고 온 데이터로 JsonArray 만듦
    private static JSONArray makeJsonArray(int index) throws ParseException {

        StringBuffer bufferresult = new StringBuffer();

        try{
            String apiUrl = "https://open.assembly.go.kr/portal/openapi/nzmimeepazxkubdpn?" +
                    "key=440a7a0e0059447cb58b662f33394085" +
                    "&type=json" +
                    "&pIndex=" + index +
                    "&pSize=1000" +
                    "&AGE=21";

            URL url = new URL(apiUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;


            while ((returnLine = br.readLine()) != null) {
                bufferresult.append(returnLine + "\n");
            }

            urlConnection.disconnect();


        } catch(Exception e){
            e.printStackTrace();

        }

        String result;
        result = bufferresult.toString();

        //Json Parsing
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("nzmimeepazxkubdpn");

        return jsonArray;
    }

}