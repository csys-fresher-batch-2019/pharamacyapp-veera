package pharmacyapp.stock1Details;

public interface Stock1DAO {
void addStockDetails(Stock1 s)throws Exception;
void updateClosingStock(Stock1 s) throws Exception;
void updateOpeningStock(int stockId) throws Exception;
}
