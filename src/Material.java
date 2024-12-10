public class Material {
    int id;
    String name;
    double mark;

    public Material(int id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Mark: " + mark;
    }
}