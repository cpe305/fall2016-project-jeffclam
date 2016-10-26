package db;

import java.util.Comparator;

public class JournalCompare implements Comparator<JournalEntry> {

  @Override
  public int compare(JournalEntry ent1, JournalEntry ent2) {
    return ent1.compareTo(ent2);
  }
}
