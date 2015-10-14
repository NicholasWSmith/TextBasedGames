
public class Inventory {

	private int gold;
	private int HPpotions;
	private int MPpotions;
	
	public Inventory(int gp) {
		gold = gp;
	}
	
	public void setHP(int numHp) {
		HPpotions = HPpotions + numHp;
		System.out.println("You have succesfully bought a health potion! You currently have " + HPpotions + ". They heal for 25% of your health.");
		gold = gold - numHp*75;
		System.out.println("You spent" + numHp*75 + "gold, and you have " + gold + " left over");
	}	
	
	public int getHP1() {
		return(HPpotions);
	}
	
	public void setMP(int numMp) {
		MPpotions++;
		System.out.println("You have succesfully bought a mana potion! You currently have " + MPpotions + ". They will restore 25% of your mana.");
		gold = gold - numMp*75;
		System.out.println("You spent" + numMp*75 + "gold, and you have " + gold + " left over");
	}
	
	public int getMP1() {
		return(MPpotions);
	}
	
}
