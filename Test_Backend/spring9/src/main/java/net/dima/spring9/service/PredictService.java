package net.dima.spring9.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dima.spring9.dto.PredictDTO;


@Service
@RequiredArgsConstructor
@Slf4j
public class PredictService {
	private final RestTemplate restTemplate;
	
	@Value("${iris.predict.server}")
	String url;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> predictRest(PredictDTO iris) {
		log.info("서버 주소: {}", url);
		log.info("아이리스 값: {}", iris.toString());
		
		Map<String, Object> result = new HashMap<>();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<Map> response = restTemplate.postForEntity(url, iris, Map.class);
		
		log.info("응답코드: {}", response.getStatusCode());
		result = response.getBody();
		
		log.info("분석 결과: {}", result.get("predict_result"));
		return result;
	}
}
