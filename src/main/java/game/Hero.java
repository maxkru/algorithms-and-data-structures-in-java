package game;

abstract class Hero {

    protected int maxHealth;
    protected int currentHealth;
    protected String name;
    protected int damage;
    protected int addHeal;

    public Hero(int maxHealth, String name, int damage, int addHeal) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    abstract void hit(Hero target);

    abstract void healing(Hero target);

    void takeDamage(int damage) {
        if(currentHealth < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            currentHealth -= damage;
        }

    }

    public int getMaxHealth() {
        return maxHealth;
    }

    void takeHeal(int health) {
        currentHealth += health;
        if (currentHealth > health)
            currentHealth = maxHealth;
    }

    void info() {
        System.out.println(name + " " + (currentHealth < 0 ? "Герой мертвый" : currentHealth) + " " + damage);
    }
}
