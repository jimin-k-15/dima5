package optionalTest;

import java.util.Optional;

public class OptionalCreation {
	public static void main(String[] args) {
		Optional<String> opt1 = Optional.empty();
		
		System.out.println(opt1);				// Optional.empty
		System.out.println(opt1.isPresent());  	// false
		
		Optional<String> opt2 = Optional.of("개나리진달래");
		System.out.println(opt2.orElseGet(() -> "무궁화"));
		
		Optional<String> opt3 = Optional.ofNullable(null);
		String name = opt3.orElse("겨울");				// null이면 "겨울"을 리턴
		System.out.println(name);

	}

}
