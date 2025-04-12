import java.util.*;
class Bus
{
    Scanner input = new Scanner(System.in);
    String[][] bus_rajkot =new String[8][6];
    String[][] bus_valsad =new String[8][6];
    String[][] bus_jamnagar=new String[8][6];
    String rajkot="GJ75";
    String Valsad="GJ54";
    String jamnagar="GJ16";
    int Tickets;
    int availableseats_in_rajkot=32;
    int availableseats_in_valsad=32;
    int availableseats_in_jamnagar=32;
    TMS obj_for_TMS=new TMS();

    void storeValue()
    {
        char seatch_b=65;
        char seatch_t=65;
        char seatch_f=65;
        // int seatnu=1;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(j==3)
                {
                    bus_rajkot[i][j]=" ";
                }
                else if (j==0)
                {
                    bus_rajkot[i][j]=String.valueOf((char)seatch_b)+".";
                    seatch_b++;
                }
                else
                {
                    bus_rajkot[i][j]="O ";
                }
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(j==3)
                {
                    bus_valsad[i][j]=" ";
                }
                else if (j==0)
                {
                    bus_valsad[i][j]=String.valueOf((char)seatch_t)+".";
                    seatch_t++;
                }
                else
                {
                    bus_valsad[i][j]="O ";
                }
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                if(j==3)
                {
                    bus_jamnagar[i][j]=" ";
                }
                else if (j==0)
                {
                    bus_jamnagar[i][j]=String.valueOf((char)seatch_f)+".";
                    seatch_f++;
                }
                else
                {
                    bus_jamnagar[i][j]="O ";
                }
            }
        }
    }

    void displayrajkot()
    {
        System.out.println("  "+"1 "+"2 "+" "+"3 "+"4 ");
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                System.out.print(bus_rajkot[i][j]);
            }
            System.out.println();
        }
    }
    void displayJamnagar()
    {
        System.out.println("  "+"1 "+"2 "+" "+"3 "+"4 ");
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                System.out.print(bus_jamnagar[i][j]);
            }
            System.out.println();
        }
    }
    void displayValsad()
    {
        System.out.println("  "+"1 "+"2 "+" "+"3 "+"4 ");
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<6;j++)
            {
                System.out.print(bus_valsad[i][j]);
            }
            System.out.println();
        }
    }

    void bookSeat(int choice,int Tickets) 
    {
        switch(choice)
        {
            case 1:
            
            for(int i=0;i<Tickets;i++)
            {
            System.out.print("Enter seat number to book (e.g., A1): ");
            String seat = input.next().toUpperCase();

            if (seat.length() == 2) 
            {
                char rowChar = seat.charAt(0);
                int col = seat.charAt(1)-'1'+1; 

                if (rowChar >= 'A' && rowChar <= 'H' && col >= 1 && col <= 4) 
                {
                    int row = rowChar - 'A';
                    int column = (col >= 3 ? col + 1 : col);
                    if (bus_rajkot[row][column].equals("O ")) 
                    {
                        bus_rajkot[row][column]="X "; 
                        System.out.println("Seat " + seat + " booked successfully!");
                    }

                    else 
                    {
                        System.out.println("Seat " + seat + " is already booked.");
                        i--;
                    }
                } 
                else 
                {
                    System.out.println("Invalid seat number. Please try again.");
                    i--;
                }
            }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
            break;

            case 2:
            
            for(int i=0;i<Tickets;i++)
            {
            System.out.print("Enter seat number to book (e.g., A1): ");
            String seat = input.next().toUpperCase();

            if (seat.length() == 2) 
            {
                char rowChar = seat.charAt(0);
                int col = seat.charAt(1)-'1'+1; 

                if (rowChar >= 'A' && rowChar <= 'H' && col >= 1 && col <= 4) 
                {
                    int row = rowChar - 'A';
                    int column = (col >= 3 ? col + 1 : col);
                    if (bus_valsad[row][column].equals("O ")) 
                    {
                        bus_valsad[row][column]="X "; 
                        System.out.println("Seat " + seat + " booked successfully!");
                    }

                    else 
                    {
                        System.out.println("Seat " + seat + " is already booked.");
                        i--;
                    }
                } 
                else 
                {
                    System.out.println("Invalid seat number. Please try again.");
                    i--;
                }
            }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
            break;

            case 3:

            for(int i=0;i<Tickets;i++)
            {
            System.out.print("Enter seat number to book(Ex. A1): ");
            String seat=input.next().toUpperCase();

            if (seat.length()==2) 
            {
                char rowChar = seat.charAt(0);
                int col = seat.charAt(1)-'1'+1; 

                if (rowChar>='A' && rowChar<='H' && col>=1 && col<=4) 
                {
                    int row=rowChar - 'A';
                    int column=(col>=3? (col+1):col);
                    if (bus_jamnagar[row][column].equals("O ")) 
                    {
                        bus_jamnagar[row][column]="X "; 
                        System.out.println("Seat "+seat+" booked successfully!");
                    }

                    else 
                    {
                        System.out.println("Seat "+seat+" is already booked.");
                        i--;
                    }
                } 
                else 
                {
                    System.out.println("Invalid seat number. Please try again.");
                    i--;
                }
            }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
            break;
        }
    }


    void Destination()
    {
    System.out.print("\nSelect Destination: \n1. RAJKOT\n2. VALSAD\n3. JAMNAGAR\n-->");
    int choice = input.nextInt();
   
    switch(choice)
    {
        case 1: 
        {
            if(availableseats_in_rajkot==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_rajkot)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }
            availableseats_in_rajkot-=Tickets;
            System.out.println();
            displayrajkot();
            bookSeat(choice,Tickets);
            displayrajkot();
            System.out.print(availableseats_in_rajkot);
            break;
        }

        case 2:
        {
            if(availableseats_in_valsad==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_valsad)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }
            availableseats_in_valsad-=Tickets;
            System.out.println();
            displayValsad();
            bookSeat(choice,Tickets);
            displayValsad();
            break;
        }

        case 3:
        {
            if(availableseats_in_jamnagar==0)
            {
                System.out.print("No seats are available.");
                break;
            }
            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }

            
            if(Tickets>availableseats_in_jamnagar)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }
            availableseats_in_jamnagar-=Tickets;
            System.out.println();
            displayJamnagar();
            bookSeat(choice,Tickets);
            displayJamnagar();
            break;
        } 
        
        default:
        {
            System.out.println("Please enter valid choice.");
            Destination();
        }
    }
    }

    void bookMore_bus()
    {

    System.out.print("\nSelect Destination: \n1. RAJKOT\n2. VALSAD\n3. JAMNAGAR\n-->");
    int choice = input.nextInt();

    switch(choice)
    {
        case 1: 
        {
            if(availableseats_in_rajkot==0)
            {
                System.out.print("No seats are available.");
                break;
            }
            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }

            if(Tickets>availableseats_in_rajkot)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }

            availableseats_in_rajkot-=Tickets;

            System.out.println();
            displayrajkot();
            bookSeat(choice,Tickets);
            displayrajkot();
            System.out.print(availableseats_in_rajkot);
            break;
        }

        case 2:
        {
            if(availableseats_in_valsad==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            

            if(Tickets>availableseats_in_valsad)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }
            availableseats_in_valsad-=Tickets;
            System.out.println();
            displayValsad();
            bookSeat(choice,Tickets);
            displayValsad();
            break;
        }

        case 3:
        {
            if(availableseats_in_jamnagar==0)
            {
                System.out.print("No seats are available.");
                break;
            }
            System.out.print("how many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }

            
            if(Tickets>availableseats_in_jamnagar)
            {
                System.out.print("not that much Tickets are left. ");
                break;
            }
            availableseats_in_jamnagar-=Tickets;
            System.out.println();
            displayJamnagar();
            bookSeat(choice,Tickets);
            displayJamnagar();
            break;
        } 
        
        default:
        {
            System.out.println("Please enter valid choice.");
            Destination();
        }
    }
    }
}

class Train
{
    Scanner input = new Scanner(System.in);
}

class Flight
{
    Scanner input = new Scanner(System.in);
    String[][] Flight_mumbai=new String[13][8];
    String[][] Flight_delhi=new String[13][8];
    String[][] Flight_kolkata=new String[13][8];
    int Tickets;
    int availableseats_in_mumbai=64;
    int availableseats_in_delhi=64;
    int availableseats_in_kolkata=64;

    void setseats()
    {
    char seatch_m=65;
    char seatch_d=65;
    char seatch_k=65;

    for(int i=0;i<13;i++)
    {
        for(int j=0;j<8;j++)
        {
            if(i<=3)
            {
                if(j==3 || j==4 || j==5)
                {
                    Flight_mumbai[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_mumbai[i][j]=String.valueOf((char)seatch_m)+".";
                    seatch_m++;
                }
                else
                {
                    Flight_mumbai[i][j]="O ";
                }
            }

            else if(i==4)
            {
                Flight_mumbai[4][0]="  ";
                Flight_mumbai[4][1]="1 ";
                Flight_mumbai[4][2]="2 ";
                Flight_mumbai[4][3]="3 ";
                Flight_mumbai[4][4]="  ";
                Flight_mumbai[4][5]="4 ";
                Flight_mumbai[4][6]="5 ";
                Flight_mumbai[4][7]="6 ";
            }

            else
            {
                if(j==4 )
                {
                    Flight_mumbai[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_mumbai[i][j]=String.valueOf((char)seatch_m)+".";
                    seatch_m++;
                }
                else
                {
                    Flight_mumbai[i][j]="O ";
                }
            }
        }
    }

    for(int i=0;i<13;i++)
    {
        for(int j=0;j<8;j++)
        {
            if(i<=3)
            {
                if(j==3 || j==4 || j==5)
                {
                    Flight_delhi[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_delhi[i][j]=String.valueOf((char)seatch_d)+".";
                    seatch_d++;
                }
                else
                {
                    Flight_delhi[i][j]="O ";
                }
            }

            else if(i==4)
            {
                Flight_delhi[4][0]="  ";
                Flight_delhi[4][1]="1 ";
                Flight_delhi[4][2]="2 ";
                Flight_delhi[4][3]="3 ";
                Flight_delhi[4][4]="  ";
                Flight_delhi[4][5]="4 ";
                Flight_delhi[4][6]="5 ";
                Flight_delhi[4][7]="6 ";
            }

            else
            {
                if(j==4 )
                {
                    Flight_delhi[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_delhi[i][j]=String.valueOf((char)seatch_d)+".";
                    seatch_d++;
                }
                else
                {
                    Flight_delhi[i][j]="O ";
                }
            }
        }
    }

    for(int i=0;i<13;i++)
    {
        for(int j=0;j<8;j++)
        {
            if(i<=3)
            {
                if(j==3 || j==4 || j==5)
                {
                    Flight_kolkata[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_kolkata[i][j]=String.valueOf((char)seatch_k)+".";
                    seatch_k++;
                }
                else
                {
                    Flight_kolkata[i][j]="O ";
                }
            }

            else if(i==4)
            {
                Flight_kolkata[4][0]="  ";
                Flight_kolkata[4][1]="1 ";
                Flight_kolkata[4][2]="2 ";
                Flight_kolkata[4][3]="3 ";
                Flight_kolkata[4][4]="  ";
                Flight_kolkata[4][5]="4 ";
                Flight_kolkata[4][6]="5 ";
                Flight_kolkata[4][7]="6 ";
            }

            else
            {
                if(j==4 )
                {
                    Flight_kolkata[i][j]="  ";
                }
                else if (j==0)
                {
                    Flight_kolkata[i][j]=String.valueOf((char)seatch_k)+".";
                    seatch_k++;
                }
                else
                {
                    Flight_kolkata[i][j]="O ";
                }
            }
        }
    }
    }

    void display_mumbai()
    {
        System.out.println("  "+"1 "+"2 "+"      "+"3 "+"4 ");
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(Flight_mumbai[i][j]);
            }
            System.out.println();
        }

        System.out.println("FIRST CLASS: A,B,C,D\nECCONOMY: E,F,G,H,I,J,K,L");
    }
    void display_delhi()
    {
        System.out.println("  "+"1 "+"2 "+"      "+"3 "+"4 ");
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(Flight_delhi[i][j]);
            }
            System.out.println();
        }

        System.out.println("FIRST CLASS: A,B,C,D\nECCONOMY: E,F,G,H,I,J,K,L");
    }
    void display_kolkata()
    {
        System.out.println("  "+"1 "+"2 "+"      "+"3 "+"4 ");
        for(int i=0;i<13;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(Flight_kolkata[i][j]);
            }
            System.out.println();
        }

        System.out.println("FIRST CLASS: A,B,C,D\nECCONOMY: E,F,G,H,I,J,K,L");
    }

    void bookseat(int choice,int Tickets)
    {
        
        switch(choice)
        {
            case 1:
            {
            for(int i=0;i<Tickets;i++)
            {
                System.out.print("Enter seat number to book (e.g., A1): ");
                String seat = input.next().toUpperCase();
    
                if (seat.length()==2) 
                {
                    char rowChar = seat.charAt(0);
                    int col = seat.charAt(1)-'1'+1;

                    int row = rowChar - 'A';
            
                    if(rowChar>='A' && rowChar<='D' && col>=1 && col<=4)
                    {
                        if(rowChar<='D')
                        {
                        int column = (col >= 3 ? col+3:col);
                        
                        if (Flight_mumbai[row][column].equals("O ")) 
                        {
                            Flight_mumbai[row][column]="X "; 
                            System.out.println("Seat "+seat+" booked successfully!");
                        }

                        else
                        {
                            System.out.println("Seat "+seat + " is already booked.");
                            i--;
                        }
                        }
                    }

                    else if(rowChar>='E' && rowChar<='L' && col>=1 && col<=6)
                    {
                        
                        int column = (col >=4 ? col+1:col);
                        int Row=row+1;
                    
                    if (Flight_mumbai[Row][column].equals("O ")) 
                    {
                        Flight_mumbai[Row][column]="X "; 
                        System.out.println("Seat " + seat + " booked successfully!");
                    }

                    else
                    {
                        System.out.println("Seat " + seat + " is already booked.");
                        i--;
                    }
                    }
                
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
                }
            break;
        }
            case 2:
            {
            for(int i=0;i<Tickets;i++)
            {
            System.out.print("Enter seat number to book (e.g., A1): ");
            String seat = input.next().toUpperCase();

            if (seat.length()==2) 
            {
                char rowChar = seat.charAt(0);
                int col = seat.charAt(1)-'1'+1;

                int row = rowChar - 'A';
        
                if(rowChar>='A' && rowChar<='D' && col>=1 && col<=4)
                {
                    if(rowChar<='D')
                    {
                    int column = (col >= 3 ? col+3:col);
                    
                    if (Flight_delhi[row][column].equals("O ")) 
                    {
                        Flight_delhi[row][column]="X "; 
                        System.out.println("Seat "+seat+" booked successfully!");
                    }

                    else
                    {
                        System.out.println("Seat "+seat + " is already booked.");
                        i--;
                    }
                    }
                }

                else if(rowChar>='E' && rowChar<='L' && col>=1 && col<=6)
                {
                    
                    int column = (col >=4 ? col+1:col);
                    int Row=row+1;
                
                if (Flight_delhi[Row][column].equals("O ")) 
                {
                    Flight_delhi[Row][column]="X "; 
                    System.out.println("Seat " + seat + " booked successfully!");
                }

                else 
                {
                    System.out.println("Seat " + seat + " is already booked.");
                    i--;
                }
                }
            
            else 
            {
                System.out.println("Invalid input format. Please try again.");
                i--;
            }
        }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
            break;
        }
            case 3:
            {
            for(int i=0;i<Tickets;i++)
            {
            System.out.print("Enter seat number to book (e.g., A1): ");
            String seat = input.next().toUpperCase();

            if (seat.length()==2) 
            {
                char rowChar = seat.charAt(0);
                int col = seat.charAt(1)-'1'+1;

                int row = rowChar - 'A';
        
                if(rowChar>='A' && rowChar<='D' && col>=1 && col<=4)
                {
                    if(rowChar<='D')
                    {
                    int column = (col >= 3 ? col+3:col);
                    
                    if (Flight_kolkata[row][column].equals("O ")) 
                    {
                        Flight_kolkata[row][column]="X "; 
                        System.out.println("Seat "+seat+" booked successfully!");
                    }

                    else
                    {
                        System.out.println("Seat "+seat + " is already booked.");
                        i--;
                    }
                    }
                }

                else if(rowChar>='E' && rowChar<='L' && col>=1 && col<=6)
                {
                    
                    int column = (col >=4 ? col+1:col);
                    int Row=row+1;
                
                if (Flight_kolkata[Row][column].equals("O ")) 
                {
                    Flight_kolkata[Row][column]="X "; 
                    System.out.println("Seat " + seat + " booked successfully!");
                }

                else 
                {
                    System.out.println("Seat " + seat + " is already booked.");
                    i--;
                }
                }
            
            else 
            {
                System.out.println("Invalid input format. Please try again.");
                i--;
            }
        }
                else 
                {
                    System.out.println("Invalid input format. Please try again.");
                    i--;
                }
            }
            break;
        }
    }
}

    void Destination()
    {
        System.out.print("\nSelect Destination: \n1. MUMBAI\n2. DELHI\n3. KOLKATA\n-->");
        int choice = input.nextInt();
   
    switch(choice)
    {
        case 1: 
        {
            if(availableseats_in_mumbai==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_mumbai)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_mumbai-=Tickets;
            display_mumbai();
            bookseat(choice,Tickets);
            display_mumbai();
            break;
        }

        case 2:
        {
            if(availableseats_in_delhi==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_delhi)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_delhi-=Tickets;
            display_delhi();
            bookseat(choice,Tickets);
            display_delhi();
            break;
        }

        case 3:
        {

            if(availableseats_in_kolkata==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_kolkata)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_kolkata-=Tickets;
            System.out.print("");
            setseats();
            display_kolkata();
            bookseat(choice,Tickets);
            display_kolkata();
            break;
        } 
        
        default:
        {
            System.out.println("Please enter valid choice.");
            Destination();
        }
    }
    }

    void bookMore_flight()
    {

        System.out.print("\nSelect Destination: \n1. MUMBAI\n2. DELHI\n3. KOLKATA\n-->");
        int choice = input.nextInt();

        switch(choice)
    {
        case 1: 
        {
            if(availableseats_in_mumbai==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_mumbai)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_mumbai-=Tickets;
            display_mumbai();
            bookseat(choice,Tickets);
            display_mumbai();
            break;
        }

        case 2:
        {
            if(availableseats_in_delhi==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_delhi)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_delhi-=Tickets;
            display_delhi();
            bookseat(choice,Tickets);
            display_delhi();
            break;
        }

        case 3:
        {
            if(availableseats_in_kolkata==0)
            {
                System.out.print("No seats are available.");
                break;
            }

            System.out.print("How many Tickets do you want: ");
            Tickets=input.nextInt();

            while(Tickets<1)
            {
                System.out.print("Please book atleast 1 ticket.\nEnter again: ");
                Tickets=input.nextInt();
            }
            
            if(Tickets>availableseats_in_kolkata)
            {
                System.out.print("Not that much Tickets are left. ");
                break;
            }
            availableseats_in_kolkata-=Tickets;
            display_kolkata();
            bookseat(choice,Tickets);
            display_kolkata();
            break;
        } 
        
        default:
        {
            System.out.println("Please enter valid choice.");
            Destination();
        }
    }
    }

}

class Transaction
{
    void ATM()
    {
        
    }

    void UPI()
    {

    }

    void Net_Banking()
    {

    }
    Scanner input = new Scanner(System.in);
    void payment()
    {
        System.out.print("\nSelect payment Method: \n1. ATM Card\n2. UPI");
        int choice=input.nextInt();

        switch(choice)
        {
            case 1:
            ATM();
            break;

            case 2:
            UPI();
            break;

            case 3:
            Net_Banking();
            break;

            default:
            System.out.print("Please enter valid choice.");
            payment();
        }
    }

}

class TMS 
{
    static String name;
    static String pass;
    static int allset;
    static int count=0;

    static void passverify() 
    {
        Scanner input = new Scanner(System.in);
        while(true) 
        {
            int small = 0, capital = 0, integers = 0;
            boolean valid = true;


            for (int i = 0; i < pass.length(); i++) 
            {

                char c = pass.charAt(i);
                if (c>='a' && c<='z') 
                {
                    small++;
                } 
                
                else if (c>='A' && c<='Z') 
                {
                    capital++;
                } 

                else if (c>='0' && c<='9') 
                {
                    integers++;
                } 

                else 
                {
                    valid = false;
                    break;
                }
            }

            if (!valid || small == 0 || capital == 0 || integers == 0) 
            {
                System.out.println("NOTE: Password must contain at least 1 capital letter, 1 small letter, and digits only.");
                System.out.print("Enter password again: ");
                pass = input.next();
            } 

            if (pass.length()!= 8)
            {
                System.out.println("NOTE: Password must contain exactly 8 characters.");
                System.out.print("Enter password again: ");
                pass = input.next();
            }

            else 
            {
                System.out.println("Password created successfully.");
                allset = 1;
                break;
            }
        }
    }

    static int BookOptions(int a)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("\nSELECT TRANSPORT TYPE: \n1. BUS\n2. TRAIN\n3. FLIGHT\n-->");
            int choice=input.nextInt();
            switch(choice)
            {
                case 1:
                {
                    return 1;
                }

                case 2:
                {
                    return 2;
                }

                case 3:
                {
                    return 3;
                }

                default:
                    return a;
            }
    }

    static void BookTickets(Bus obj_for_bus,Train obj_for_train,Flight obj_for_flight)
    {
        switch(BookOptions(0))
        {
            case 1:
            {
                count++;
                if(count==1)
                obj_for_bus.Destination();
                else
                obj_for_bus.bookMore_bus();
                break;
            }

            case 2:
            {
                
            }

            case 3:
            {
                count++;
                if(count==1)
                obj_for_flight.Destination();
                else
                obj_for_flight.bookMore_flight();
                break;
            }
        }
    }

    public static void main(String s[]) 
    {
        Bus obj_for_bus=new Bus();
        Train obj_for_train=new Train();
        Flight obj_for_flight=new Flight();

        Scanner input = new Scanner(System.in);
        System.out.println("__________________SwiftMove__________________");
        System.out.println("Please login first:");
        System.out.print("Enter Name: ");
        name = input.nextLine();

        while (true) 
        {
            System.out.print("NOTE: Password must contain at least 1 capital letter, 1 small letter, and digits only.\nPassword must contain exactly 8 characters.\nCreate a password: ");
            pass = input.next();

            if (pass.length()!= 8)
            {
                System.out.println("NOTE: Password must contain exactly 8 characters.");
            }

            else 
            {
                passverify();
            }

            if (allset == 1) 
            {
                break;
            }
        }

        obj_for_bus.storeValue();
        obj_for_flight.setseats();
        BookTickets(obj_for_bus,obj_for_train,obj_for_flight);

        while(true)
        {
            System.out.print("\n1. BOOK MORE TICKETS\n2. CANCEL TICKETS\n3. CONFIRM TICKET\n4. VIEW AVAILABLE SEATS\n5. LOG OUT\n-->");
            int choice=input.nextInt();

            switch(choice)
            {
                case 1:
                {
                    BookTickets(obj_for_bus,obj_for_train,obj_for_flight);
                    break;
                }
                case 2: 
                {
                    break;
                }
                case 3:
                {
                    break;
                }

                case 4:
                {
                    obj_for_bus.displayrajkot();
                    obj_for_bus.displayValsad();
                    obj_for_bus.displayJamnagar();
                    break;
                }
                case 5:
                {
                    System.out.println("Thanks ....");
                    return;
                }
                default:
                {
                System.out.println("Please enter valid choice.");
                break;
                }
            }
        }    
    }
}
