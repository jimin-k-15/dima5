package objIOTest;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class FriendVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private LocalDate birthday;
   private String phone;
}