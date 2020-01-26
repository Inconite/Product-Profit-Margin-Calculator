package ProductMargin;

import java.text.DecimalFormat;
import java.util.*;

public class Product_Margin {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Product Profit Margin Calculator!");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Selling Price: ");
		double s_Price = sc.nextDouble();
		
		System.out.println("Enter the Discount Percent: ");
		double p_Discount = sc.nextDouble();
		
		System.out.println("Enter the Cost Price: ");
		double c_Price = sc.nextDouble();
		
		/*To find if the discounted amount is greater than 0*/
		double r_sellPrice = 0;
		if(p_Discount > 0) {
			r_sellPrice = s_Price * ((100 - p_Discount)/100);
		}
		else {
			r_sellPrice = s_Price;
		}
		
		/*PayPal Fee Calculation Start*/
		double pp_PertileFee = 0.044;
		double pp_FixFee = 0.30;
		double pp_GstFee = 1.18;
		double pp_TotalFee;
		double pp_TotalReceived;
		
		pp_TotalFee = (r_sellPrice * pp_PertileFee + pp_FixFee) * pp_GstFee;
		pp_TotalReceived = r_sellPrice - pp_TotalFee;
		/*PayPal Fee Calculation End*/
		
		/*Profit calculation without including bank conversion fee*/
		double r_Profit = pp_TotalReceived - c_Price;
		double fb_ROAS = pp_TotalReceived / (pp_TotalReceived - c_Price);
		
		/*Profit after including bank fee*/
		double f_sellPrice = pp_TotalReceived * 0.96;  // About 4% lost - from PayPal to bank
		double f_costPrice = c_Price * 1.05;           // About 5% lost - bank to USD
		double f_profit = f_sellPrice - f_costPrice;
		double f_fbROAS = f_sellPrice/f_profit;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Sell Price After Discount: " + "$" + r_sellPrice);
		System.out.println("PayPal Balance After Fee: " + "$" + df.format(pp_TotalReceived));
        	System.out.println("Amount Lost in PayPal Fee: " + "$" + df.format(pp_TotalFee));
        	System.out.println("");
		System.out.println("Profit: " + "$" + df.format(r_Profit));
		System.out.println("FB ROAS %: " + df.format(fb_ROAS));
		System.out.println("---------------------------------------");
		System.out.println("Calculation after Bank fee conversions");
		System.out.println("Final Selling Price: " + "$" + df.format(f_sellPrice));
		System.out.println("Final Cost Price: " + "$" + df.format(f_costPrice));
		System.out.println("");
		System.out.println("Final Profit: " + "$" + df.format(f_profit));
		System.out.println("Final FB ROAS %: " + df.format(f_fbROAS));
		
		sc.close(); // Close Scanner
	}
}
  
