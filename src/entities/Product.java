package entities;

public abstract class Product {
	
	 private int articleNumber;
     private String name;
     private String description;
     private int price;
     
	public Product(int articleNumber, String name, String description, int price) {
	
		this.articleNumber = articleNumber;
		this.name = name;
		this.description = description;
		this.price = price;
	}
     
     
    public void listInfo()                                                                                  // Generic information for a Item
    {
        System.out.println("Nr: " + articleNumber + "," + name + "," + "Price: " + price + "kr");
    }

    public abstract void examine();


    public abstract void useItem();


	public int getArticleNumber() {
		return articleNumber;
	}


	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
     
     
     

}
