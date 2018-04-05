package entities;

public class Drink extends Product {

	private int volume;

	public Drink(int articleNumber, String name, String description, int price, int volume) {
		
		super(articleNumber, name, description, price);
		this.volume = volume;
	}
	@Override
    public void examine()                                                                          // Detailed information for a Drink
    {
        System.out.println("\nProduct: " + getName() + "\nPrice: " + getPrice() + "kr" + "\nInfo: " + getDescription() + "\nVol: " + volume + "cl");
    }
	@Override
    public void useItem()                                                                          // Message simulating use of a Drink
    {
    	System.out.println("You finished your " + this.getName() + "!");
    }

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
		
	}
