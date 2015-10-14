import java.util.Scanner;
public class ActorCreation {
	int health;
	int magic;
	int strength;
	int dexterity;
	int stats = 400;
	
	public ActorCreation(int hp, int mp, int str, int dex){
		health = hp;
		magic = mp;
		strength = str;
		dexterity = dex;
	}
	public void setHealth(int hp){
		health = hp;
	}
	
	public void setMagic(int mp){
		magic = mp;
	}
	
	public void setStrength(int str){
		strength = str;
	}
	
	public void setDexterity(int dex){
		dexterity = dex;
	}

	public int getHealth(){
		return(health);
	}
	
	public int getMagic(){
		return(magic);
	}
	
	public int getStrength(){
		return(strength);
	}
	
	public int getDexterity(){
		return(dexterity);
	}
	
	public void inputHealth(){
		Scanner input = new Scanner(System.in);
		System.out.println("Health: ");
		health = input.nextInt();
		if (health <= stats){
			stats = stats - health;
			setHealth(health);
		}else{
			System.out.println("You do not have enough stat points. You have " + stats + ".");
			inputHealth();
		}
	}
	
	public void inputMagic(){
		Scanner input = new Scanner(System.in);
		System.out.println("Magic: ");
		magic = input.nextInt();
		if (magic <= stats){
			stats = stats - magic;
			setHealth(magic);
		}else{
			System.out.println("You do not have enough stat points. You have " + stats + ".");
			inputMagic();
		}
	}
	
	public void inputStrength(){
		Scanner input = new Scanner(System.in);
		System.out.println("Strength: ");
		strength = input.nextInt();
		if (strength <= stats){
			stats = stats - strength;
			setHealth(strength);
		}else{
			System.out.println("You do not have enough stat points. You have " + stats + ".");
			inputStrength();
		}
	}
	
	public void inputDexterity(){
		Scanner input = new Scanner(System.in);
		System.out.println("Dexterity: ");
		dexterity = input.nextInt();
		if (dexterity <= stats){
			stats = stats - dexterity;
			setDexterity(dexterity);
		}else{
			System.out.println("You do not have enough stat points. You have " + stats + ".");
			inputDexterity();
		}
	}
}
