package kodlamaio.northwind.core.utilities.results;

public class Result { //super type //soyut görevi görüyor bu yüzen extendi veya implementi yok
	private boolean success;
	private String message;
	
	public Result(boolean success) { 
		//bunu ProductsController da return kısmında kullanıyoruz.
		this.success =success;
	}
	public Result(boolean success, String message) { 
		this(success);
		this.message = message;
	}
	public boolean isSuccess() {
		return this.success;
	}
	public String getMessage() {
		return this.message;
	}
}
