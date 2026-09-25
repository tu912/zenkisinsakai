package sifutokanriwa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Staff> staffList = new ArrayList<>();
		ArrayList<Shift> shiftList = new ArrayList<>();
		// 
		ArrayList<Store> storeList = new ArrayList<>();
		staffList.add(new Staff(
				1, "田中", "tanaka@example.com", "1234", "スタッフ"));
		staffList.add(new Staff(
				2, "佐藤", "sato@example.com", "2345", "スタッフ"));
		// 店長 IDと名前はない
		staffList.add(new Staff(
				3, "", "manager@example.com", "5678", "店長"));

		// シフト登録
		shiftList.add(new Shift(
				1, 1, "2026/09/20", "09:00", "13:00", 1, "通常"));

		shiftList.add(new Shift(
				2, 2, "2026/09/21", "13:00", "17:00", 1, "通常"));

		// 店舗登録
		storeList.add(new Store(
				1, "〇〇店", "東京都〇〇区"));

		// システム
		while (true) {

			System.out.println();
			System.out.println("=== シフト管理システム ===");
			System.out.println("1. スタッフログイン");
			System.out.println("2. 店長ログイン");
			System.out.println("3. 終了");
			System.out.print("番号を入力してください：");

			int menu = scanner.nextInt();
			scanner.nextLine();

			// switch文
			switch (menu) {

			case 1:
				// スタッフログイン
				System.out.println();
				System.out.println("=== スタッフログイン ===");

				System.out.print("スタッフID：");
				int loginID = scanner.nextInt();
				scanner.nextLine();

				System.out.print("パスワード：");
				String loginPassword = scanner.nextLine();

				Staff loginStaff = null;
				for (Staff staff : staffList) {
					if (staff.stafID == loginID
							&& staff.password.equals(loginPassword)
							&& staff.roru.equals("スタッフ")) {

						loginStaff = staff;
						break;
					}
				}

				if (loginStaff == null) {

					System.out.println(
							"スタッフIDまたはパスワードが違います。");
					break;
				}

				System.out.println();
				System.out.println(
						loginStaff.name + "さん、ログインしました。");
				// スタッフメニュー
				while (true) {
					System.out.println();
					System.out.println("=== スタッフメニュー ===");
					System.out.println("1. スタッフ情報");
					System.out.println("2. 自分のシフト確認");
					System.out.println("3. シフト詳細確認");
					System.out.println("4. ログアウト");
					System.out.print("番号を入力してください：");

					int staffMenu = scanner.nextInt();
					scanner.nextLine();

					// switch文
					switch (staffMenu) {

					case 1:
						// スタッフ情報
						System.out.println();
						System.out.println("=== スタッフ情報 ===");

						loginStaff.displayInfo();
						break;

					case 2:
						// 自分のシフト確認
						System.out.println();
						System.out.println("=== 自分のシフト ===");

						boolean myShiftFound = false;

						for (Shift shift : shiftList) {

							if (shift.stafID == loginStaff.stafID) {

								shift.displayShift();
								System.out.println(
										"状態;" + shift.jyoutai);
								System.out.println();

								myShiftFound = true;
							}
						}

						if (myShiftFound == false) {

							System.out.println(
									"シフトはありません。");
						}
						break;

					case 3:
						// シフト詳細確認
						System.out.println();
						System.out.println("=== シフト詳細 ===");

						boolean detailFound = false;

						for (Shift shift : shiftList) {

							if (shift.stafID == loginStaff.stafID) {

								shift.displayShift();

								System.out.println(
										"店舗ID;" + shift.storeID);

								System.out.println(
										"状態;" + shift.jyoutai);

								System.out.println();

								detailFound = true;
							}
						}

						if (detailFound == false) {

							System.out.println(
									"シフトはありません。");
						}
						break;

					case 4:
						// ログアウト
						System.out.println(
								"ログアウトしました。");
						break;

					default:
						System.out.println(
								"1〜4を入力してください。");
					}

					if (staffMenu == 4) {
						break;
					}
				}
				break;

			case 2:
				System.out.println();
				System.out.println("=== 店長ログイン ===");

				System.out.print("パスワード：");
				String managerPassword = scanner.nextLine();

				Staff loginManager = null;
				// 
				for (Staff staff : staffList) {
					if (staff.password.equals(managerPassword)
							&& staff.roru.equals("店長")) {
						loginManager = staff;
						break;
					}
				}
				if (loginManager == null) {
					System.out.println(
							"パスワードが違います。");
					break;
				}
				System.out.println();
				System.out.println(
						"店長、ログインしました。");

				// 店長メニュー
				while (true) {

					System.out.println();
					System.out.println("=== 店長メニュー ===");
					System.out.println("1. スタッフ情報");
					System.out.println("2. スタッフ追加");
					System.out.println("3. シフト追加");
					System.out.println("4. シフト変更");
					System.out.println("5. シフト削除");
					System.out.println("6. スタッフ検索");
					System.out.println("7. スタッフ削除");
					System.out.println("8. 店舗情報");
					System.out.println("9. ログアウト");
					System.out.print("番号を入力してください：");

					int managerMenu = scanner.nextInt();
					scanner.nextLine();

					// 店長メニューのswitch文
					switch (managerMenu) {

					case 1:
						// スタッフ情報
						System.out.println();
						System.out.println("=== スタッフ情報 ===");

						for (Staff staff : staffList) {

							// 店長は表示しない
							if (staff.roru.equals("スタッフ")) {

								staff.displayInfo();
								System.out.println();
							}
						}
						break;

					case 2:
						// スタッフ追加
						System.out.println();
						System.out.println("=== スタッフ追加 ===");

						System.out.print("スタッフID：");
						int newStaffID = scanner.nextInt();
						scanner.nextLine();

						// 同じIDがあるか確認
						boolean sameID = false;

						for (Staff staff : staffList) {

							if (staff.stafID == newStaffID) {

								sameID = true;
								break;
							}
						}

						if (sameID == true) {

							System.out.println(
									"そのスタッフIDはすでに使われています。");
							break;
						}

						System.out.print("名前：");
						String newName = scanner.nextLine();

						System.out.print("メールアドレス：");
						String newEmail = scanner.nextLine();

						System.out.print("パスワード：");
						String newPassword = scanner.nextLine();

						Staff newStaff = new Staff(
								newStaffID,
								newName,
								newEmail,
								newPassword,
								"スタッフ");

						staffList.add(newStaff);

						System.out.println();
						System.out.println(
								"スタッフを追加しました。");

						newStaff.displayInfo();
						break;

					case 3:
						// シフト追加
						System.out.println();
						System.out.println("=== シフト追加 ===");

						System.out.print(
								"シフトを追加するスタッフID：");
						int addStaffID = scanner.nextInt();
						scanner.nextLine();

						boolean addStaffFound = false;

						for (Staff staff : staffList) {

							if (staff.stafID == addStaffID
									&& staff.roru.equals("スタッフ")) {

								System.out.println(
										"スタッフ名：" + staff.name);

								addStaffFound = true;
								break;
							}
						}

						if (addStaffFound == false) {

							System.out.println(
									"スタッフが見つかりません。");
							break;
						}

						System.out.print("シフトID：");
						int addShiftID = scanner.nextInt();
						scanner.nextLine();

						System.out.print(
								"勤務日（例 2026/09/25）：");
						String addDate = scanner.nextLine();

						System.out.print(
								"開始時間（例 09:00）：");
						String addStart = scanner.nextLine();

						System.out.print(
								"終了時間（例 13:00）：");
						String addEnd = scanner.nextLine();

						System.out.print("店舗ID：");
						int addStoreID = scanner.nextInt();
						scanner.nextLine();

						Shift newShift = new Shift(
								addShiftID,
								addStaffID,
								addDate,
								addStart,
								addEnd,
								addStoreID,
								"通常");

						shiftList.add(newShift);

						System.out.println();
						System.out.println(
								"シフトを追加しました。");

						newShift.displayShift();
						break;

					case 4:
						// シフト変更
						System.out.println();
						System.out.println("=== シフト変更 ===");

						System.out.print(
								"変更するシフトID：");
						int changeShiftID = scanner.nextInt();
						scanner.nextLine();

						boolean changeFound = false;

						for (Shift shift : shiftList) {

							if (shift.shiftID == changeShiftID) {

								System.out.println();
								System.out.println(
										"=== 変更前のシフト ===");

								shift.displayShift();

								System.out.print(
										"新しい勤務日：");
								shift.sigotobi = scanner.nextLine();

								System.out.print(
										"新しい開始時間：");
								shift.hajimaritime = scanner.nextLine();

								System.out.print(
										"新しい終了時間：");
								shift.syuuryoutime = scanner.nextLine();

								shift.jyoutai = "変更あり";

								System.out.println();
								System.out.println(
										"シフトを変更しました。");

								System.out.println(
										"=== 変更後のシフト ===");

								shift.displayShift();

								System.out.println(
										"状態;" + shift.jyoutai);

								changeFound = true;
								break;
							}
						}

						if (changeFound == false) {

							System.out.println(
									"シフトが見つかりません。");
						}
						break;

					case 5:
						// シフト削除
						System.out.println();
						System.out.println("=== シフト削除 ===");

						System.out.print(
								"削除するスタッフID：");
						int deleteStaffID = scanner.nextInt();
						scanner.nextLine();

						System.out.print(
								"削除する勤務日（例 2026/09/20）：");
						String deleteDate = scanner.nextLine();

						Shift deleteShift = null;

						for (Shift shift : shiftList) {

							if (shift.stafID == deleteStaffID
									&& shift.sigotobi.equals(deleteDate)) {

								deleteShift = shift;
								break;
							}
						}

						if (deleteShift != null) {

							System.out.println();
							System.out.println(
									"=== 削除するシフト ===");

							deleteShift.displayShift();

							System.out.println("1. 削除する");
							System.out.println("2. キャンセル");
							System.out.print(
									"番号を入力してください：");

							int deleteMenu = scanner.nextInt();
							scanner.nextLine();

							if (deleteMenu == 1) {

								shiftList.remove(deleteShift);

								System.out.println(
										"シフトを削除しました。");

							} else {

								System.out.println(
										"削除をキャンセルしました。");
							}

						} else {

							System.out.println(
									"指定したスタッフ・勤務日のシフトが見つかりません。");
						}
						break;

					case 6:
						// スタッフ検索
						System.out.println();
						System.out.println("=== スタッフ検索 ===");

						System.out.print(
								"検索するスタッフID：");
						int searchStaffID = scanner.nextInt();
						scanner.nextLine();

						boolean staffFound = false;

						for (Staff staff : staffList) {

							if (staff.stafID == searchStaffID
									&& staff.roru.equals("スタッフ")) {

								System.out.println();
								System.out.println(
										"スタッフが見つかりました。");

								staff.displayInfo();

								staffFound = true;
								break;
							}
						}

						if (staffFound == false) {

							System.out.println(
									"スタッフが見つかりません。");
						}
						break;

					case 7:
						// スタッフ削除
						System.out.println();
						System.out.println("=== スタッフ削除 ===");

						System.out.print(
								"削除するスタッフID：");
						int removeStaffID = scanner.nextInt();
						scanner.nextLine();

						Staff removeStaff = null;

						for (Staff staff : staffList) {

							if (staff.stafID == removeStaffID
									&& staff.roru.equals("スタッフ")) {

								removeStaff = staff;
								break;
							}
						}

						if (removeStaff == null) {

							System.out.println(
									"スタッフが見つかりません。");

						} else {

							System.out.println();
							System.out.println(
									"=== 削除するスタッフ ===");

							removeStaff.displayInfo();

							System.out.println("1. 削除する");
							System.out.println("2. キャンセル");
							System.out.print(
									"番号を入力してください：");

							int removeMenu = scanner.nextInt();
							scanner.nextLine();

							if (removeMenu == 1) {

								staffList.remove(removeStaff);

								// スタッフのシフトも削除
								for (int i = shiftList.size() - 1; i >= 0; i--) {

									if (shiftList.get(i).stafID == removeStaffID) {

										shiftList.remove(i);
									}
								}

								System.out.println(
										"スタッフを削除しました。");

							} else {

								System.out.println(
										"削除をキャンセルしました。");
							}
						}
						break;

					case 8:
						// 店舗情報
						System.out.println();
						System.out.println("=== 店舗情報 ===");

						for (Store store : storeList) {

							store.displayStore();
							System.out.println();
						}
						break;

					case 9:
						// ログアウト
						System.out.println(
								"ログアウトしました。");
						break;

					default:
						System.out.println(
								"1〜9を入力してください。");
					}
					if (managerMenu == 9) {
						break;
					}
				}
				break;
			case 3:
				// 終了
				System.out.println(
						"システムを終了します。");

				scanner.close();
				return;

			default:
				System.out.println(
						"1〜3を入力してください。");
			}
		}
	}
}