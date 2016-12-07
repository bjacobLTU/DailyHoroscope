package edu.ltu.dailyhoroscope;

public class Horoscope {
    private String name;
    private String description;
    private String symbol;
    private String month;
    //private int imageResourceId;

    //horoscopes is an array of Horoscopes
    public static final Horoscope[] horoscopes = {
            new Horoscope("Aries", "Courageous and Energetic.","Ram", "April"),
            new Horoscope("Taurus", "Known for being reliable, practical, ambitious and sensual.", "Bull", "May"),
            new Horoscope("Gemini", "Gemini-born are clever and intellectual.", "Twins", "June"),
            new Horoscope("Cancer", "Tenacious, loyal and sympathetic.", "Crab", "July"),
            new Horoscope("Leo", "Warm, action-oriented and driven by the desire to be loved and admired.", "Lion", "August"),
            new Horoscope("Virgo", "Methodical, meticulous, analytical and mentally astute.", "Virgin", "September"),
            new Horoscope("Libra", "Librans are famous for maintaining balance and harmony.", "Scales","October"),
            new Horoscope("Scorpio", "Strong willed and mysterious.", "Scorpion", "November"),
            new Horoscope("Sagittarius", "Born adventurers.", "Archer", "December"),
            new Horoscope("Capricorn", "The most determined sign in the Zodiac.", "Goat", "January"),
            new Horoscope("Aquarius", "Humanitarians to the core", "Water Bearer", "February"),
            new Horoscope("Pisces", "Proverbial dreamers of the Zodiac.", "Fish", "March")
    };

    //Each Horoscope has a name, description, and an image resource
    //private Horoscope(String name, String description, int imageResourceId) {
    private Horoscope(String name, String description, String symbol, String month) {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.month = month;
        //this.imageResourceId = imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getMonth() {
        return month;
    }

    public String toString() {
        return this.name;
    }
}