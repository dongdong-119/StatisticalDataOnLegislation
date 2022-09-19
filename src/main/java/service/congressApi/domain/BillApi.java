package service.congressApi.domain;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import service.congressApi.domain.form.BillForm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class BillApi {

    private String name;

    public BillApi(String name) {
        this.name = name;
    }

    // 법률안 중 하나 리턴(index : 0)
    public BillForm info() throws UnsupportedEncodingException, ParseException {

        JSONArray row = getRowArray();
        JSONObject bill = (JSONObject) row.get(0);
        BillForm billForm = new BillForm((String) bill.get("BILL_NAME"), (String) bill.get("PROPOSE_DT"), (String) bill.get("COMMITTEE"));
        return billForm;
    }


    // List<BillForm> return
    public List<BillForm> formListResult() throws UnsupportedEncodingException, ParseException {


        JSONArray row = getRowArray();

        List<BillForm> billList = new ArrayList<>();

        for(int i = 0; i < row.size(); i++){

            JSONObject bill = (JSONObject) row.get(i);
            BillForm billForm = new BillForm((String) bill.get("BILL_NAME"), (String) bill.get("PROPOSE_DT"), (String) bill.get("COMMITTEE"));
            billList.add(billForm);

        }

        return billList;

    }

    private JSONArray getRowArray() throws UnsupportedEncodingException, ParseException {
        String key = "440a7a0e0059447cb58b662f33394085";
        StringBuffer bufferresult = new StringBuffer();
        String proposerName = this.name + "의원";
        String encodedName = URLEncoder.encode(proposerName, "UTF-8");


        try {
            String apiUrl = "https://open.assembly.go.kr/portal/openapi/nzmimeepazxkubdpn?" +
                    "key=" + key +
                    "&type=json" +
                    "&pIndex=1" +
                    "&pSize=100" +
                    "&AGE=21" +
                    // 인코딩한 parameter로 제공해야 한다.
                    "&PROPOSER=" + encodedName;


            //String encodedUrl = URLEncoder.encode(apiUrl, "UTF-8");
            URL url = new URL(apiUrl);

            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

            urlconnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));

            String returnLine;


            while ((returnLine = br.readLine()) != null) {
                bufferresult.append(returnLine + "\n");
            }

            urlconnection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }


        String result;
        result = bufferresult.toString();


        //Json Parsing
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
        JSONArray jsonInfo = (JSONArray) jsonObject.get("nzmimeepazxkubdpn");
        JSONObject secondObject = (JSONObject) jsonInfo.get(1);
        JSONArray row = (JSONArray) secondObject.get("row");
        return row;
    }



}

