package db;

public class JournalEntry implements Comparable<JournalEntry> {

  private int entryNumber;

  public JournalEntry(int entry) {
    entryNumber = entry;
  }

  public int getEntryNumber() {
    return entryNumber;
  }

  public int compareTo(JournalEntry other) {
    return ((Integer) entryNumber).compareTo(other.getEntryNumber());
  }
}
