package machine;

import java.util.Scanner;

public class Machine {
    private int water;
    private int milk;
    private int beans;
    private int cups_of_coffee;
    private final int water_needed = 200;
    private final int milk_needed = 50;
    private final int beans_needed = 15;

    public int getWater_needed() {
        return water_needed;
    }

    public int getMilk_needed() {
        return milk_needed;
    }

    public int getBeans_needed() {
        return beans_needed;
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

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups_of_coffee() {
        return cups_of_coffee;
    }

    public void setCups_of_coffee(int cups_of_coffee) {
        this.cups_of_coffee = cups_of_coffee;
    }

    private int calculateWater() {
        return this.getWater() / this.getWater_needed();
    }

    private int calculateMilk() {
        return this.getMilk() / this.getMilk_needed();
    }

    private int calculateBeans() {
        return this.getBeans() / this.getBeans_needed();
    }

    private int calculateCup() {
        return Math.min(Math.min(this.calculateBeans(), this.calculateMilk()),
                this.calculateWater());
    }

    private String calculateAmount() {
        String phrase = "";

        if (this.calculateCup() > this.getCups_of_coffee()) {
            int aux = this.calculateCup() - this.getCups_of_coffee();
            phrase = "Yes, I can make that amount of coffee (and even " +
                    aux +
                    " more than that)";
        } else if (this.calculateCup() == this.getCups_of_coffee()) {
            phrase = "Yes, I can make that amount of coffee";
        } else {
            phrase = "No, I can make only " +
                    this.calculateCup() +
                    " cup(s) of coffee";
        }

        return phrase;
    }

    private void inputDialog() {
        this.waterDialog();
        this.milkDialog();
        this.beansDialog();
        this.cupsDialog();
    }

    private void waterDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int input = Integer.parseInt(scanner.nextLine());
        this.setWater(input);
    }

    private void milkDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of milk the coffee machine has:");
        int input = Integer.parseInt(scanner.nextLine());
        this.setMilk(input);
    }

    private void beansDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int input = Integer.parseInt(scanner.nextLine());
        this.setBeans(input);
    }

    private void cupsDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int input = Integer.parseInt(scanner.nextLine());
        this.setCups_of_coffee(input);
    }

    public void runMachine() {
        this.inputDialog();
        System.out.println(this.calculateAmount());
    }

}
