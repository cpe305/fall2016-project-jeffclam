package db;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.utils.IndexType;

@Entity("moods")
@Indexes(@Index(fields = @Field(value = "$**", type = IndexType.TEXT)))
public class Mood {
  @Id
  private ObjectId id;
  private String value;
  private String category;
  private boolean negative;

  public Mood(String keyword) {
    this.value = keyword;
  }

  public Mood(String keyword, boolean negative) {
    this.value = keyword;
    this.negative = negative;
  }

  public boolean isNegative() {
    // if negative == true it will return true and vice versa
    return this.negative;
  }
  
  public void setNegative(boolean negative) {
    // if negative == true it will return true and vice versa
    this.negative = negative;
  }
  
  public String getName() {
    return this.value;
  }

  public void setName(String newKey) {
    this.value = newKey;
  }

  @Override
  public String toString() {
    String result = value + " is ";
    result += isNegative() ? "negative" : "positive";
    return result;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
