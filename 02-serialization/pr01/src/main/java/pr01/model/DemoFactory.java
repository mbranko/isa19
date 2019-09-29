package pr01.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class DemoFactory {
  
  public static List<Student> getStudenti() {
    return studenti;
  }

  public static List<Predmet> getPredmeti() {
    return predmeti;
  }

  public static List<Ocena> getOcene() {
    return ocene;
  }

  public static Student getStudent(String indeks) {
    for (Student s: studenti)
      if (s.getIndeks().equalsIgnoreCase(indeks))
        return s;
    return null;
  }

  public static Predmet getPredmet(String sifra) {
    for (Predmet p: predmeti)
      if (p.getSifra().equalsIgnoreCase(sifra))
        return p;
    return null;
  }

  public static Ocena getOcena(int id) {
    for (Ocena o: ocene)
      if (o.getId() == id)
        return o;
    return null;
  }

  private static List<Student> studenti;
  private static List<Predmet> predmeti;
  private static List<Ocena> ocene;

  static {
    Student s1 = new Student("e1234", "Pera", "Peric");
    Student s2 = new Student("e1235", "Zika", "Zikic");
    Student s3 = new Student("e1236", "Mita", "Mitic");
    Predmet p1 = new Predmet("SE001", "Uvod u programiranje");
    Predmet p2 = new Predmet("SE002", "Algoritmi i strukture podataka");
    Predmet p3 = new Predmet("SE003", "Operativni sistemi");
    Ocena o1 = new Ocena(s1, p1, new GregorianCalendar(2019, 8, 10).getTime(), 9);
    Ocena o2 = new Ocena(s1, p2, new GregorianCalendar(2019, 8, 11).getTime(), 8);
    Ocena o3 = new Ocena(s1, p3, new GregorianCalendar(2019, 8, 12).getTime(), 10);
    Ocena o4 = new Ocena(s2, p1, new GregorianCalendar(2019, 8, 10).getTime(), 7);
    Ocena o5 = new Ocena(s2, p2, new GregorianCalendar(2019, 8, 11).getTime(), 7);
    Ocena o6 = new Ocena(s2, p3, new GregorianCalendar(2019, 8, 12).getTime(), 8);
    s1.getOcene().add(o1);
    s1.getOcene().add(o2);
    s1.getOcene().add(o3);
    s2.getOcene().add(o4);
    s2.getOcene().add(o5);
    s2.getOcene().add(o6);
    studenti = new ArrayList<>();
    studenti.add(s1);
    studenti.add(s2);
    studenti.add(s3);
    predmeti = new ArrayList<>();
    predmeti.add(p1);
    predmeti.add(p2);
    predmeti.add(p3);
    ocene = new ArrayList<>();
    ocene.add(o1);
    ocene.add(o2);
    ocene.add(o3);
    ocene.add(o4);
    ocene.add(o5);
    ocene.add(o6);
  }
}