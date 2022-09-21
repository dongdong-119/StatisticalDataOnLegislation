package service.congressApi;

import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.congressApi.domain.BillApiV2;
import service.congressApi.domain.statistics.Member;
import service.congressApi.domain.statistics.SaveBillRate;

import java.io.UnsupportedEncodingException;

@SpringBootApplication
public class CongressApiApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, ParseException, NoSuchFieldException, IllegalAccessException {SpringApplication.run(CongressApiApplication.class, args);


	}
}
