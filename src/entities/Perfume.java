package entities;

public class Perfume extends Product {

	private int volume;
	
	public Perfume(int articleNumber, String name, String description, int price, int volume) {
		
		super(articleNumber, name, description, price);
		this.volume = volume;
	}
	@Override
    public void examine()                                                                          // Detailed information for a Perfume      
    {
    	 System.out.println("Product: " + getName() + "\nPrice: " + getPrice() + "kr" + "\nInfo: " + getDescription() + "\nVol: " + volume + "ml");
    }
	@Override
    public void useItem()                                                                          // Message simulating use of a Perfume
    {
    	System.out.println("You have sprayed your " + this.getName() + " on!");
    }

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
}
