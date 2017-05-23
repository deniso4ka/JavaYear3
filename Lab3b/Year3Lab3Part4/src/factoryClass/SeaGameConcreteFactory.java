package factoryClass;



import gamePieces.Boat;
import gamePieces.DamageItem;
import gamePieces.SeaMine;
import gamePieces.Submarine;
import gamePieces.Vehicle;


public class SeaGameConcreteFactory extends BattleGameAbstractFactory{

	@Override
	public DamageItem getDamageItem() {
		// TODO Auto-generated method stub
		return new SeaMine();
			
	}

	@Override
	public Vehicle getBattleVehicle() {
		// TODO Auto-generated method stub
		return new Boat();
		
	}
	


	@Override
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Submarine();
	}

	
	
}