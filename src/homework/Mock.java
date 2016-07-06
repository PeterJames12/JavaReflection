package homework;


import java.lang.reflect.Method;
import java.text.MessageFormat;

public class Mock {

    public static void main(String[] args) throws NoSuchMethodException {

        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();
        new Dumper().dumper();

        new Dumper().shut();
        new Dumper().shut();
        new Dumper().shut();
        new Dumper().shut();
        new Dumper().shut();

        Dumper dumper = new Dumper();

        Class<Dumper> homeClass = Dumper.class;

        Method declaredMethods = homeClass.getDeclaredMethod("dumper");

        System.out.println(MessageFormat.format("{0} was invoked {1} times", declaredMethods, dumper.idForDumper));
        System.out.println(MessageFormat.format("{0} was invoked {1} times", declaredMethods, dumper.idForShut));
    }
}
