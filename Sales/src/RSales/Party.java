import javafx.scene.control.CheckBox;

/**
 * This class constructs the object of type 'table' to be used throughout 
 * the Sale process
 * @author alex
 *  last edited 28 june 2016
 */
public class Party{

	public static boolean selected = false;
	public static boolean sat = false;
	public static String tableName;
	public static int customerCount;
	public static double tablePrice;
	public static int adult = 0, c911 = 0, c68 = 0, c45 = 0, c03 = 0;
	static int identifier = 0;
	static int j = 0;
	
	
	Party(String startTableName, int startCustomerCount, double startTablePrice, int startAdult, 
			int startC911, int startC68, int startC45, int startC03, boolean startSelected, boolean startSat
			, int startIdentifier){
		selected = startSelected;
		sat = startSat;
		tableName = startTableName;
		customerCount = startCustomerCount;
		tablePrice = startTablePrice;
		adult = startAdult;
		c911 = startC911;
		c68 = startC68;
		c45 = startC45;
		c03 = startC03;
		identifier = startIdentifier;
	}
	
	public void setCustomerCount(int customerCount){
		this.customerCount = customerCount;
	}
	
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	
	public void setTablePrice(double tablePrice){
		this.tablePrice = tablePrice;
	}
	
	public void setAdult(int adult){
		this.adult = adult;
	}
	
	public void setC911(int c911){
		this.c911 = c911;
	}
	
	public void setC68(int c68){
		this.c68 = c68;
	}
	
	public void setC45(int c45){
		this.c45 = c45;
	}
	
	public void setC03(int c03){
		this.c03 = c03;
	}
	
	public int getCustomerCount(){
		return customerCount;
	}
	
	public String getTableName(){
		return tableName;
	}
	
	public static double computeTablePrice(int c03, int c45, int c68, int c911, int adult){
		tablePrice = ((adult*17.95)+(c911*11.95)+(c68*8.95)+(c45*4.95)+(c03*0))*1.075;
		return tablePrice;
	}
	
	public static double getTablePrice(){
		return tablePrice;
	}
	
	public static int getAdults(){
		return adult;
	}
	
	public static int getC911(){
		return c911;
	}
	
	public static int getC68(){
		return c68;
	}
	
	public static int getC45(){
		return c45;
	}
	
	public static int getC03(){
		return c03;
	}
	
	
	
	
}