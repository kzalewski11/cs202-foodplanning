import java.io.BufferedWriter;
import java.io.IOException;

public class Dish {
    protected String name;
    protected int calories;
    protected boolean vegetarian;
    protected boolean glutenFree;
    protected Dish next;
    protected DishArray [] Arr;

    //default constructor
    public Dish()
    {
        name = null;
        calories = 0;
        vegetarian = false;
        glutenFree =false;
        next = null;
        Arr [4] = new DishArray(name, calories, vegetarian, glutenFree);
    }

    //copy constructor
    public Dish(Dish toCopy)
    {
         name = toCopy.name;
         calories = toCopy.calories;
         vegetarian = toCopy.vegetarian;
         glutenFree = toCopy.glutenFree;
         next = null;
    }

    //constructor with args
    public Dish(String n, int cal, boolean gf, boolean veg)
    {
        name = n;
        calories = cal;
        vegetarian = veg;
        glutenFree = gf;
        next = null;
    }

    //go next
    public Dish goNext()
    {
        return next;
    }

    //set next
    public void setNext(Dish toSet)
    {
        next = toSet;
    }

    //dish display function
    public void display()
    {
        System.out.println(name);
        System.out.println("Calories: " + calories);
        System.out.print("Gluten Free: ");
        if(glutenFree == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    //write out dish to file
    public void writeOut(BufferedWriter w)
    throws IOException
    {
        w.append(name);
        w.append('/');
        w.append(Integer.toString(calories));
        w.append('/');
        w.append(String.valueOf(vegetarian));
        w.append('/');
        w.append(String.valueOf(glutenFree));

    }
}
