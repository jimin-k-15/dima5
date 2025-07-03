package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
	private int serialNum;
	private String name;
	private int price;
	private int wingCount;
}
