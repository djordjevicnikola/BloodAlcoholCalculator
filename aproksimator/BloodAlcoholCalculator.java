package aproksimator;

import java.util.Scanner;

public class BloodAlcoholCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id;
		double alRakija, alVinjak, alPivo, alVino; // % alkohola u picu
		double kolRakija, kolVinjak, kolPivo, kolVino; // kolicina popijenog pica
		double suma = 0, tezina, r, bac;
		int pol;
		System.out.println("Dobrodosli u alko aproksimator 9000!");
		System.out.print("Unesite vasu tezinu(kg): ");
		tezina = sc.nextDouble();
		while (tezina <= 0) {
			System.err.print("Tezina ne sme biti manja od 0. Upisite ponovo: ");
			tezina = sc.nextDouble();
		}
		tezina *= 1000; // pretvaranje kg u g
		System.out.print("Unesite vas pol (ako ste zensko unesite 0, ako ste musko unesite 1): ");
		pol = sc.nextInt();
		while (pol < 0 || pol > 1) {
			System.err.print("Pogresan unos (ako ste zensko unesite 0, ako ste musko unesite 1): ");
			pol = sc.nextInt();
		}
		if (pol == 0) r = 0.68;
		else r = 0.55;
		do {
			System.out.print("Unesite id pica koje ste pili ili -1 ako ste vec uneli sva pica koja ste pili: \n"
					+ "\tRakija ID = 1\n\tVinjak ID = 2\n\tPivo ID = 3\n\tVino ID = 4\nID: ");
			id = sc.nextInt();
			switch (id) {
			case 1:
				System.out.print("Unesite koliko mililitra(ml) rakije ste popili: ");
				kolRakija = sc.nextDouble();
				alRakija = 0.5;
				suma += alRakija * kolRakija;
				break;
			case 2:
				System.out.print("Unesite koliko mililitra(ml) vinjaka ste popili: ");
				kolVinjak = sc.nextDouble();
				alVinjak = 0.4;
				suma += alVinjak * kolVinjak;
				break;
			case 3:
				System.out.print("Unesite koliko mililitra(ml) piva ste popili: ");
				kolPivo = sc.nextDouble();
				alPivo = 0.047;
				suma += alPivo * kolPivo;
				break;
			case 4:
				System.out.print("Unesite koliko mililitra(ml) vina ste popili: ");
				kolVino = sc.nextDouble();
				alVino = 0.11;
				suma += alVino * kolVino;
				break;
			case -1:
				break;
			default:
				System.err.println("Greska, zeljeni ID nije u bazi podataka. Pokusajte ponovo. ");
			}
		} while (id != -1);
		bac = (suma / (tezina * r)) * 1000; // formula za racunanje alkohola u krvi
		kazna(bac);
	}

	public static void kazna(double bac) {
		if (bac <= 0.20) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Dozvoljena alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Bez kazne");
			System.out.println("Kazneni poeni: 0");
			System.out.println("Zabrana: 0 meseci");
		} else if (bac >= 0.21 && bac <= 0.5) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Umerena alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 10.000");
			System.out.println("Kazneni poeni: 0");
			System.out.println("Zabrana: 0 meseci");
		} else if (bac >= 0.51 && bac <= 0.8) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Srednja alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 10.000 - 20.000");
			System.out.println("Kazneni poeni: 6");
			System.out.println("Zabrana: 3 meseci");
		} else if (bac >= 0.81 && bac <= 1.2) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Visoka alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 20.000 - 40.000");
			System.out.println("Kazneni poeni: 8");
			System.out.println("Zabrana: 4 meseci");
		} else if (bac >= 1.21 && bac <= 1.8) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Teska alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 100.000 - 120.000");
			System.out.println("Kazneni poeni: 9");
			System.out.println("Zabrana: 8 meseci");
		} else if (bac >= 1.61 && bac <= 2.0) {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Visoka alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 100.000 - 120.000");
			System.out.println("Kazneni poeni: 14");
			System.out.println("Zabrana: 8 meseci");
		} else {
			System.out.println("--------------------");
			System.out.printf("BAC: %.2f - Potpuna alkoholisanost", bac);
			System.out.println("\n--------------------");
			System.out.println("Kazna: 30 - 60 dana zatvora");
			System.out.println("Kazneni poeni: 15");
			System.out.println("Zabrana: 9 meseci");
		}
	}
}