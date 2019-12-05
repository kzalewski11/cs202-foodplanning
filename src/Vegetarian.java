public class Vegetarian extends Restaurant{
    //vegan options available
    private boolean vegan;

    //default constructor
    public Vegetarian(){
        vegan = false;
    }

    //constructor with args
    public Vegetarian(String n, String d, int cal, boolean veg, boolean gf) {
        name = n;
        favorite = new Dish(d, cal, veg, gf);
        vegan = true;
    }

    //zero out data
    public void remove()
    {
        vegan = false;
        super.remove();
    }

    //display
    @Override
    public void display(){
        System.out.println(name);
        System.out.print("Popular dish: ");
        favorite.display();
        System.out.println("");
    }
}
