package game;

class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    void hit(Hero target) {
        if (target != this) {
            if(maxHealth < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                target.takeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + target.name);
        }
    }

    @Override
    void healing(Hero target) {
        System.out.println("Войны не умеют лечить!");
    }
}
