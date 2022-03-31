import java.util.ArrayList;

/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private int age;
    private String birthMonth;
    private SocialYear year;
    private ArrayList<String> friends = new ArrayList<String>();
    
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        this.name = "";
        this.age = -1;
        this.birthMonth = "";
        ArrayList<String> friends = new ArrayList<String>();
    }
    
    public Person(String name, int age, String birthMonth, SocialYear year)
    {
        this.name = name;
        this.age = age;
        this.birthMonth = birthMonth;
        this.year = year;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public String getBirthMonth()
    {
        return this.birthMonth;
    }
    
    public SocialYear getSocialYear()
    {
        return this.year;
    }
    
    public ArrayList<String> getFriends()
    {
        return this.friends;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setBirthMonth(String birthMonth)
    {
        this.birthMonth = birthMonth;
    }
    
    public void setSocialYear(SocialYear year)
    {
        this.year = year;
    }
    
    public void addFriend(String friend)
    {
        friends.add(friend);
    }
    
    public boolean hasFriend(String friend)
    {
        return friends.contains(friend);
    }
    
    public boolean canVote()
    {
        return age >= 18;
    }
    
    public int daysInBirthMonth()
    {
        if (birthMonth.equals("January")) {
            return 31;
        } else if (birthMonth.equals("February")) {
            return 28;
        } else if (birthMonth.equals("March")) {
            return 31;
        } else if (birthMonth.equals("April")) {
            return 30;
        } else if (birthMonth.equals("May")) {
            return 31;
        } else if (birthMonth.equals("June")) {
            return 30;
        } else if (birthMonth.equals("July")) {
            return 31;
        } else if (birthMonth.equals("August")) {
            return 31;
        } else if (birthMonth.equals("September")) {
            return 30;
        } else if (birthMonth.equals("October")) {
            return 31;
        } else if (birthMonth.equals("November")) {
            return 30;
        } else if (birthMonth.equals("December")) {
            return 31;
        } else {
            return -1;
        }
    }
}
