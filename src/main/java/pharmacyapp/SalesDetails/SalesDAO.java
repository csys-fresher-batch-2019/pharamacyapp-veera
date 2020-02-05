package pharmacyapp.SalesDetails;

public interface SalesDAO {
void addSalesDetails(Sales se)throws Exception;
void amountCalAfterSales(int productId,int salesId) throws Exception;
}
