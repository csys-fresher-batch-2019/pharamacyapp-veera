package pharmacyapp.purchaseDetails;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pharmacyapp.companyDetails.CompanyModel;
@Data
@ToString
@NoArgsConstructor
public class Purchase {
private int purchaseId;
private int productId;
private Date purchaseDate;
private int companyId; 
private int purchaseQuantity;
private int amount;
}
