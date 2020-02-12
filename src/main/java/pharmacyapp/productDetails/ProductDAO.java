package pharmacyapp.productDetails;

import java.util.ArrayList;

//write methods using table name
public interface ProductDAO {
	
	void addProductDetails(Product p) throws Exception;
	void updateProductType(String productType, int productId) throws Exception;
	void updateCost(int cost, int proId) throws Exception;
	ArrayList displayProduct() throws Exception;
	ArrayList selectProductId(int d2) throws Exception;

}
