public class RBT {
    //root of Red-Black tree
    protected Restaurant root;

    //default constructor
    public RBT() {
        root = null;
    }

    //set root
    public void setRoot(Restaurant r) {
        root = r;
    }

    //insert Restaurant
    public Restaurant insert(Restaurant r) {
        //if root is null
        if(root == null)
            root = r;

        else
            insert(r, root);

        repair(r);
        return root;
    }

    //insert Restaurant recursive
    public void insert(Restaurant r, Restaurant root) {
        //if r is less than root
        if (root != null && r.getName().compareTo(root.getName()) < 0) {
            if (root.goLeft() != null) {
                insert(r, root.goLeft());
                return;
            } else
                root.setLeft(r);
        } else if (root != null) {
            if(root.goRight() != null) {
                insert(r, root.goRight());
                return;
            }
            else
                root.setRight(r);
        }
        r.setParent(root);
        r.setRed(true);
    }

    //repair tree
    public void repair(Restaurant r)
    {
        //if new node is root
        if(r == root)
        {
            r.setRed(false);
            return;
        }

        //if parent is black
        if(r.getParent() != null) {
            if (r.getParent().isRed() == false)
                return;
        }

        //if parent and uncle both red
        if(r.getParent() != null && r.getUncle() != null) {
            if (r.getParent().isRed() == true && r.getUncle().isRed() == true) {
                //repaint parent and uncle black, repaint grandparent red
                r.getParent().setRed(false);
                r.getUncle().setRed(false);
                if (r.getGrandparent() != null) {
                    r.getGrandparent().setRed(true);

                    //repair on grandparent
                    repair(r.getGrandparent());
                }
                return;
            }
        }
        //case 4: parent red, uncle black
        if(r.getParent().isRed() == true && r.getUncle() == null)
        {
            //if r is right child and r.parent is left child
            if(r == r.getParent().goRight() && r.getParent() == r.getGrandparent().goLeft())
            {
                r.getParent().rotateLeft(this);
                r = r.goLeft();
            }

            //if r is left child and r.parent is right child
            else if(r == r.getParent().goLeft() && r.getParent() == r.getGrandparent().goRight())
            {
                r.getParent().rotateRight(this);
                r = r.goRight();
            }

            //if r is left child
            if(r == r.getParent().goLeft())
                r.getGrandparent().rotateRight(this);

                //if r is right child
            else
                r.getGrandparent().rotateLeft(this);

            //set parent black
            r.getParent().setRed(false);
            r.getParent().goRight().setRed(true);

            //if grandparent exists
            if(r.getGrandparent() != null)
                //set grandparent red
                r.getGrandparent().setRed(true);
        }
    }

    //display tree
    public void display(){
        //if tree is empty
        if(root == null)
            return;

        //if tree only has one node
        if(root.goLeft() == null && root.goRight() == null) {
            root.display();
            return;
        }

        //if tree has more than one node
        display(root);
    }

    //display tree recursively
    public void display(Restaurant root) {

        //if left subtree exists
        if (root.goLeft() != null)
            display(root.goLeft());

        //display node
        root.display();

        //if right subtree exists
        if (root.goRight() != null)
            display(root.goRight());
    }

    //find restaurant in tree
    public Restaurant find(String name)
    {
        //if tree is empty
        if(root == null)
            return null;

        return find(name, root);
    }

    //find restaurant recursive
    public Restaurant find(String name, Restaurant root)
    {
        //if name is less than root
        if(name.compareTo(root.getName()) < 0) {
            if (root.goLeft() != null)
                return find(name, root.goLeft());
            return null;
        }

        //if name is greater than root
        if(name.compareTo(root.getName()) > 0)
        {
            if(root.goRight() != null)
                return find(name, root.goRight());
            return null;
        }

        return root;
    }

    //retrieve related wrapper
    public void retrieveRelated(Restaurant r)
    {
        //if tree is empty
        if(root == null)
            return;

        //if tree only has one item
        if(root.goLeft() == null && root.goRight() == null) {
            if (r.getClass() == root.getClass())
                r.display();
        }

        //if tree has more than one item
        retrieveRelated(r, root);
    }

    //retrieve related recursive
    public void retrieveRelated(Restaurant r, Restaurant root) {
        //traverse left
        if (root.goLeft() != null)
            retrieveRelated(r, root.goLeft());

        //visit root
        if (r.getClass() == root.getClass())
            root.display();

        //traverse right
        if (root.goRight() != null)
            retrieveRelated(r, root.goRight());
    }

    //remove all items from tree wrapper
    public void removeAll()
    {
        //if tree is empty
        if(root == null)
            return;

        //if tree has only one node
        if(root.goLeft() == null && root.goRight() == null) {
            root.remove();
            root = null;
            return;
        }

        //if tree has multiple nodes
        removeAll(root);
    }

    //remove all items recursively
    public void removeAll(Restaurant root)
    {
        //traverse left
        if(root.goLeft() != null)
            removeAll(root.goLeft());

        //traverse right
        if(root.goRight() != null)
            removeAll(root.goRight());

        //delete root info
        root.remove();
        root = null;
    }

    //build tree
    public void build()
    {
        //create some restaurants
        Restaurant r1 = new Chinese("Panda Express", "Orange Chicken", 500, false , false);
        Restaurant r2 = new Mexican("Don Pedro", "Chimichanga", 600, false, false);
        Restaurant r3 = new Vegetarian("Happy Broccoli", "Kale Salad", 250, true, true);
        Restaurant r4 = new Chinese("New Buffet", "Teriyaki Chicken", 450, false, false);
        Restaurant r5 = new Mexican("Senor Lopez", "Quesadilla", 550, false, false);
        Restaurant r6 = new Vegetarian("Healthy Skepticism", "Dehydrated Bean Chips", 120, true, true);

        //create some dishes
        Dish d1 = new Dish("Oranger  Chicken", 400, false, false);
        Dish d2 = new Dish("General Tso's Chicken", 550, false, false);
        Dish d3 = new Dish("Chicken Quesadilla", 700, false, false);
        Dish d4 = new Dish("Chimichanga minus the beef", 800, false, false);
        Dish d5 = new Dish("Broccoli Squares", 200, true, true);
        Dish d6 = new Dish("Dehydrated then rehydrated bean chips, canned" , 200, true, true);
        Dish d7 = new Dish("Pork Fried Rice", 400, true, false);
        Dish d8 = new Dish("Egg Rolls", 300, false, false);
        Dish d9 = new Dish("Chicken Tacos", 600, true, false);
        Dish d10 = new Dish("Chips and Salsa", 300, true, true);
        Dish d11 = new Dish("Meatlike substance powder", 50, true, true);
        Dish d12 = new Dish("Something probably gross tasting", 100, true, true);

        //add dishes to restaurants
        r1.addDish(d1);
        r1.addDish(d2);

        r2.addDish(d3);
        r2.addDish(d4);

        r3.addDish(d5);
        r3.addDish(d6);

        r4.addDish(d7);
        r4.addDish(d8);

        r5.addDish(d9);
        r5.addDish(d10);

        r6.addDish(d11);
        r6.addDish(d12);

        setRoot(insert(r1));
        setRoot(insert(r2));
        setRoot(insert(r3));
        setRoot(insert(r4));
        setRoot(insert(r5));
        setRoot(insert(r6));
    }
}
