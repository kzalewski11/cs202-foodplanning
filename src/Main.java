import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //create Red-Black tree
        RBT r = new RBT();

        //build tree
        r.build();

        //create new meal
        Meal m = new Meal();

        //user interface
        Interface i = new Interface();
        i.showGreeting();
        i.userLoop(r, m);

        //write out meal
        m.writeOut();

        /*find restaurants
        //boolean found = r.find("Panda Express");
        //boolean found = r.find("Don Pedro");
        //boolean found = r.find("Happy Broccoli");
        //boolean found = r.find("New Buffet");
        //boolean found = r.find("Senor Lopez");
        //boolean found = r.find("Healthy Skepticism");
        //boolean found = r.find("Unhealthy Skepticism");

        if(found == true)
            System.out.println("Restaurant was found");
        else
            System.out.println("Restaurant not found");

        //retrieve related
        System.out.println("Retrieving related restaurants: ");
        //r.retrieveRelated(r3);*/

        //remove all entries from tree
        r.removeAll();

        //display exit message
        i.showClosing();
    }
}
