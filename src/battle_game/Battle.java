package battlegame;

public class Battle {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		// 敵モンスターを選択させる（★課題：敵モンスターを編集するときにいちいちコード修正が必要なのが面倒になりそう。MonsterChoiceクラスを作成する？）
		System.out.println("--------------------------------------------");
		System.out.println("| 初期設定");
		System.out.println("--------------------------------------------");
		System.out.println("| 敵モンスターを選択してください：");
		System.out.println("| 1. スライム");
		System.out.println("| 2. ゴーレム");
		System.out.println("| 3. はぐれメタル");
		System.out.println("--------------------------------------------\n");
		System.out.println("入力⇒");

		//入力値を格納
		int choice = scanner.nextInt();
		System.out.println("\n");

		//Monsterクラスからインスタンス生成
		Monster enemyMonster = new Monster(choice);
		//Heroクラスからインスタンス生成
		Hero hero = new Hero("勇者", 100, 20, 30);

		System.out.println(enemyMonster.getName() + "があらわれた！\n");

		// バトルループ
		while (hero.isAlive() && enemyMonster.isAlive()) {

			do {
				//勇者のステータス表示
				System.out.println("--------------------------------------------");
				System.out.println("| " + hero.getName());
				System.out.println("| HP " + hero.getHealth());
				System.out.println("| MP " + hero.getMP());
				System.out.println("--------------------------------------------");

				//敵モンスターのステータス表示
				System.out.println("--------------------------------------------");
				System.out.println("| " + enemyMonster.getName());
				System.out.println("| HP " + enemyMonster.getHealth());
				System.out.println("| MP 0");
				System.out.println("--------------------------------------------\n");

				// 勇者のターン
				System.out.println(hero.getName() + "のターン");
				System.out.println("1. 物理攻撃");
				System.out.println("2. 魔法攻撃\n");
				System.out.print("コマンド入力⇒");
				String playerChoice = scanner.nextLine();
				System.out.print("\n");

				//checkStringメソッドを呼び出して、入力コマンドに文字列が含まれていないかチェックする
				boolean commandResult = checkString(playerChoice);

				if (commandResult) {
					//文字列のコマンドをint型に変換する
					int executionCommand = Integer.parseInt(playerChoice);

					if (executionCommand == 1) {
						hero.physicalAttack(enemyMonster);
						System.out.print(hero.getName() + "の物理攻撃");
						System.out.println(enemyMonster.getName() + "に" + hero.getAttackDamage() + "のダメージ！\n");
						break;
					} else if (executionCommand == 2) {
						hero.magicAttack(enemyMonster);
						System.out.print(hero.getName() + "の魔法攻撃");
						System.out.println(enemyMonster.getName() + "に" + (2 * hero.getAttackDamage()) + "のダメージ！\n");
						break;
					} else {
						System.out.println("入力コマンドが誤っています。再度入力してください。\n");
					}
				} else {
					System.out.println("入力コマンドが誤っています。再度入力してください。\n");
				}

			} while (true);

			if (!enemyMonster.isAlive()) {
				System.out.println(enemyMonster.getName() + "を倒した！");
				break;
			}

			// 敵のターン
			System.out.println(enemyMonster.getName() + "のターン");
			enemyMonster.attack(hero);
			System.out.println(hero.getName() + enemyMonster.getAttackDamage() + "のダメージ！\n");

			if (!hero.isAlive()) {
				System.out.println(hero.getName() + "は死んでしまった・・・");
				break;
			}

		}
		scanner.close();
		System.out.println("バトル終了！");
	}

	//入力されたコマンドに文字列が含まれていないかチェックする（文字列なし：true、文字列あり：falseを返す）
	public static boolean checkString(String command) {
		boolean checkStringRes = true;

		//受け取った文字列を先頭から1文字ずつチェックする
		for (int i = 0; i < command.length(); i++) {
			//もし数値だったら次の処理へ
			if (Character.isDigit(command.charAt(i))) {
				continue;
			} else {
				//変数にfalseを代入して処理を終了する
				checkStringRes = false;
				break;
			}
		}
		return checkStringRes;
	}
}
