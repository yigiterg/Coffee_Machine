package machine;
import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;


    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }
    public void status(){
        System.out.println("\nThe coffee machine has:\n"+this.water+" of water\n" +
                ""+this.milk+" of milk\n"
                +this.beans+" of coffee beans\n"+
                this.cups+" of disposable cups\n$"+
                this.money+" of money\n");
    }
    public boolean isEnough(int request){
        if(request == 1){
            if(this.water >= 250 && this.beans >= 16){
                return true;
            }else
                return false;
        } else if(request == 2){
            if(this.water >=350 && this.milk >= 75 && this.beans >= 20){
                return true;
            }else
                System.out.println("Sorry, not enough water!\n");
                return false;
        }
        else if(request == 3){
            if(this.water >=200 && this.milk >=100 && this.beans >= 12){
                return true;
            }else
                return false;
        }
        else
            return false;

    }
    public void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String request = scanner.next();
        switch (request) {
            case "1":
                if (isEnough(1)) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    this.water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    this.cups--;
                    break;
                }
            case "2":
                if (isEnough(2)) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    this.cups--;
                    break;
                }
            case "3":
                if (isEnough(3)) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    this.cups--;
                    break;
                }
            default:
                break;
        }
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water do you want to add:");
        int water = scanner.nextInt();
        this.water += water;
        System.out.println("Write how many ml of milk do you want to add");
        int milk = scanner.nextInt();
        this.milk += milk;
        System.out.println("Write how many of grams of coffee beans do you want to add:");
        int coffee = scanner.nextInt();
        this.beans += coffee;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cup = scanner.nextInt();
        this.cups += cup;
       // status();
        System.out.println("");
    }

    public void take(){
        System.out.println("\nI gave you $"+ this.money+"\n");
        this.money = 0;
       // status();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean exit = false;
        while(!exit) {
            System.out.println("Write action (buy, fill, take,remaining,exit):");
            String request = scanner.nextLine();

            if (request.toLowerCase().equals("buy")) {
                //coffeeMachine.status();
                coffeeMachine.buy();
            } else if (request.toLowerCase().equals("fill")) {
                // coffeeMachine.status();
                coffeeMachine.fill();
            } else if (request.toLowerCase().equals("take")) {
               // coffeeMachine.status();
                coffeeMachine.take();
            } else if (request.toLowerCase().equals("remaining")) {
                coffeeMachine.status();
            } else if(request.toLowerCase().equals("exit")){
                exit = true;
            }


        }
    }

}
