import javax.swing.JFrame;
import javax.swing.JLabel;


public class JapanOilPrice extends JFrame implements Runnable, Observer {

	private JLabel label = new JLabel();
	private double extraPrice = 20;
	private double japanOilPrice;
	private String displayPrice = " British Oil Price " + japanOilPrice + " euro ";
	
	@Override
	public double sendNotify(double oilPrice) {
		// TODO Auto-generated method stub
		japanOilPrice = oilPrice + extraPrice;
		
		return japanOilPrice;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		add(label);
		setVisible(true);
		setSize(200,200);
		label.setText(displayPrice);
	}

}
