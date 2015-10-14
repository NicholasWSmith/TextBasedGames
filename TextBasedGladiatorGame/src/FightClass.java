import java.util.Scanner;
import java.lang.Math;
public class FightClass {
	int bossHealth;
	int maxHealth;
	int currentHealth;
	int strength;
	int dexterity;
	int magic;
	int currentMana;
	int actionPoints = 3;
	int healthPot;
	int manaPot;
	int gold;
	int goldDrop = bossHealth;
	int level = 1;
	int highScore=0;
	String action;
	Scanner input = new Scanner(System.in);
	
	/**
	 * Desc: Constructor. Takes in variable from other classes and  assigns new names to them.
	 * Pre: Passes in bossHp, maxHp, str, dex, magic1, healthPot1, manaPot1, gold1.
	 * Post: .
	 */
	
	public FightClass(int bossHP, int maxHP, int str, int dex, int mp, int healthPot1, int manaPot1, int gold1) {
		bossHealth = bossHP;
		maxHealth = maxHP;
		strength = str;
		dexterity = dex;
		magic = mp;
		healthPot = healthPot1;
		manaPot = manaPot1;
		gold = gold1;
		
		//multiplies boss's health by the difficulty level to scale difficulty properly
		bossHealth = bossHealth * level;
		
		currentMana = magic;
		currentHealth = maxHealth;
		playerFight();
	}
	
	
	/**
	 * Desc: Asks player what they want to do, playerFight() calls a method based on user's input
	 * Pre: N/A
	 * Post: Calls a method based on use's input if certain conditions are met
	 */
	
	public void playerFight(){
		System.out.println("What would you like to do? Attack, or use health potion or mana potion?");
		action = input.nextLine();
		
		if (action.equals("attack")) {
			action = "";
			System.out.println("What would you like to attack with? sword, bow, or magic?");
			action = input.nextLine();
			
				if (action.equals("sword") && (actionPoints >= 2)) {
					swordFight();
				}else if (action.equals("bow") && (actionPoints >= 1)) {
					bowFight();
				}else if (action.equals("magic") && currentMana >= 20 && (actionPoints >= 2)) {
					magicFight();			
				} else {
					System.out.println("Im sorry, that is not a valid command. Please try again.");
					playerFight();
				}
				
			}
		
		if (action.equals("mana potion") && (actionPoints >= 1) && (healthPot >= 1)) {
				useManaPotion();
			}	
		if (action.equals("health potion") && (actionPoints >= 1) && (manaPot >= 1)) {
				useHealthPotion();
		}
	
	}
	
	/**
	 * Desc: A method that is used for close combat, using up 2 action points and damaging the enemy.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	
	public void swordFight(){
		int damageS = (int)((strength/2 + currentHealth - strength/2 + 1) * Math.random() + (strength/2));
		System.out.println("You step forward eagerly, swinging your long sword furiously slashing the monster."); 
		System.out.println("You deal " + damageS + " damage to the enemy!");
		actionPoints =- 2;
		System.out.println("You use 2 of your 3 actions points, leaving with you with " + actionPoints + " action points left.");
		bossHealth =- damageS;
		System.out.println("The boss has " + bossHealth + " health left!");
		
		
		if (bossHealth <= 0) {
			bossDead();
		}else if (actionPoints == 0) {
			System.out.println("You expand all of your action points!! You must wait until your next turn to get them back.");
			System.out.println("While you are tired, the boss takes this time to strike!!");
			bossFight();
		}
		playerFight();
	}
	
	/**
	 * Desc: A method that is used for ranged combat, using up 1 action points and damaging the enemy.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	
	public void bowFight(){
		int damageD = (int)((dexterity/2 + currentHealth - dexterity/2 + 1) * Math.random() + (dexterity/2)) / 2;
		System.out.println("You draw back your bow and shoot an arrow at it's face.");
		System.out.println("You deal " + damageD + " damage!");
		actionPoints =- 1;
		System.out.println("You use 1 of your 3 actions points, leaving with you with " + actionPoints + " action points left.");
		bossHealth =- damageD;
		System.out.println("The boss has " + bossHealth + " health left!");
		
		
		if (bossHealth <= 0) {
			bossDead();
		} else if (actionPoints == 0) {
			System.out.println("You expand all of your action points!! You must wait until your next turn to get them back.");
			System.out.println("While you are tired, the boss takes this time to strike!!");
			bossFight();
		}
		playerFight();
	}
		
	/**
	 * Desc: A method that is used for magic combat, using up 2 action points and damaging the enemy.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	
	public void magicFight(){
		int damageM = (int)((magic/2 + currentHealth - magic/2 + 1) * Math.random() + (magic/2));
		currentMana =- 20;	
		System.out.println("You raise your staff in defiance, and unleash a furious ball of power.");
		System.out.println("You deal " + damageM + " damage, and spend 20 points of mana leaving you with " + currentMana + " mana left.");
		actionPoints =- 2;
		System.out.println("You use 2 of your 3 actions points, leaving with you with " + actionPoints + " left.");
		bossHealth =- damageM;
		System.out.println("The boss has " + bossHealth + " health left!");
		
		
		if (bossHealth <= 0) {
			bossHealth = 0;
			bossDead();
		}else if (actionPoints == 0) {
			System.out.println("You expand all of your action points!! You must wait until your next turn to get them back.");
			System.out.println("While you are tired, the boss takes this time to strike.");
			bossFight();
		}
		playerFight();
	}
	
	/**
	 * Desc: A method that is used for healthPotions.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	
	public void useHealthPotion(){
		
		currentHealth = currentHealth + (maxHealth / 4);
		//An if statement that checks if the potion overhealed.
		if (currentHealth > maxHealth) {
				currentHealth = maxHealth;
		}
		healthPot--;
		System.out.println("You use a health potion, which restores you to " + currentHealth + " health and leaving you with " + healthPot + " health potions.");
		actionPoints--;
		System.out.println("You use 1 action point, leaving you with " + actionPoints + " actionPoints.");	
		playerFight();
	}
	
	/**
	 * Method
	 * Pre: N/A
	 * Post: N/A
	 */
	
	public void useManaPotion(){
		currentMana = currentMana + (magic / 4);
		//An if statement that checks if the potion overhealed.
		if (currentMana > magic) {
			currentMana = magic;
		}
		manaPot--;
		System.out.println("You use a mana potion, which restores you to " + currentMana + " mana and leaving you with " + manaPot + " mana potions.");
		actionPoints--;
		System.out.println("You use 1 action point, leaving you with " + actionPoints + " actionPoints.");
		playerFight();
	}
	
	/**
	 * Desc: A method that is used for the the bosses damage against the character,.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	
	public void bossFight() {
		//A random number between 100 and 1 that is used for dodge chance.
		int dodgeChance = (int)((100 - 1 + 1) * Math.random() + (1));
		int bossDamage = (int)((bossHealth / 2 - maxHealth/10 + 1) * Math.random() + (maxHealth / 10));
		System.out.println("The moster raises its fist, and attacks you.");
		//An if statement that checks if the player dodged or not.
		if (dodgeChance <= (dexterity / 10)) {
			System.out.println("You dodge the monsters powerful attack. It is now your turn.");
			actionPoints = 3;
			playerFight();
		} else {
			System.out.println("The monster pummles you into the ground, dealing " + bossDamage + " danage.");
			maxHealth = maxHealth - bossDamage;
			System.out.println("You currently have " + maxHealth + " health left! Be careful!");
			actionPoints = 3;
			if (currentHealth <= 0 ) {
				dead();
			}
			playerFight();
		}
	}
	
	/**
	 * Desc: A method that is used for when the boss is kiled.
	 * Pre: N/A.
	 * Post: N/A.
	 */
	public void bossDead() {
		System.out.println("As you finish your final attack, the boss drops in a heap of blood. You have killed the vile monster!");
		gold = gold + goldDrop;
		
		System.out.println("The boss drops " + goldDrop + " gold, which now brings you to " + gold + " gold which can be used at the shop.");
		System.out.println("Would you like to go to the shop? Or kill the next creature of hell?");
		action = input.nextLine();
		level++;
		//The highscore is how much health you have left after each fight after 5 fights. Once you die, or reach level 5 that is your score.
		highScore =+ currentHealth;
		//At the end of the game, the amount of gold you have left over will be the multiplyer.
		if (level == 5) {
			highScore = highScore * gold;
		}
		if (action.equals("shop")) {	
			testGladiatorQuest.shop(gold, maxHealth, magic, strength, dexterity);
		}

	}
	
	public void dead() {
			System.out.print("The beast has defeated you. You loose");
		}
	
}

