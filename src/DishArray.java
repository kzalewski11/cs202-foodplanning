public class DishArray {
    private String [] Arr;

    //default constructor
    public DishArray()
    {
        Arr = new String[4];
    }

    //constructor with arguments
    public DishArray(String name, int calories, boolean vegetarian, boolean glutenFree){
        Arr[0] = name;
        Arr[1] = Integer.toString(calories);
        Arr[2] = String.valueOf(vegetarian);
        Arr[3] = String.valueOf(glutenFree);
    }
}
