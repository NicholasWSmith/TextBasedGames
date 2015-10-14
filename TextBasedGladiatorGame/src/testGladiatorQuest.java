import java.util.Scanner;


public class testGladiatorQuest {

	
	public static void main(String[] args) {
		int level = 1;
		int healthPot = 1;
		int manaPot = 1;
		int health = 0;
		int magic = 0;
		int strength = 0;
		int dexterity = 0;
		int gold = 0;
		String temp;
		System.out.println("GLADIATOR QUEST");
		System.out.println("You will embark on a harrowing jounrney throughout five unique arean challenges.");
		
		allocateStats(health, magic, strength, dexterity);
		
		Scanner input = new Scanner(System.in);
		System.out.println("What do you want to do next? fight or shop?");
		temp = input.nextLine();
		
		if(temp.equals("fight") && (level == 1)){
			level++;
			FightClass boss1 = new FightClass(250, health, strength, dexterity, magic, manaPot, healthPot, gold);
			System.out.println("You see a bear in the corner, it bares it's teeth at you and charges.");
			boss1.playerFight();
		}
		if(input.equals("fight") && level == 2){
			level++;
			FightClass boss2 = new FightClass(500, health, strength, dexterity, magic, manaPot, healthPot, gold);
			System.out.println("A giant skorpion stares at you from across the arean. It snaps it's pincers and scuttles forward.");
			boss2.playerFight();	
		}
		if(input.equals("fight") && level == 3){
			level++;
			FightClass boss3 = new FightClass(1000, health, strength, dexterity, magic, manaPot, healthPot, gold);
			System.out.println("A giant crocodile emerges from a pool in the centre of the arena. It lunges forward!");
			boss3.playerFight();
		}
		if(input.equals("fight") && level == 4){
			level++;
			FightClass boss4 = new FightClass(1500, health, strength, dexterity, magic, manaPot, healthPot, gold);
			System.out.println("You see a hideous troll stares you down as you enter the arena. It smashes it's club on the ground an roars.");
			boss4.playerFight();
		}
		if(input.equals("fight") && level == 5){
			level++;
			FightClass boss5 = new FightClass(3000, health, strength, dexterity, magic, manaPot, healthPot, gold);
			System.out.println("You look up and see a large dragon overhead. It lets out a roar and moves in for the attack.");
			boss5.playerFight();
		}
		if(input.equals("shop")){
			shop(gold, health, magic, strength, dexterity);
		}
	}
	
	public static void shop(int gold, int health, int magic, int strength, int dexterity){
		System.out.println("Welcome to the store." + "\t");
		System.out.println("Potions cost 75 each, Stat Points cost 10." + "\t");
		System.out.println("What would you like to buy? The options are:" + "\t");
		System.out.println("Health Potion" + "\t");
		System.out.println("Magic Potion" + "\t");
		System.out.println("Health Point" + "\t");
		System.out.println("Magic Point" + "\t");
		System.out.println("Strength Point" + "\t");
		System.out.println("Dexterity Point" + "\t");
		System.out.println("Aternatively, type 'done' to leave.");
		String action;
		int num;
		
		Inventory playerInventory = new Inventory(gold);
		
		Scanner input = new Scanner(System.in);
		action = input.nextLine();
		
		if (action.equals("Healh Potion")){
			System.out.println("How many would you like?");
			num = input.nextInt();
			playerInventory.setHP(num);
			}
		if (action.equals("Magic Potion")){
			System.out.println("How many would you like?");
			num = input.nextInt();
			playerInventory.setMP(num);
			}
		if (action.equals("Health Point")){
				health = health + 10;
				gold = gold - 10;
		}	
		
		if (action.equals("done")){
				
			}
		}

	
	public static void allocateStats(int health, int magic, int  strength, int dexterity){
		
		ActorCreation character = new ActorCreation(health, magic, strength, dexterity);
		System.out.println("Set you characters stats:");
		character.inputHealth();
		character.inputMagic();
		character.inputStrength();
		character.inputDexterity();
		
		System.out.println("Your characters stats:");
		System.out.println("Health: " + character.getHealth());
		System.out.println("Magic: " + character.getMagic());
		System.out.println("Strength: " + character.getStrength());
		System.out.println("Dexterity: " + character.getDexterity());
	}
	
	

}
