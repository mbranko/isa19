package pr01.container;

import javax.ejb.ApplicationException;

/**
 * Bacanje ovog izuzetka ce izazvati i opoziv (rollback) tekuce transakcije.
 * Ovo se postize ApplicationException anotacijom.
 * 
 * Sa stanovista rukovanja transakcijama razlikuju se dva tipa izuzetaka
 * - application: svi checked (koji se moraju hvatati) izuzeci
 * - system: svi unchecked (koji se ne moraju hvatati) i RemoteException
 * 
 * Application izuzeci ne obustavljaju tekucu transakciju osim ako se to
 * eksplicitno ne trazi pomocu ApplicationException anotacije i rollback
 * atributa postavljenog na true.
 * 
 * System izuzeci uvek opozivaju transakciju i potom se bean unistava (smatra
 * se da je zbog greske neupotrebljiv). System izuzetke ne treba koristiti
 * za dojavu gresaka u radu aplikacije.
 */
@ApplicationException(rollback=true)
public class MyException extends Exception {

  public MyException() {
    super();
  }
  public MyException(String message) {
    super(message);
  }
  public MyException(Throwable ex) {
    super(ex);
  }

  private static final long serialVersionUID = -1367630090912513944L;
}
