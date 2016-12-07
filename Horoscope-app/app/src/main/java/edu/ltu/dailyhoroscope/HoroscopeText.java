package edu.ltu.dailyhoroscope;

public class HoroscopeText {
    private String horoscopetext;

    public static final HoroscopeText[] horoscopesummary = {
            new HoroscopeText("Your favorite T-shirt brings about your downfall when a literal-minded mob follows its instructions and fills you to the indicated line with margaritas."),
            new HoroscopeText("Many have felt the Love Which Dare Not Speak Its Name, but you’ll experience the Love That Bellows Its Name Out A Crosstown-Bus Window All Day."),
            new HoroscopeText("Once again, the specter of war will dominate international news, preventing people the world over from learning how you made the world’s largest apple pie."),
            new HoroscopeText("Your problem is that you have no sense of proportion, which is why you paid surgeons to enlarge your head and hands."),
            new HoroscopeText("Some people believe your house in Heaven is filled with all the things you lost while on earth, which explains the dead pets lying everywhere."),
            new HoroscopeText("That run for the record books once again falls short when you start Boston’s all-time second-largest fire."),
            new HoroscopeText("Next time, when passing a note intended to find out if someone likes you, you’ll know to provide more than one box to check."),
            new HoroscopeText("The story of the universe has always fascinated you, but the ending will leave you with a lot of unanswered questions."),
            new HoroscopeText("You’ll never smile again after the tragic loss of your lower jaw and lips this week."),
            new HoroscopeText("As it turns out, there are indeed mountains high enough and valleys low enough to keep you from your love."),
            new HoroscopeText("The stars wouldn’t take the risks you do, but, hey, it’s your life for the next six months or so."),
            new HoroscopeText("You’ll be trapped in a hell of your own making, forcing you to admit that you really should have put in more bathrooms.")
    };
    private HoroscopeText(String text)
    {
        this.horoscopetext = text;
    }
    public String getHoroscope() {
        return horoscopetext;
    }

    public String toString() {
        return this.horoscopetext;
    }
}