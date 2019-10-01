package pr02;

import java.util.List;

import pr02.messages.OceneProtos.Ocena;
import pr02.messages.OceneProtos.Ocene;
import pr02.messages.OceneProtos.Predmet;
import pr02.messages.OceneProtos.Predmeti;
import pr02.messages.OceneProtos.Student;
import pr02.messages.OceneProtos.Studenti;

import com.google.protobuf.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class DemoFactory {
  
  public static Studenti getStudenti() {
    Studenti.Builder sb = Studenti.newBuilder();
    for (Student s: studenti) {
      sb.addStudenti(s);
    }
    return sb.build();
  }

  public static Predmeti getPredmeti() {
    Predmeti.Builder pb = Predmeti.newBuilder();
    for (Predmet p: predmeti) {
      pb.addPredmeti(p);
    }
    return pb.build();
  }

  public static Ocene getOcene() {
    Ocene.Builder ob = Ocene.newBuilder();
    for (Ocena o: ocene) {
      ob.addOcene(o);
    }
    return ob.build();
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
    Student s1 = Student.newBuilder().setIndeks("e1234").setIme("Pera").setPrezime("Peric").build();
    Student s2 = Student.newBuilder().setIndeks("e1235").setIme("Zika").setPrezime("Zikic").build();
    Student s3 = Student.newBuilder().setIndeks("e1236").setIme("Mita").setPrezime("Mitic").build();
    Predmet p1 = Predmet.newBuilder().setSifra("SE001").setNaziv("Uvod u programiranje").build();
    Predmet p2 = Predmet.newBuilder().setSifra("SE002").setNaziv("Algoritmi i strukture podataka").build();
    Predmet p3 = Predmet.newBuilder().setSifra("SE003").setNaziv("Operativni sistemi").build();
    Ocena o1 = Ocena.newBuilder().setId(1).setPredmet(p1).setStudent(s1).setOcena(9).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 11).getTimeInMillis()/1000)).build();
    Ocena o2 = Ocena.newBuilder().setId(2).setPredmet(p2).setStudent(s1).setOcena(8).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 11).getTimeInMillis()/1000)).build();
    Ocena o3 = Ocena.newBuilder().setId(3).setPredmet(p3).setStudent(s1).setOcena(10).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 12).getTimeInMillis()/1000)).build();
    Ocena o4 = Ocena.newBuilder().setId(4).setPredmet(p1).setStudent(s2).setOcena(7).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 10).getTimeInMillis()/1000)).build();
    Ocena o5 = Ocena.newBuilder().setId(5).setPredmet(p2).setStudent(s2).setOcena(7).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 11).getTimeInMillis()/1000)).build();
    Ocena o6 = Ocena.newBuilder().setId(6).setPredmet(p3).setStudent(s2).setOcena(8).setDate(Timestamp.newBuilder().setSeconds(new GregorianCalendar(2019, 8, 12).getTimeInMillis()/1000)).build();
    s1 = Student.newBuilder(s1).addOcene(o1).build();
    s1 = Student.newBuilder(s1).addOcene(o2).build();
    s1 = Student.newBuilder(s1).addOcene(o3).build();
    s2 = Student.newBuilder(s2).addOcene(o1).build();
    s2 = Student.newBuilder(s2).addOcene(o2).build();
    s2 = Student.newBuilder(s2).addOcene(o3).build();
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