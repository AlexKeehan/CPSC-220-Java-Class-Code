
/**
 * Write a description of class Lab10 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab10
{
    public static void main(String[] args)
    {
        Person a = new Person("Alex", 18, "September", SocialYear.SOPHOMORE);
        System.out.println("Can an 18 year old vote: " + a.canVote());
        a.addFriend("Jenny");
        a.addFriend("Bobby");
        System.out.println("Is Alex friends with Jenny: " + a.hasFriend("Jenny"));
        System.out.println("Is Alex friends with Jane: " + a.hasFriend("Jane"));
        System.out.println("Number of days in birth month for first person: " + a.daysInBirthMonth());
        System.out.println("First person's name: " + a.getName());
        System.out.println("Age for person 1: " + a.getAge());
        System.out.println("First person's birth month: " + a.getBirthMonth());
        System.out.println("Social year for the first person: " + a.getSocialYear());
        
        System.out.println("*****************************************");
        
        Person b = new Person("Bobby", 16, "October", SocialYear.FRESHMAN);
        System.out.println("Can a 16 year old vote: " + b.canVote());
        System.out.println("Number of days in birth month for second person: " + b.daysInBirthMonth());
        b.addFriend("Greg");
        b.addFriend("Luke");
        System.out.println("Is Bobby friends with Greg: " + b.hasFriend("Greg"));
        System.out.println("Is Bobby friends with Luke: " + b.hasFriend("Luke"));
        System.out.println("Second person's name: " + b.getName());
        System.out.println("Age for person 2: " + b.getAge());
        System.out.println("Second person's birth month: " + b.getBirthMonth());
        System.out.println("Social year for second person: " + b.getSocialYear());
        
    }
}
