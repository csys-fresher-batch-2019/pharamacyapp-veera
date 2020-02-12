package pharmacyapp.stock1Details;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Stock1 {
	private int stock1Id;
	private int productId;
	private	String stock1Name;
	private int stock1Number;
	private	String stock1Type;
	private String stock1Status;
	
}
