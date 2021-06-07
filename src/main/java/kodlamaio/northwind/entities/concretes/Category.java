package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitilializer", "handler","products"})
//Benim verdiğim kadarını incele, diplere inme.
public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category") //Şuan kategorilerden ürünlere gidiyoruz.
	//Ana tablodan gidiyoruz. Şuan ana tablodayız. 
	//Bire bir ilişkilendirme yapmamız gerekseydi oneToOne yapmamız gerekirdi.
	//products ta olsaydık manyToOne ilişkilendirmesi yapmamız gerekirdi.
	private List<Product> products;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
