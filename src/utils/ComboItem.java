package utils;

public class ComboItem
{
  private String key;
  private Integer value;

  public ComboItem(String key, Integer value)
  {
    this.key = key;
    this.value = value;
  }

  @Override
  public String toString()
  {
    return key;
  }

  public String getKey()
  {
    return key;
  }

  public Integer getValue()
  {
    return value;
  }
}