package pharmacyapp.ProductDetails;

import java.util.Date;

//TestModel
public class Product {
@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", cost=" + cost + ", Quantity ="+quantity+", expiryDate=" + expiryDate + "]";
	}
public int productId;
public String productName;
public String productType;
public int cost;
public int quantity;
public Date expiryDate;

}


