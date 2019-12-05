public class Chinese extends Restaurant{
    //is spicy food available
    private boolean spicy;

    //default constructor
    public Chinese(){
        spicy = false;
    }

    //zero out data
    public void remove()
    {
        spicy = false;
        super.remove();
    }

    //constructor with args
    public Chinese(String n, String d, int cal, boolean veg, boolean gf) {
        name = n;
        favorite = new Dish(d, cal, veg, gf);
        spicy = false;
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
