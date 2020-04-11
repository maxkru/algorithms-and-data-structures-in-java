package game;

import java.util.Random;

class Assassin extends Hero {

    int criticalHit;
    Random random = new Random();

    public Assassin(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
        this.criticalHit = random.nextInt(20);
    }

    @Override
    void hit(Hero target) {
        if (target != this) {
            if(maxHealth < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                target.takeDamage(damage + criticalHit);
            }
            System.out.println(this.name + " нанес урон " + target.name);
        }
    }

    @Override
    void healing(Hero target) {
        System.out.println("Убийцы не умеют лечить!");
    }
}