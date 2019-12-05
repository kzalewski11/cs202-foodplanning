import java.util.Scanner;

public class Interface {
    //default constructor
    public Interface()
    {

    }

    //show greeting message
    public void showGreeting()
    {
        System.out.println("Welcome to Food Finder!");
    }

    //show exit message
    public void showClosing()
    {
        System.out.println("Thanks for using Food Finder. Goodbye!");
    }

    //show user main menu
    public void showMenu()
    {
        System.out.println("1. Display all available restaurants");
        System.out.println("2. Add restaurant item to meal plan");
        System.out.println("3. Show all dishes currently in meal");
        System.out.println("4. Quit");
    }

    //program main loop
    public void userLoop(RBT r, Meal m)
    {
        showMenu();
        int c = choice();
        while(c != 4)
        {
            //if user chooses to see all restaurants
            if(c == 1)
                r.display();

            //if user chooses to add item to meal
            if(c == 2)
            {
                System.out.println("Which restaurant would you like to explore? (Enter number 1-6)");
                Scanner in = new Scanner(System.in);
                int choice = in.nextInt();

                switch(choice) {
                    case 1:
                        //show all meals at Don Pedro
                        r.find("Don Pedro").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("Don Pedro").findnth(choice));
                        break;


                    case 2:
                        //show all meals at Happy Broccoli
                        r.find("Happy Broccoli").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("Happy Broccoli").findnth(choice));
                        break;

                    case 3:
                        //show all meals at Healthy Skepticism
                        r.find("Healthy Skepticism").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("Healthy Skepticism").findnth(choice));
                        break;

                    case 4:
                        //show all meals at New Buffet
                        r.find("New Buffet").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("New Buffet").findnth(choice));
                        break;

                    case 5:
                        //show all meals at Panda Express
                        r.find("Panda Express").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("Panda Express").findnth(choice));
                        break;

                    case 6:
                        //show all meals at Senor Lopez
                        r.find("Senor Lopez").listItems();
                        System.out.println("Which item would you like to add to your meal?");
                        choice = in.nextInt();
                        m.add(r.find("Senor Lopez").findnth(choice));
                        break;
                }
            }

            //if user chooses to show current meal
            if(c == 3)
                m.displayAll();

            //if user chooses to quit
            if(c == 4)
                return;

            showMenu();
            c = choice();
        }
    }

    //read user choice from input stream
    public int choice()
    {
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice > 0 && choice < 5)
            return choice;

        System.out.println("Invalid choice. Please enter number corresponding to choice.");
        return choice();
    }
}
