package zoo;


public class Zoo {

  private static final int currentMax = 6;
  private static Animal[] animalList = new Animal[currentMax];

  public static void main(String[] args) {
    Animal theo = new Tiger(300);
    Animal kirsty = new Elephant(3000);
    Animal tiny = new Giraffe(2000);
    Animal stilt = new Giraffe(1500);
    Animal loppy = new LizardAdapter(50);
    Animal snappy = new AlligatorAdapter(500);

    animalList[0] = theo;
    animalList[1] = kirsty;
    animalList[2] = tiny;
    animalList[3] = stilt;
    animalList[4] = loppy;
    animalList[5] = snappy;

    for(int i = 0; i < animalList.length; i++) {
      animalList[i].feed();
    }

  }


}