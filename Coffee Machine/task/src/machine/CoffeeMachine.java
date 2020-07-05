package machine;

import java.util.Scanner;

public class CoffeeMachine {
    String action;
    Scanner scanner;
    private int water;
    private int milk;
    private int beans;
    private int money;
    private int waterNeeded;
    private int milkNeeded;
    private int beansNeeded;
    private int moneyNeeded;
    private int cupsOfCoffee;
    private boolean power;
    private boolean enoughResources;
    private State state;

    public CoffeeMachine() {
        this.action = null;
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.money = 550;
        this.cupsOfCoffee = 9;
        this.power = true;
        this.enoughResources = false;
    }

    private String getAction() {
        return action;
    }

    private void setAction(String action) {
        this.action = action;
    }

    private int getWater() {
        return water;
    }

    private void setWater(int water) {
        this.water = water;
    }

    private int getMilk() {
        return milk;
    }

    private void setMilk(int milk) {
        this.milk = milk;
    }

    private int getBeans() {
        return beans;
    }

    private void setBeans(int beans) {
        this.beans = beans;
    }

    private int getCupsOfCoffee() {
        return cupsOfCoffee;
    }

    private void setCupsOfCoffee(int cupsOfCoffee) {
        this.cupsOfCoffee = cupsOfCoffee;
    }

    private int getWaterNeeded() {
        return waterNeeded;
    }

    private void setWaterNeeded(int waterNeeded) {
        this.waterNeeded = waterNeeded;
    }

    private int getMilkNeeded() {
        return milkNeeded;
    }

    private void setMilkNeeded(int milkNeeded) {
        this.milkNeeded = milkNeeded;
    }

    private int getBeansNeeded() {
        return beansNeeded;
    }

    private void setBeansNeeded(int beansNeeded) {
        this.beansNeeded = beansNeeded;
    }

    private int getMoneyNeeded() {
        return moneyNeeded;
    }

    private void setMoneyNeeded(int moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

    private int getMoney() {
        return money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public boolean isEnoughResources() {
        return enoughResources;
    }

    public void setEnoughResources(boolean enoughResources) {
        this.enoughResources = enoughResources;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private void updateWater() {
        setWater(getWater() - getWaterNeeded());
    }

    private void updateMilk() {
        setMilk(getMilk() - getMilkNeeded());
    }

    private void updateBeans() {
        setBeans(getBeans() - getBeansNeeded());
    }

    private void updateCupsOfCoffee() {
        setCupsOfCoffee(getCupsOfCoffee() - 1);
    }

    private void updateMoney() {
        setMoney(getMoney() + getMoneyNeeded());
    }

    private boolean enoughWater() {
        return getWater() / getWaterNeeded() > 0;
    }

    private boolean enoughMilk() {
        if (getMilkNeeded() == 0) {
            return true;
        } else {
            return getMilk() / getMilkNeeded() > 0;
        }
    }

    private boolean enoughBeans() {
        return getBeans() / getBeansNeeded() > 0;
    }

    private boolean enoughCup() {
        return getCupsOfCoffee() > 0;
    }

    private void buyMenu() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        var option = scanner.nextLine();
        if (!option.equals("back")) {
            setupBuyOptions(Integer.parseInt(option));
            calculateResources();
            if (isEnoughResources()) {
                makeCoffee();
            }
        }
    }

    private void calculateResources() {
        boolean water = enoughWater();
        boolean milk = enoughMilk();
        boolean beans = enoughBeans();
        boolean cup = enoughCup();
        if (!water) {
            System.out.println("Sorry, not enough water!");
            setEnoughResources(false);
        } else if (!milk) {
            System.out.println("Sorry, not enough milk!");
            setEnoughResources(false);
        } else if (!beans) {
            System.out.println("Sorry, not enough beans!");
            setEnoughResources(false);
        } else if (!cup) {
            System.out.println("Sorry, not enough cups!");
            setEnoughResources(false);
        } else {
            setEnoughResources(true);
        }
    }

    private void setupBuyOptions(int option) {
        switch (option) {
            // espresso
            case 1:
                setupCoffee(250, 16, 0, 4);
                break;
            // latte
            case 2:
                setupCoffee(350, 20, 75, 7);
                break;
            // cappuccino
            case 3:
                setupCoffee(200, 12, 100, 6);
                break;
            default:
                break;
        }
    }

    private void setupCoffee(int water, int beans, int milk, int cost) {
        setWaterNeeded(water);
        setBeansNeeded(beans);
        setMilkNeeded(milk);
        setMoneyNeeded(cost);
    }

    private void makeCoffee() {
        updateWater();
        updateMilk();
        updateBeans();
        updateCupsOfCoffee();
        updateMoney();
        System.out.println();
    }

    private void fillMenu() {
        fillWater();
        fillMilk();
        fillBeans();
        fillCupsOfCoffee();
        System.out.println();
    }

    private void fillCupsOfCoffee() {
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print("> ");
        var cups = scanner.nextInt();
        setCupsOfCoffee(getCupsOfCoffee() + cups);
    }

    private void fillBeans() {
        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print("> ");
        var beans = scanner.nextInt();
        setBeans(getBeans() + beans);
    }

    private void fillMilk() {
        System.out.print("> ");
        System.out.println("Write how many ml of milk do you want to add:");
        var milk = scanner.nextInt();
        setMilk(getMilk() + milk);
    }

    private void fillWater() {
        System.out.println("Write how many ml of water do you want to add:");
        System.out.print("> ");
        var water = scanner.nextInt();
        setWater(getWater() + water);
    }

    private void takeMenu() {
        System.out.println("I gave you " + getMoney());
        setMoney(0);

    }

    private void mainMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print("> ");
        readAction();
    }

    private void readAction() {
        setAction(scanner.nextLine());
        switch (this.getAction()) {
            case "buy":
                buyMenu();
                break;
            case "fill":
                fillMenu();
                break;
            case "take":
                takeMenu();
                break;
            case "remaining":
                System.out.println(this.toString());
                break;
            case "exit":
                setPower(false);
                break;
        }
    }

    public void use() {
        while (isPower()) {
            mainMenu();
        }
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cupsOfCoffee + " of disposable cups\n" +
                money + " of money\n";
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.use();
    }

}
