package battlegame;

public class Monster {

	private String name;
	private int health;
	private int attackDamage;

	public Monster(int choice) {
		switch (choice) {
		case 1:
			name = "スライム";
			health = 30;
			attackDamage = 10;
			break;
		case 2:
			name = "ゴーレム";
			health = 700;
			attackDamage = 20;
			break;
		case 3:
			name = "はぐれメタル";
			health = 20;
			attackDamage = 50;
			break;
		default:
			System.out.println("無効な選択です。デフォルトでスライムを選択します。");
			name = "スライム";
			health = 30;
			attackDamage = 10;
		}
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void takeDamage(int damage) {
		health -= damage;
		if (health < 0) {
			health = 0;
		}
	}

	public void attack(Hero target) {
		target.takeDamage(attackDamage);
	}

	public boolean isAlive() {
		return health > 0;
	}

}
