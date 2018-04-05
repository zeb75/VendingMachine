package entities;

public class Snack extends Product {
	
	private int weight;

	public Snack(int articleNumber, String name, String description, int price, int weight) {
		
		super(articleNumber, name, description, price);
		this.weight = weight;
	}
	
	@Override
    public void examine()                                                                          // Detailed information for a Snack
    {
    	 System.out.println("Product: " + getName() + "\nPrice: " + getPrice() + "kr" + "\nInfo: " + getDescription() + "\nWeight: " + weight + "g");
    }
	@Override
    public void useItem()                                                                          // Message simulating use of a Snack
    {
        System.out.println("You have eaten your " + this.getName());
    }


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}

}
