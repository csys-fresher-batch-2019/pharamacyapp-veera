package pharmacyapp.salesDetails;

import java.time.LocalDateTime;
import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pharmacyapp.companyDetails.CompanyModel;
@Data
@ToString
@NoArgsConstructor
public class Sales
{
	private int salesId;
   private	int productId;
   private Date salesDate;
   private String salesQuantity;
   private int amount;
}
