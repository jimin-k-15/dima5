package net.dima.spring9.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import net.dima.spring9.dto.PredictDTO;
import net.dima.spring9.service.PredictService;

@Controller
@RequiredArgsConstructor
public class PredictController {
	private final PredictService predictService;
	/**
	 * 분석을 하기 위해 입력화면 요청
	 * @return
	 */
	@GetMapping("/predict")
	public String predict() {
		return "predict/iris";
	}
	
	@PostMapping("/predict")
	@ResponseBody
	public Map<String, Object> predict(@ModelAttribute PredictDTO predictDTO) {
		Map<String, Object> map = null;
		
		map = predictService.predictRest(predictDTO);
		
		return map;
	}
}
