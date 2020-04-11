package game;

import java.util.Random;

class Assassin extends Hero {

    private static final float CRIT_FACTOR = 2f;
    private float criticalHitChance;
    Random random = new Random();

    public Assassin(int health, String name, int damage, int addHeal, float criticalHitChance) {
        super(health, name, damage, addHeal);
        this.criticalHitChance = criticalHitChance;
    }

    @Override
    void healing(Hero target) {
        System.out.println("Убийцы не умеют лечить!");
    }

    @Override
    protected int calculateDamageForHit() {
        return (random.nextFloat() < criticalHitChance) ? (int) (this.damage * CRIT_FACTOR) : this.damage;
    }
}