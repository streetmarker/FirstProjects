import java.util.*;

class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        CoffeMachine newOrder = new CoffeMachine();
        newOrder.showInfo();
        newOrder.action();

    }

    public static class CoffeMachine {
        int water = 400;
        int milk = 540;
        int coffe_beans = 120;
        int cups_avaible = 9;
        int money = 550;

        public int calculateCups(){
            int returnCups = 0;
            int c_water = this.water/200;
            int c_milk = this.milk/50;
            int c_beans = this.coffe_beans/15;
            returnCups = Math.min(Math.min(c_water, c_milk),c_beans);
            return returnCups;
        }
        public void canDoIt(int want, int have){
            int left = have - want;
            if(want <= have){
                System.out.print("Yes, I can make that amount of coffee");
                if (want < have){
                    System.out.println(" (and even "+left+" more than that)");
                }
            }
            else System.out.println("No, I can make only "+have+" cup(s) of coffee");
        }
        public void showInfo(){
            System.out.println("The coffee machine has:\n" +
                    water+" ml of water\n" +
                    milk+" ml of milk\n" +
                    coffe_beans+" g of coffee beans\n" +
                    cups_avaible+" disposable cups\n" +
                    "$"+money+" of money");
        }
        public void action(){
            System.out.println("Write action (buy, fill, take): ");
            String choice = sc.nextLine();
            switch (choice){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1 -> {
                            this.water -= 250;
                            this.coffe_beans -= 16;
                            this.money += 4;
                        }
                        case 2 -> {
                            this.water -= 350;
                            this.milk -= 75;
                            this.coffe_beans -= 20;
                            this.money += 7;
                        }
                        case 3 -> {
                            this.water -= 200;
                            this.milk -= 100;
                            this.coffe_beans -= 12;
                            this.money += 6;
                        }
                        default -> {
                        }
                    }
                    this.cups_avaible -= 1;
                    showInfo();
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    this.water += sc.nextInt();
                    System.out.println("Write how many ml of milk you want to add: ");
                    this.milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    this.coffe_beans += sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    this.cups_avaible += sc.nextInt();
                    showInfo();
                    break;
                case "take":
                    System.out.println("I gave you $"+this.money);
                    this.money = 0;
                    showInfo();
                    break;
                default:
                    break;
            }
        }
        public CoffeMachine() {
        }


        public int getWater() {
            return water;
        }

        public void setWater(int water) {
            this.water = water;
        }

        public int getMilk() {
            return milk;
        }

        public void setMilk(int milk) {
            this.milk = milk;
        }

        public int getCoffe_beans() {
            return coffe_beans;
        }

        public void setCoffe_beans(int coffe_beans) {
            this.coffe_beans = coffe_beans;
        }



    }
}