package kodlamaio.northwind.business.abstracts;

import java.util.List;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.concretes.dtos.ProductWithCategoryDto;

public interface IProductService {
	DataResult<List<Product>>  getAll();
	DataResult<List<Product>>  getAllSorted();
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	// Tablodaki ilgili kolona göre get komutu veriyor.
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	// And li get komutu. İki kurala da uyması gerekir.
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	//Or olduğu için tek komuta uyması yeterli
	
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
    DataResult<List<Product>> getByProductNameContains(String productName);
	  
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
    
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
