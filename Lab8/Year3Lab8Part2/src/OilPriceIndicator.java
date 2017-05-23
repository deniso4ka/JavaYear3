import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class OilPriceIndicator extends JFrame implements Runnable, Subject {
	
	private JLabel label = new JLabel();
	private boolean turnOn=true;
	private double price = 1.3;
	private double increaseAmmount = 0.1;
	private String display=" Price for oil is  " + price + " Euro";
	private Vector<Observer> obsserverList = new Vector<Observer>();
	BritishOilPrice britishOil = new BritishOilPrice();
	JapanOilPrice japanOil = new JapanOilPrice();
	
	
	
	public OilPriceIndicator() {
		
		add(label);
		setVisible(true);
		setSize(300,300);
		//validate();
		//label.setText(display);
	
		
	}

	@Override
	public void run() {
		
		// TODO Auto-generated method stub
		while(turnOn){
			price = price + increaseAmmount;
			try {
				Thread.sleep(1000);
				display = " Price for oil is  " + price + " Euro";
				revalidate();
				label.setText(display);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	@Override
	public void registerInterest(Observer observer) {
		// TODO Auto-generated method stub
		//label.setText(display);
		
	britishOil.sendNotify(price);
	japanOil.sendNotify(price);
		
	obsserverList.addElement(britishOil);
	obsserverList.addElement(japanOil);
		
		
		
		
	}

}
