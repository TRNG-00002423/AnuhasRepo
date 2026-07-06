import java.util.Scanner;

/**
 * Week 2 Exercise — menu-driven console (implement the menu loop).
 *
 * Compile: javac TicketMenu.java
 * Run:     java TicketMenu
 */
public class TicketMenu {

    public static void main(String[] args) {
        String[] tickets = {"BUG-101 Login timeout", "BUG-102 CSV import", "BUG-103 flaky assertion"};
        int[] priorities = {2, 2, 2}; // stretch: update in menu option 2
        String Input = null;

        try (Scanner in = new Scanner(System.in)) {
            // TODO: loop until quit
            // print menu: 1=list 2=set priority 3=summary 4=quit
            boolean exit_loop = false;

            while(exit_loop!=true) {

                System.out.println("=".repeat(40));
                System.out.println("TICKET MENU");
                System.out.println("=".repeat(40));
                System.out.println("1 - List All Tickets");
                System.out.println("2 - Add Priority");
                System.out.println("3 - Summary of Ticket Count");
                System.out.println("4 - QUIT\n");
                System.out.println("Please Choose from the options listed above !");

                Input = in.next();

                int user_input = Integer.parseInt(Input); 


                switch(user_input){
                    case 1:
                        listAllTickets(tickets, priorities);
                        break;
                    case 2:
                        addPriority(tickets, priorities, in);
                        break;
                    case 3:
                        summaryCount(tickets);
                        break;
                    case 4:
                        System.out.println("Ticket Menu Is Now Closing.");
                        exit_loop = true;
                        break;
                    default:
                        System.out.println("Invalid Option : Please Choose From The List Above.");
                        // break;
                }

                
            }


        }
    }


    public static void listAllTickets(String[] tickets, int[] priorities) {

        for(int i=0; i<tickets.length; i++) {
            System.out.println("=".repeat(40));
            System.out.println("LIST OF ALL TICKETS");
            System.out.println("=".repeat(40));
            System.out.println("| "+i+" | "+tickets[i]+" |  "+priorities[i]+"  |");
        }
    }

    public static void addPriority(String[] tickets, int[] priorities, Scanner in) {
            listAllTickets(tickets, priorities);
            boolean exit_loop = false;
            int number_tickets = tickets.length;
            System.out.println("Please enter the index of the ticket you wish to update : ");
            System.out.println("Please enter 4 to QUIT : ");
            
            while(exit_loop!=true) {
                String Input = null;
                Input = in.next();

                int user_input = Integer.parseInt(Input);


                Integer ticket_to_change = (Input == null) ? Integer.valueOf(0) : user_input;

                switch(ticket_to_change){
                    case 1:
                        System.out.println("The priority of this ticket ("+tickets[1]+") is currrently : "+priorities[1]);
                        break;
                    case 2:
                        System.out.println("The priority of this ticket ("+tickets[2]+") is currrently : "+priorities[2]);
                        break;
                    case 3:
                        System.out.println("The priority of this ticket ("+tickets[3]+") is currrently : "+priorities[3]);
                        break;
                    case 4:
                        System.out.println("This Menu Is Now Closing.");
                        exit_loop = true;
                        break;
                    default:
                        System.out.println("Invalid Option : Please Choose From The List Above.");
                        // break;
                }

                System.out.println("Please enter the priority you wish to update this ticket to.");
                System.out.println("Please enter 4 to QUIT : ");

                Input = in.next();
                int priority_input = Integer.parseInt(Input);

                Integer new_priority = (Input == null) ? Integer.valueOf(0) : priority_input;

                switch(new_priority){
                    case 1:
                        priorities[ticket_to_change]= new_priority; 
                        System.out.println("The priority of this ticket ("+tickets[1]+") is currrently : "+priorities[1]);
                        break;
                    case 2:
                        priorities[ticket_to_change]= new_priority; 
                        System.out.println("The priority of this ticket ("+tickets[2]+") is currrently : "+priorities[2]);
                        break;
                    case 3:
                        priorities[ticket_to_change]= new_priority; 
                        System.out.println("The priority of this ticket ("+tickets[3]+") is currrently : "+priorities[3]);
                        break;
                    case 4:
                        System.out.println("This Menu Is Now Closing.");
                        exit_loop = true;
                        break;
                    default:
                        System.out.println("Invalid Option : Please Choose From The List Above.");
                        // break;
                }





            }

    }


    public static void summaryCount(String[] tickets){

        int count = 0;
        count = tickets.length;
        System.out.println("The total number of tickets is currently :"+count);

    }

}
