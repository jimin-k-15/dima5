package enumTest01;

import java.util.Scanner;

public class WeatherTest {

	public static void main(String[] args) {
		Scanner keyin = new Scanner(System.in);
		String today = null;

		System.out.println("오늘의 날씨는?");
		today = keyin.next();
		
		Weather todayWeather = Weather.valueOf(today);
		String feeling = switch (todayWeather) {
			case Weather.맑음, Weather.눈 	-> "기분도 맑음";
			case Weather.안개, Weather.흐림 -> "울적한 기분";
			case Weather.비                 -> "축축";
		};
		
		System.out.println("오늘의 날씨(k): " + todayWeather);
		System.out.println("오늘의 날씨(e): " + todayWeather.english);
		System.out.println("오늘의 느낌: " + feeling);
	}
}
