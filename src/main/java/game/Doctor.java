package game;

class Doctor extends Hero {

    public Doctor(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    void hit(Hero target) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero target) {
        target.takeHeal(addHeal);
        System.out.printf("%s восстанавливает %d здоровья герою %s\n", this.name, this.addHeal, target.name);
        target.info();
    }
}
