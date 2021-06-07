package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.concretes.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product,Integer> {
	
	Product getByProductName(String productName);
	// Tablodaki ilgili kolona göre get komutu veriyor.
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	// And li get komutu. İki kurala da uyması gerekir.
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	//Or olduğu için tek komuta uyması yeterli
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	//Veritabanı product mış gibi davranıyoruz
	// :,?,@ gibi şeyler görürsek parametre demektir.
	//Veritablosunu unut
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	//List of ların şeysi
	//1)select * from product where product_name = abc --> ismi abc olan ürünleri getirir (sql kodu)
	//2)select * from product where product_name and category_id = abc and 2 --> ismi abc olan ve category id si 2 olan ürünleri getirir (sql kodu)
	//3)select * from product where product_name or category_id = abc --> ismi abc olan veya category id si 2 olan ürünleri getirir (sql kodu)
	//4)select * from product where category_id in (1,2,3,4) ( category ıd si 1 2 3 4 olanarı getirir (sql kodu)
	//5) select*from products where productName=birşey and categoryId=birşey
	
	@Query("Select new kodlamaio.northwind.entities.concretes.dtos.ProductWithCategoryDto"
	  		+ "(p.id, p.productName, c.categoryName) "
	  		+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();//Sadece bazı anları getirir. Select kodudur.
	
	
	//select p.productId, p.productName, c.categoryName from Category c inner join Product p
	//on c.categoryId = p.categoryId
}
