package lombokTest;

import java.time.LocalDate;

import lombok.ToString;

@Builder
@AllargsConstructor
@ToString
public class MyMember {
	private int id;
	private String name;
	private String gender;
	private String job;
	private LocalDate birthday;
	private String address;
}
