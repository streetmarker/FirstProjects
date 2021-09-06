package cinema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Cinema {
    int ticketCounter = 0;
    public static void main(String[] args) {
        //obj
        //rown ticketCounter = new rown();
        rown moneyCounter = new rown();
        Cinema tc = new Cinema();
        Scanner scan = new Scanner(System.in);
        // deklaracja drugich seatow
        ArrayList<Integer> rows2collect = new ArrayList<Integer>();
        ArrayList<Integer> rows2collectChoice2 = new ArrayList<Integer>();
        ArrayList<Integer> seats2collectChoice2 = new ArrayList<Integer>();
        ArrayList<Double> collectChoice2Number = new ArrayList<Double>();
        int rows2 = 0;
        ArrayList<Integer> seats2collect = new ArrayList<Integer>();
        int seats2 = 0;
        //
        ArrayList<Integer> allTickets = new ArrayList<Integer>();
        Integer nic = new Integer(1);
        ArrayList zajeteMiejscaR = new ArrayList();
        ArrayList zajeteMiejscaS = new ArrayList();

        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        int income = 0;
        float percentage = rows * seats;
        int cIncome = 0;
        /*
*/
//        menu
        for (int k = 0; k < 100; k++) {
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int choice = scan.nextInt();


            //

            if (choice == 1) {
                //sala z wyznaczonymi siedzeniami

                /*System.out.println();
                System.out.println("Enter a row number:");
                rows2 = scan.nextInt();
                System.out.println("Enter a seat number in that row:");
                seats2 = scan.nextInt();
                if (rows/2>=rows2)income=10;
                System.out.println();
                System.out.print("Ticket price: ");
                System.out.println("$" + income);
                System.out.println();
                */
                System.out.println("Cinema:");
                for (int i = 0; i <= rows; i++) {
                    for (int j = 0; j <= seats; j++) {
                        if (i == 0 && j == 0) {
                            System.out.print("  ");
                        } else if (j == 0) {
                            System.out.print(i + " ");
                        } else if (i == 0) {
                            System.out.print(j + " ");
                        } else if (rows2collect.size() > 0 && i == (int) rows2collect.get(0) && j == (int) seats2collect.get(0)) {
                            System.out.print("B ");
                        } else if (rows2collect.size() > 1 && i == (int) rows2collect.get(1) && j == (int) seats2collect.get(1)) {
                            System.out.print("B ");
                        } else if (rows2collect.size() > 2 && i == (int) rows2collect.get(2) && j == (int) seats2collect.get(2)) {
                            System.out.print("B ");
                        } else if (rows2collect.size() > 3 && i == (int) rows2collect.get(3) && j == (int) seats2collect.get(3)) {
                            System.out.print("B ");
                        } else if (rows2collect.size() > 4 && i == (int) rows2collect.get(4) && j == (int) seats2collect.get(4)) {
                            System.out.print("B ");
                        } else if (rows2collect.size() > 5 && i == (int) rows2collect.get(5) && j == (int) seats2collect.get(5)) {
                            System.out.print("B ");
                        }else if (rows2collect.size() > 6 && i == (int) rows2collect.get(6) && j == (int) seats2collect.get(6)) {
                            System.out.print("B ");
                        }else if (rows2collect.size() > 7 && i == (int) rows2collect.get(7) && j == (int) seats2collect.get(7)) {
                            System.out.print("B ");
                        }else if (rows2collect.size() > 8 && i == (int) rows2collect.get(8) && j == (int) seats2collect.get(8)) {
                            System.out.print("B ");
                        } else {
                            System.out.print("S ");
                        }
                    }
                    System.out.println();
                }

            }

            if (choice == 2) {
                //kupno biletu
                tc.ticketCounter++;
                System.out.println();
                System.out.println("Enter a row number:");
                rows2 = scan.nextInt();
                if(rows2>rows) System.out.println("Wrong input!");
                else {

                    System.out.println("Enter a seat number in that row:");
                    seats2 = scan.nextInt();
                    if (seats2 > seats) System.out.println("Wrong input!");
                    else {
                        if(//rows2collect.contains(rows2) && seats2collect.contains(seats2)
                           collectChoice2Number.contains((double) rows2+(double) seats2/10)) {
                            System.out.println("That ticket has already been purchased!");
                            //powtorka
                            System.out.println();
                            System.out.println("Enter a row number:");
                            rows2 = scan.nextInt();
                            if (rows2 > rows) System.out.println("Wrong input!");
                            else {

                                System.out.println("Enter a seat number in that row:");
                                seats2 = scan.nextInt();
                                if (seats2 > seats) System.out.println("Wrong input!");
                                else {


                                    //if (rows2collect.contains(rows2)==false || seats2collect.contains(seats2)==false) {
                                    //ticketCounter++;
                                    allTickets.add(nic);
                                    if (rows * seats <= 60) {
                                        income = 10;
                                    } else {
                                        int front = rows / 2;
                                        int back = rows - front;
                                        if (rows2 > front)
                                            income = 8;
                                        else income = 10;
                                    }
                                    cIncome += income;
                                    System.out.println();
                                    System.out.print("Ticket price: ");
                                    System.out.println("$" + income);
                                    System.out.println();
                                    moneyCounter.totalMoneyadd(income);
                                    rows2collectChoice2.add(rows2);
                                    seats2collectChoice2.add(seats2);
                                    rows2collect.add(rows2);
                                    seats2collect.add(seats2);
                                    collectChoice2Number.add((double) rows2+(double) seats2/10);
                                }
                            }
                        }

                       else {

                            allTickets.add(rows2);
                            if (rows * seats <= 60) {
                                income = 10;
                            } else {
                                int front = rows / 2;
                                int back = rows - front;
                                if(rows2>front)
                                income = 8;
                                else income = 10;
                            }
                            cIncome += income;
                            System.out.println();
                            System.out.print("Ticket price: ");
                            System.out.println("$" + income);
                            System.out.println();
                            moneyCounter.totalMoneyadd(income);
                            rows2collectChoice2.add(rows2);
                            seats2collectChoice2.add(seats2);
                            rows2collect.add(rows2);
                            seats2collect.add(seats2);
                            //tc.ticketCounter++;
                            moneyCounter.ticketCount();
                            collectChoice2Number.add((double) rows2+(double) seats2/10);
                        }
                            }
                        }

            }
            if (choice == 3) {
                System.out.printf("Number of purchased tickets: %d",tc.ticketCounter);
                System.out.println();
                float printPercentage = tc.ticketCounter/percentage*100;
                System.out.printf("Percentage:  %.2f",printPercentage);
                System.out.print("%");
                System.out.println();
                //((tc.ticketCounter%.3f / percentage%.3f) * 100)%.3f
                System.out.println("Current income: $" + moneyCounter.totalMoney);
                rown wynik = new rown();
                System.out.println("Total income: $" +wynik.totalIncome(rows,seats));
            }
            if (choice == 0) {
                return;
            }

        }
        //System.out.println(tc.ticketCounter);
    }
    public static class rown {
        public int tickets;
        int totalMoney;
        public rown() {
        }

        public int getTickets() {
            return tickets;
        }

        public void setTickets(int tickets) {
            this.tickets = tickets;
        }

        public int totalIncome(int row, int seat) {
            int ticket = 0;
            int capacity = row * seat;
            if (capacity < 60) {
                ticket = row * seat * 10;
            } else ticket = (row / 2+1) * seat * 8 + (row - row / 2 - 1) * seat * 10 ;


            return ticket;
        }
        public void ticketCount(){
            tickets+=1;
        }

        public void totalMoneyadd(int a) {
            totalMoney+=a;
        }
    }
}
