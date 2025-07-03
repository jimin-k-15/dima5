/*
 * [문제] 
 * enum 타입 Weather를 선언하시오.
 * 맑음, 안개, 흐림, 비, 눈 : 열거상수
 * "Sunny"
 * 
 */

package enumTest01;

public enum Weather {
	맑음("Sunny"), 안개("Foggy"), 흐림("Cloudy"), 비("Rainy"), 눈("Snowy");
	
	public String english;
	private Weather(String english) {
		this.english = english;
	}
}
