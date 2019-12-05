import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Meal {
    public String[] Arr;
    public Dish start;

    //default constructor
    public Meal()
    {
        start = null;
    }

    //add dish to meal
    public void add(Dish toAdd)
    {
        Dish n = new Dish(toAdd);
        //if list is empty
        if(start == null) {
            start = n;
            return;
        }

        //if list has only one item
        if(start.goNext() == null) {
            start.setNext(n);
            return;
        }

        //if list has more than one item
        add(n, start);
    }

    //add dish recursive
    public void add(Dish n, Dish start)
    {
        //stopping condition
        if(start.goNext() == null) {
            start.setNext(n);
            return;
        }

        add(n, start.goNext());
    }

    //display all meals
    public void displayAll()
    {
        //if list is empty
        if(start == null) {
            System.out.println("No dishes currently in meal.");
            return;
        }

        System.out.println("Dishes currently in plan");

        //if list only has one item
        if(start.goNext() == null) {
            start.display();
            return;
        }

        //if list has more than one item
        displayAll(start);
    }

    //display all recursively
    public void displayAll(Dish start)
    {
        //stopping condition
        if(start.goNext() == null)
        {
            start.display();
            System.out.println(" ");
            return;
        }

        start.display();
        System.out.println(" ");
        displayAll(start.goNext());
    }

    //write out to file wrapper
    public void writeOut()
    throws IOException
    {
        if(start == null)
            return;

        BufferedWriter w = new BufferedWriter(new FileWriter("meal.txt", false));
        writeOut(start, w);
        w.close();
    }

    //recursively write out
    public void writeOut(Dish start, BufferedWriter w)
    throws IOException
    {
        //if at end of list
        if(start.goNext() == null)
        {
            start.writeOut(w);
            w.newLine();
            return;
        }

        start.writeOut(w);
        w.newLine();
        writeOut(start.goNext(), w);
    }
}
