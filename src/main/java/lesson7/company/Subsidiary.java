package lesson7.company;

public class Subsidiary {
    final int id;
    final int parentId;
    final double actual;
    final double forecast;

    public Subsidiary(int id, int parentId, double actual, double forecast) {
        this.id = id;
        this.parentId = parentId;
        this.actual = actual;
        this.forecast = forecast;
    }
}
