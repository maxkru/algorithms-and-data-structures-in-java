package game;

abstract class Hero {

    protected int maxHealth;
    protected int currentHealth;
    protected String name;
    protected int damage;
    protected int addHeal;
    protected boolean alive;

    public Hero(int maxHealth, String name, int damage, int addHeal) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
        this.alive = true;
    }

    void hit(Hero target) {
        if (target == this) {
            System.out.println(name + " попробовал ударить себя. Не получилось.");
            return;
        }

        if (this.isAlive()) {
            if (target.isAlive()) {
                int damage = calculateDamageForHit();
                target.takeDamage(damage);
                System.out.printf("%s наносит %d урона герою %s\n", this.name, damage, target.name);
                target.info();
            } else {
                System.out.printf("%s попытался ударить мёртвого героя %s\n", this.name, target.name);
            }
        } else {
            System.out.println(name + ": мертвый герой бить не может!");
        }
    }

    abstract void healing(Hero target);

    void takeDamage(int damage) {
        if(!alive) {
            System.out.println("Герой уже мертвый!");
        } else {
            currentHealth -= damage;
            checkAlive();
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    void takeHeal(int health) {
        if (alive) {
            currentHealth += health;
            if (currentHealth > health)
                currentHealth = maxHealth;
        }
    }

    void info() {
        if (alive)
            System.out.printf("%s: %d/%d hp, %d урона\n", name, currentHealth, maxHealth, damage);
        else
            System.out.printf("%s: герой мертв\n", name);
    }

    private void checkAlive() {
        if (currentHealth <= 0) {
            alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    protected int calculateDamageForHit() {
        return damage;
    }
}
