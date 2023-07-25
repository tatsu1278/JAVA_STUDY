package battlegame;

public class Hero {
	private String name;
	private int health;
	private int attackDamage;
	private int MP;

	public Hero(String name, int health, int attackDamage, int maxMP) {
		this.name = name;
		this.health = health;
		this.attackDamage = attackDamage;
		this.MP = maxMP;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getMP() {
		return MP;
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

	public void physicalAttack(Monster target) {
		target.takeDamage(attackDamage);
	}

	public void magicAttack(Monster target) {
		if (MP >= 10) {
			target.takeDamage(2 * attackDamage);
			MP -= 10;
		} else {
			System.out.println("MPが足りないため魔法攻撃できません！デフォルトで物理攻撃を行います。");
		}
	}

	public boolean isAlive() {
		return health > 0;
	}

}
