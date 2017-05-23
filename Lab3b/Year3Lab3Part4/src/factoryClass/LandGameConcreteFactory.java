package factoryClass;



import gamePieces.Car;
import gamePieces.DamageItem;
import gamePieces.RoadBlock;
import gamePieces.Tank;
import gamePieces.Vehicle;

public class LandGameConcreteFactory extends BattleGameAbstractFactory{

	@Override
	public DamageItem getDamageItem() {
		// TODO Auto-generated method stub
		
		return new RoadBlock();
			
		
	}

	@Override
	public Vehicle getBattleVehicle() {
		// TODO Auto-generated method stub
		return new Tank();
	}
	
	public Vehicle getVehicle() {
		// TODO Auto-generated method stub
		return new Car();
	}
	
	

}
