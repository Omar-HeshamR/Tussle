import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Empire {
	
	// population morale score 1 to 100, 100 being best.
	// food, technology stocks score from 1 to 100
	// Recourses = Wood, Metals, Coal, Oil, Gas -- they by amounts
	// weaponry = guns, tanks, planes, ships
	// tax,med,edu,inafa,are percantge that add to 100
	// military level are scores from 1 to 100.
	
	private String empireNameString, flagName, empPic;
	private long money, population, AnnualIncome, debt;
	private int populationMorale, foodStocks, techLevel, taxLevel, medLevel, eduLevel, infaLevel, militaryLoyality;
	private boolean isAlive;
	private int[] recources ;
	private int[] weaponry ;
	int ID;
	
	// to hold the last conquring empire
	public static Empire JustConqured;
	public static Empire gotConqured;

	public Empire(String name, String flagName, String empPic, long money, long population, long AnnualIncome, long debt, int populationMorale,
			int foodStocks, int techLevel, int[] recources, int[] weaponry, int taxLevel, int medLevel, int eduLevel,
			int infastrectureLevel, int militaryLoyality, boolean isAlive) {
		this.empireNameString = name;
		this.flagName = flagName;
		this.empPic = empPic;
		this.money = money;
		this.population = population;
		this.AnnualIncome = AnnualIncome;
		this.debt = debt;
		this.populationMorale = populationMorale;
		this.foodStocks = foodStocks;
		this.techLevel = techLevel;
		this.recources = recources;
		this.weaponry = weaponry;
		this.taxLevel = taxLevel;
		this.medLevel = medLevel;
		this.eduLevel = eduLevel;
		this.infaLevel = infastrectureLevel;
		this.militaryLoyality = militaryLoyality;
		this.isAlive = isAlive;
	}
	
	public String getEmpireNameString() {
		return empireNameString;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getEmpPic() {
		return empPic;
	}
	public String getflagName() {
		return flagName;
	}
	
	
	public void setEmpireNameString(String empireNameString) {
		this.empireNameString = empireNameString;
	}
	public void setempPic(String empPic) {
		this.empPic = empPic;
	}	
	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getAnnualIncome() {
		return AnnualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		AnnualIncome = annualIncome;
	}

	public long getDebt() {
		return debt;
	}

	public void setDebt(long debt) {
		this.debt = debt;
	}

	public int getPopulationMorale() {
		return populationMorale;
	}

	public void setPopulationMorale(int populationMorale) {
		this.populationMorale = populationMorale;
	}

	public int getFoodStocks() {
		return foodStocks;
	}

	public void setFoodStocks(int foodStocks) {
		this.foodStocks = foodStocks;
	}

	public int getTechLevel() {
		return techLevel;
	}

	public void setTechLevel(int techLevel) {
		this.techLevel = techLevel;
	}

	public int getTaxLevel() {
		return taxLevel;
	}

	public void setTaxLevel(int taxLevel) {
		this.taxLevel = taxLevel;
	}

	public int getMedLevel() {
		return medLevel;
	}

	public void setMedLevel(int medLevel) {
		this.medLevel = medLevel;
	}

	public int getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(int eduLevel) {
		this.eduLevel = eduLevel;
	}

	public int getInfaLevel() {
		return infaLevel;
	}

	public void setInfaLevel(int infaLevel) {
		this.infaLevel = infaLevel;
	}

	public int getMilitaryLoyality() {
		return militaryLoyality;
	}

	public void setMilitaryLoyality(int militaryLoyality) {
		this.militaryLoyality = militaryLoyality;
	}
	
	public void setIsAlive(boolean b) {
		this.isAlive = b;
	}

	public boolean getIsAlive() {
		return isAlive;
	}
	
	public int getRecources(int i) {
		return recources[i - 1];
	}

	public void setRecources(int i, int n) {
		int[] recources = new int[4];
		recources = this.recources;
		recources[i-1] = n;
		this.recources = recources;	
		}

	public int getWeaponry(int i) {
		return weaponry[i - 1];
	}

	public void setWeaponry(int i, int n) {
		int[] weaponry = new int[3];
		weaponry = this.weaponry;
		weaponry[i-1] = n;
		this.weaponry = weaponry;
	}

	// For Border OVERCOME --> UNUSED FOR NOW!
//	public static Color getColor(Empire emp) {
//		Color c = new Color(0,0,0);
//		switch(emp.getflagName()) {
//		case"EmpireFlag-Hamid.png":
//			c = Color.BLACK;
//			break;
//		case"FredzFlag.png":
//			c = new Color(255,150,122);
//			break;
//		case"TribesFlag.png":
//			c = Color.GRAY;
//			break;
//		case"VulpineEmpireFlag.png":
//			c = new Color(128,0,128);
//			break;
//		case"SandrisaFlag.jpg":
//			c = new Color(255,140,0);
//			break;
//		case"AlkozKingdomFlag.png":
//			c = new Color(153,153,0);
//			break;
//		case"EastfrrontUnionFlag.png":
//			c = new Color(165,42,42);
//			break;
//		case"PadaraStateFlag.png":
//			c = new Color(255,20,147);
//			break;
//		case"MilitaryStateFlag.jpg":
//			c = Color.green;
//			break;
//		case"KrixxunKingdomFlag.jpg":
//			c = Color.WHITE;
//			break;
//		case"EsctourKingdomFlag.jpg":
//			c = new Color(128,0,128);
//			break;
//		case"ZeonRepublicFlag.png":
//			c = Color.BLUE;
//			break;
//		case "flag1icon.png":
//			c = Color.red;
//			break;
//		case "flag2icon.png":
//			c = Color.red;
//			break;
//		case "flag3icon.png":
//			c = Color.red;
//			break;
//		}
//		return c;
//	}
	
	// WAR METHODS
	public static double getPowerLevel(Empire emp) {
	double PL = 0;
	PL = PL + (emp.getWeaponry(1) * 5);
	PL = PL + (emp.getWeaponry(2) * 5.3);
	PL = PL + (emp.getWeaponry(3) * 7.2);
	PL = PL + (emp.getWeaponry(4) * 6.1);
	PL = PL * (emp.getTechLevel() * 1.233);
		return PL;
	}
	
	public void lostWar() {
		this.money = (long) (this.money * 0.66);
		this.foodStocks = this.foodStocks - 9;
		this.militaryLoyality = this.militaryLoyality - 26;
		this.populationMorale = this.populationMorale - 20;
		this.AnnualIncome = (long) (this.AnnualIncome * 0.66);
		this.recources[0] = (int) (this.recources[0] * 0.66);
		this.recources[1] = (int) (this.recources[1] * 0.66);
		this.recources[2] = (int) (this.recources[2] * 0.66);
		this.recources[3] = (int) (this.recources[3] * 0.66);
		this.recources[4] = (int) (this.recources[4] * 0.66);
		this.weaponry[0] = (int) (this.weaponry[0] - 1);
		this.weaponry[1] = (int) (this.weaponry[1] - 50);
		this.weaponry[2] = (int) (this.weaponry[2] - 25);
		this.weaponry[3] = (int) (this.weaponry[3] - 28);
	}
	
	public void CONQURED(Empire lostEMP) {
		this.money += (long) (lostEMP.getMoney() * 0.66);
		this.foodStocks = this.foodStocks + 10;
		this.militaryLoyality = this.militaryLoyality + 7;
		this.populationMorale = this.populationMorale + 6;
		this.AnnualIncome += (long) (lostEMP.getAnnualIncome() * 0.66);
		this.recources[0] += (int) (lostEMP.getRecources(1) * 0.333);
		this.recources[1] += (int) (lostEMP.getRecources(2) * 0.333);
		this.recources[2] += (int) (lostEMP.getRecources(3) * 0.333);
		this.recources[3] += (int) (lostEMP.getRecources(4) * 0.333);
		this.recources[4] += (int) (lostEMP.getRecources(5) * 0.333);
		this.weaponry[0] = this.weaponry[0] + 1;
		this.weaponry[1] += (int) (lostEMP.getWeaponry(2) * 0.14);
		this.weaponry[2] += (int) (lostEMP.getWeaponry(3) * 0.035);
		this.weaponry[3] += (int) (lostEMP.getWeaponry(4) * 0.05);
	}
	
	public static void conquers(Empire attackingEMP, Empire defendingEMP) {
		 if(defendingEMP.getIsAlive() == false) {
			ErrorWindow.openError5(defendingEMP.getEmpireNameString());
		}
		 else if(attackingEMP.getWeaponry(1) <= 0 || attackingEMP.getWeaponry(2) <= 0|| attackingEMP.getWeaponry(3) <= 0||attackingEMP.getWeaponry(4) <= 14) {
			 ErrorWindow.openError6();
		 }
		 else if (Empire.getPowerLevel(defendingEMP) > Empire.getPowerLevel(attackingEMP) ) {
			attackingEMP.lostWar();
			defendingEMP.setIsAlive(true);
			ErrorWindow.openError3(defendingEMP.getEmpireNameString(), attackingEMP.getEmpireNameString());
		}
		else if(Empire.getPowerLevel(attackingEMP) > Empire.getPowerLevel(defendingEMP) ) {
			attackingEMP.CONQURED(defendingEMP);
			JustConqured = attackingEMP;
			gotConqured = defendingEMP;
			defendingEMP.setIsAlive(false);
			defendingEMP.isConquredBy(attackingEMP);
			ErrorWindow.openError4(attackingEMP.getEmpireNameString(), defendingEMP.getEmpireNameString());
		}
	}
	
	 public void isConquredBy(Empire emp) {
		 int ID = 0;
     	switch(emp.getflagName()) {
     	case"EmpireFlag-Hamid.png":
        	ID  = 1;	
 			break;
 		case"FredzFlag.png":
 	     	ID  = 2;
 			break;
 		case"TribesFlag.png":
 			ID  = 3;
 			break;
 		case"VulpineEmpireFlag.png":
 			ID  = 4;
 			break;
 		case"SandrisaFlag.jpg":
 			ID  = 5;
 			break;
 		case"AlkozKingdomFlag.png":
 			ID  = 6;
 			break;
 		case"EastfrrontUnionFlag.png":
 			ID  = 7;
 			break;
 		case"PadaraStateFlag.png":
 			ID  = 8;
 			break;
 		case"MilitaryStateFlag.jpg":
 			ID  = 9;
 			break;
 		case"KrixxunKingdomFlag.jpg":
 			ID  = 10;
 			break;
 		case"EsctourKingdomFlag.jpg":
 			ID  = 11;
 			break;
 		case"ZeonRepublicFlag.png":
 			ID  = 12;
 			break;
 		case "flag1icon.png":
 			ID  = 13;
 			break;
 		case "flag2icon.png":
 			ID  = 13;
 			break;
 		case "flag3icon.png":
 			ID  = 13;
 			break;
     	}
		 
		 this.ID = ID;
	 }
	 
	public static void main(String[] args) {
	//	System.out.println(getPowerLevel(TussleGame.player));
	//	Empire.conquers(TussleGame.vulpine, TussleGame.eastfront);
	//	System.out.println(getPowerLevel(TussleGame.zeon));

	}

}
