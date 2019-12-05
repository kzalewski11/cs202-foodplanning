public abstract class Restaurant {
    protected Restaurant left;
    protected Restaurant right;
    protected Restaurant parent;
    protected Dish favorite;
    protected int priceRating;
    protected int healthRating;
    protected String name;
    protected boolean delivery;
    protected boolean red;


    //default constructor
    public Restaurant() {
        left = null;
        right = null;
        parent = null;
        favorite = null;
        priceRating = 0;
        healthRating = 0;
        delivery = true;
        red = false;
    }

    //get color
    public boolean isRed() {
        if (this == null)
            return false;
        return red;
    }

    //set color
    public void setRed(boolean r) {
        if (r == true) {
            red = true;
            return;
        }
        red = false;
    }

    //zero out information
    public void remove() {
        name = null;
        left = null;
        right = null;
    }

    //abstract base display
    public abstract void display();

    //get name
    public String getName() {
        if (this == null)
            return null;
        return name;
    }

    //display name only
    public void displayName()
    {
        System.out.println(name);
    }

    //list items wrapper
    public void listItems()
    {
        int count = 1;
        //if list is empty
        if(favorite == null)
            return;

        //if list only has one item
        if(favorite.goNext() == null)
        {
            System.out.print(count + ". ");
            favorite.display();
            System.out.println(" ");
            return;
        }

        //if list has more than one item
        listItems(favorite, count);
    }

    //list items recursive
    public void listItems(Dish favorite, int count)
    {
        //base case
        if(favorite.goNext() == null)
        {
            System.out.print(count + ". ");
            favorite.display();
            System.out.println(" ");
            return;
        }

        System.out.print(count + ". ");
        favorite.display();
        System.out.println(" ");

        listItems(favorite.goNext(), ++count);
    }

    //retrieve nth item in menu
    public Dish findnth(int n)
    {
        int count = 1;

        //if n is 1
        if(n == 1)
            return favorite;

        //if n is greater than 1
        return findnth(n, count, favorite);
    }

    //retrieve nth item recursive
    public Dish findnth(int n, int count, Dish favorite)
    {
        //base case
        if(n == count)
            return favorite;

        //recursive call
        return findnth(n, ++count, favorite.goNext());
    }

    //go left
    public Restaurant goLeft() {
        return left;
    }

    //go right
    public Restaurant goRight() {
        return right;
    }

    //set left
    public void setLeft(Restaurant r) {
        left = r;
    }

    //set right
    public void setRight(Restaurant r) {
        right = r;
    }

    //set parent
    public void setParent(Restaurant r) {
        parent = r;
    }

    //get parent
    public Restaurant getParent() {
        return parent;
    }

    //get grandparent
    public Restaurant getGrandparent() {
        if (parent != null)
            return parent.parent;

        return null;
    }

    //get uncle
    public Restaurant getUncle() {
        if (parent == parent.parent.left)
            return parent.parent.right;

        return parent.parent.left;
    }

    //rotate left on current object
    public void rotateLeft(RBT t) {
        Restaurant temp = right;
        right = temp.left;

        if (temp.left != null)
            temp.left.parent = this;

        temp.parent = parent;

        if (parent == null)
            t.setRoot(temp);

        else if (this == parent.left)
            parent.left = temp;

        else
            parent.right = temp;

        temp.left = this;
        parent = temp;
    }

    //rotate right on current object
    public void rotateRight(RBT t) {
        Restaurant temp = left;
        left = temp.right;

        if(temp.right != null)
            temp.right.parent = this;

        temp.parent = parent;

        if(parent == null)
            t.setRoot(temp);

        else if (this == parent.right)
            parent.right = temp;

        else
            parent.left = temp;

        temp.right = this;
        parent = temp;
    }

    //add dish to restaurant wrapper
    public void addDish(Dish toAdd)
    {
        //if restaurant has no dishes
        if(favorite == null) {
            favorite = toAdd;
            return;
        }

        //if restaurant only has one dish
        if(favorite.goNext() == null) {
            favorite.setNext(toAdd);
            return;
        }

        //if restaurant has more than one dish
        addDish(toAdd, favorite);
    }

    //add dish to restaurant recursive
    public void addDish(Dish toAdd, Dish favorite)
    {
        //base case
        if(favorite.goNext() == null) {
            favorite.setNext(toAdd);
            return;
        }

        addDish(toAdd, favorite.goNext());
    }
}
