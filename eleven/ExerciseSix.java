package eleven;

import java.util.Hashtable;

public class ExerciseSix {
  public static boolean sameNumber(int[] a, int[] b) {
    Hashtable ht = new Hashtable<>(a.length);

    // for (int i = 0; i < a.length; i++) 
    //   ht.put(a[i]);
      
    for (int i = 0; i < b.length; i++)
      if (!ht.contains(b[i]))
        return false;

    return true;
  }
}
