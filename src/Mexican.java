public class Mexican extends Restaurant{
    //is spicy food available
    private boolean spicy;

    //default constructor
    public Mexican(){
        spicy = false;
    }

    //constructor with args
    public Mexican(String n, String d, int cal, boolean veg, boolean gf) {
        name = n;
        favorite = new Dish(d, cal, veg, gf);
        spicy = false;
    }

    //zero out data
    public void remove()
    {
        spicy = false;
        super.remove();
    }

    //display
    @Override
    public void display() {
        System.out.println(name);
        System.out.print("Popular dish: ");
        favorite.display();
        System.out.println("");
    }
}
