package homework;

public class Dumper implements Mocked {

    static private int counterForDumper;
    static private int counterForShut;

    final int idForDumper = counterForDumper;
    final int idForShut = counterForShut;

    @Override
    public void dumper() {
        counterForDumper++;
        String test = "Just dumper";
    }

    @Override
    public void shut() {
        counterForShut++;
        String shut = "Just shut";
    }
}
