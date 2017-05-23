import javax.swing.JFrame;
import javax.swing.JLabel;


public class BritishOilPrice  extends JFrame implements Runnable, Observer{
	
	private JLabel label = new JLabel();
	private double extraPrice = 10;
	private double britishOilPrice;
	private boolean displayForever = true;
	private String displayPrice = " British Oil Price " + britishOilPrice + " euro ";
	@Override
	public double sendNotify(double oilPrice) {
		// TODO Auto-generated method stub
		britishOilPrice = oilPrice + extraPrice;
		return britishOilPrice;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		add(label);
		setVisible(true);
		setSize(200,200);
		label.setText(displayPrice);
		revalidate();
		repaint();
		
		
	
		
	}

}
