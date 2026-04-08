class MethodOverriding
{
    void famousfood()
    {
        System.out.println("Famous food of this hill station");
    }

    void famousfor()
    {
        System.out.println("This hill station is famous for its beauty");
    }
}

class Manali extends MethodOverriding
{
    void famousfood()
    {
        System.out.println("Manali is famous for Siddu");
    }

    void famousfor()
    {
        System.out.println("Manali is famous for snow mountains and adventure sports");
    }
}

class Mussoorie extends MethodOverriding
{
    void famousfood()
    {
        System.out.println("Mussoorie is famous for Momos and Maggi");
    }

    void famousfor()
    {
        System.out.println("Mussoorie is famous for hills and pleasant weather");
    }
}

class Gulmarg extends MethodOverriding
{
    void famousfood()
    {
        System.out.println("Gulmarg is famous for Kashmiri Pulao");
    }

    void famousfor()
    {
        System.out.println("Gulmarg is famous for skiing and snow-covered landscapes");
    }
}

public class Method_Overriding
{
    public static void main(String[] args)
    {
        MethodOverriding h;

        h = new Manali();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Mussoorie();
        h.famousfood();
        h.famousfor();

        System.out.println();

        h = new Gulmarg();
        h.famousfood();
        h.famousfor();
    }
}