package factoryClass;

import gamePieces.DamageItem;
import gamePieces.Vehicle;
import gamePieces.WaterVehicle;


public abstract class BattleGameAbstractFactory {

	public abstract DamageItem getDamageItem();
	
	public abstract Vehicle getBattleVehicle();
	
	public abstract Vehicle getVehicle();


	
	
	
	


}
