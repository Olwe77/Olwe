import java.util.*;

class Biblioteka
{
    String adres;
    ArrayList<Ksiazka> ksiazki;
    
    public Biblioteka(String adres)
    {
        this.adres=adres;
        ksiazki=new ArrayList<Ksiazka>(4);
    }
    public void dodajKsiazke(Ksiazka dodawana)
    {
        ksiazki.add(dodawana);
    }
    public static void wypiszGodzinyOtwarcia()
    {
        System.out.println("Biblioteki są otwarte codziennie od 9:00 do 17:00.");
    }
    public void wypiszAdres()
    {
        System.out.println(adres);
    }
    public void wypozyczKsiazke(String tytul)
    {
        boolean czyWyp=false;
        for(int i=0;i<ksiazki.size();i++)
        {
            if(ksiazki.get(i).dajTytul().equals(tytul))
            {
                if(!ksiazki.get(i).czyWypozyczona())
                {
                    ksiazki.get(i).wypozycz();
                    System.out.println("Udało się wypożyczyć Książkę: "+tytul);
                    return;
                }
                else
                    czyWyp=true;
            }
        }
        System.out.println((czyWyp)?"Przykro nam, książka jest już wypożyczona.":"Przykro nam, nie mamy takiej książki.");
    }
    public void oddajKsiazke(String tytul)
    {
        
        for(int i=0;i<ksiazki.size();i++)
        {
            if(ksiazki.get(i).dajTytul().equals(tytul))
            {
                if(ksiazki.get(i).czyWypozyczona())
                {
                    ksiazki.get(i).oddaj();
                    System.out.println("Udało się zwrócić Książkę: "+tytul);
                    return;
                }
            }
        }
        System.out.println("Nie udało się zwrócić Książki: "+tytul);
        
    }
    public void wypiszDostepneKsiazki()
    {
        for(int i=0;i<ksiazki.size();i++)
        {
            if(!ksiazki.get(i).czyWypozyczona())
            System.out.println(ksiazki.get(i).dajTytul());
        }
        if(ksiazki.size()==0)
        System.out.println("Brak książek w bibliotece");
    }
    public void wypiszZPelnymOpisem()
    {
       
       for(int i=0;i<ksiazki.size();i++)
        {
            System.out.println(ksiazki.get(i).dajTytul());
            System.out.println( (ksiazki.get(i).czyWypozyczona())?"Pozycja aktualnie wypozyczona":"Pozycja dostepna do wypozyczenia");
            System.out.println( ksiazki.get(i).dajRodzaj());
            System.out.println( ksiazki.get(i).dajOpis());
            System.out.println();
        }
        if(ksiazki.size()==0)
        System.out.println("Brak książek w bibliotece");
    }
    //Dodaj implementacje odpowiednich metod
    public static void main( String[] argumenty )
    {
        //Stworz dwie biblioteki
        Biblioteka pierwsza = new Biblioteka( "Armi Krajowej 24" );
        Biblioteka druga = new Biblioteka( "Plac Grunwaldzki 6" );

        //Dodaj cztery ksiazki do pierwszej biblioteki
        pierwsza.dodajKsiazke( new Ksiazka( "Pan Tadeusz" ) );
        pierwsza.dodajKsiazke( new Ksiazka( "Gra o Tron" ) );
        pierwsza.dodajKsiazke( new Ksiazka( "Tozsamosc Bourne'a" ) );
        pierwsza.dodajKsiazke( new Ksiazka( "Analiza Matematyczna" ) );

        //Wypisz godziny urzedowania bibliotek
        System.out.println( "Godziny otwarcia bibliotek ");
        wypiszGodzinyOtwarcia();
        System.out.println(); //pusta linijka

        System.out.println( "Adresy bibliotek " );
        pierwsza.wypiszAdres();
        druga.wypiszAdres();
        System.out.println(); //pusta linijka

        //wypozycz Pana Tadeusza z obu bibliotek
        System.out.println( "Wypozyczanie Pana Tadeusza" );
        pierwsza.wypozyczKsiazke( "Pan Tadeusz" );

        pierwsza.wypozyczKsiazke( "Pan Tadeusz" ); //sprobuj jeszcze raz

        druga.wypozyczKsiazke( "Pan Tadeusz" );

        System.out.println(); //pusta linijka

        //Wypisz dostepne tytuly w obu bibliotekach
        System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
        pierwsza.wypiszDostepneKsiazki();
        System.out.println(); //pusta linijka
        System.out.println( "Ksiazki z drugiej biblioteki" );
        druga.wypiszDostepneKsiazki();
        System.out.println();

        // zwroc Pana Tadeusza do biblioteki
        System.out.println( "Zwrot Pana Tadeusza" );
        pierwsza.oddajKsiazke( "Pan Tadeusz" );
        System.out.println();
        System.out.println( "Zwrot Pana Tadeusza" );
        pierwsza.oddajKsiazke( "Pan Tadeusz" );
        System.out.println();
        pierwsza.dodajKsiazke(new Ksiazka("Pan Tadeusz"));
        
        // Wypisz tytuly dostepne w pierwszej bibliotece
        System.out.println( "Ksiazki dostepne w pierwszej bibliotece" );
        pierwsza.wypiszDostepneKsiazki();
       /* 
        Romans a= new Romans("Przemineło z Wiatrem","Scarlett","Rhett","Wojna Secesyjna");
       // System.out.println(a.dajOpis());
       // System.out.println(a.dajRodzaj());
        Kryminal b=new Kryminal("Prawnik z Lincolna","Mick Haller","Louis Roulet","wzięty Adwokat","brutalny gwałt");
       // System.out.println(b.dajOpis());
       // System.out.println(b.dajRodzaj());
        KsiazkaNaukowa c=new KsiazkaNaukowa("Symfonia C++","Programowanie w c++","niedzielnych amatorow");
       // System.out.println(c.dajOpis());
       // System.out.println(c.dajRodzaj());
        KsiazkaFantastyczna d=new KsiazkaFantastyczna("Imie Wiatru","Kvothe","Nienazwana Kraina","sympatiaforma magii, która pozwala sympatykowi połączyć ze sobą dwa różne obiekty i spowodować zmiany w pierwszym ze związanych przedmiotów poprzez manipulację drugim z nich (na zasadzie porównywalnej do współczesnej zasady zachowania energii, stanu splątanego,moc imion");
       // System.out.println(d.dajOpis());
       // System.out.println(d.dajRodzaj());
        pierwsza.dodajKsiazke(a);
        pierwsza.dodajKsiazke(b);
        pierwsza.dodajKsiazke(c);
        pierwsza.dodajKsiazke(d);
        System.out.println( "Ksiazki w pierwszej bibliotece z opisami" );
        pierwsza.wypiszZPelnymOpisem();
        */
    }
}
