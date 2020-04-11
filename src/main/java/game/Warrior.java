package game;

class Warrior extends Hero {

    public Warrior(int health, String type, int damage, int addHeal) {
        super(health, type, damage, addHeal);
    }

    @Override
    void healing(Hero target) {
        System.out.println("Войны не умеют лечить!");
    }
}
