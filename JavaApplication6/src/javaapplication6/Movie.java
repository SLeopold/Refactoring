package javaapplication6;


public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    private Price price; 
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(priceCode);
    }
    
    public int getPriceCode() {
        return price.getPriceCode();
    }
    
    public void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                price = new RegularPrice();
            break;
            case CHILDRENS:
                price = new ChildrensPrice();
            break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
            break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
            }
    }
    double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
    
    public String getTitle (){
        return title;
    };
    
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
 abstract class Price 
 {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
    abstract int getFrequentRenterPoints(int daysRented);
 }

 class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
    double getCharge(int daysRented){
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
    
    int getFrequentRenterPoints(int daysRented)
    {
        return 1;
    }
 }

 class NewReleasePrice extends Price {
    
     int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
    
    double getCharge(int daysRented){
        return daysRented * 3;
    }
    
    int getFrequentRenterPoints(int daysRented)
    {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
 }
 
class RegularPrice extends Price {
    
    int getPriceCode() {
        return Movie.REGULAR;
    }
        
    double getCharge(int daysRented){
        double result = 2;
        if (daysRented > 2)
        result += (daysRented - 2) * 1.5;
        return result;
    }
    
    int getFrequentRenterPoints(int daysRented)
    {
        return 1;
    }
}