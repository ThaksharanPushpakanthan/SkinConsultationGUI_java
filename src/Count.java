class count

{

    int i;

    public void display()

    {

        System.out.println(i);

    }

}



class B extends count

{

    int j;

    public void display()

    {

        System.out.println(j);

    }

}



class Dynamic_dispatch

{

    public static void main(String args[])

    {

        B obj2 = new B();

        obj2.i = 1;

        obj2.j = 2;

        count r;

        r = obj2;

        r.display();

    }

}