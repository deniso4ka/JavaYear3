
public class InternationalOilMarket {
	
	OilPriceIndicator internationalOilPrice = new OilPriceIndicator();
	JapanOilPrice japaneseOilPrice = new JapanOilPrice();
	BritishOilPrice britishOilPrice = new BritishOilPrice();
	
	public InternationalOilMarket(){
		
		internationalOilPrice.registerInterest(japaneseOilPrice);
		internationalOilPrice.registerInterest(britishOilPrice);
		japaneseOilPrice.setLocation(0, 350);
		britishOilPrice.setLocation(0,700);
		new Thread(japaneseOilPrice).start();
		new Thread(britishOilPrice).start();
		new Thread(internationalOilPrice).start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InternationalOilMarket runapp = new InternationalOilMarket();
		

	}

}
