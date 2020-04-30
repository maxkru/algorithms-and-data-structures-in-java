package lesson7.company;

public class Subsidiary {
    final int id;
    final int parentId;
    final double actual;
    final double forecast;

    // в задании этого поля нет, но без него не обойтись
    final String name;

    public Subsidiary(int id, int parentId, String name, double actual, double forecast) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.actual = actual;
        this.forecast = forecast;
    }

    public double planCompletionPercent() {
        return actual / forecast * 100.;
    }
}
