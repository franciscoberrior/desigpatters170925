package patterns.domain.enums;

public enum BookFormatEnum {
  PHISICAL,
  DIGITAL;

  public static BookFormatEnum fromString(String value) {
    for (BookFormatEnum format : BookFormatEnum.values()) {
      if (format.name().equalsIgnoreCase(value)) {
        return format;
      }
    }
    throw new IllegalArgumentException("No enum constant " + BookFormatEnum.class.getCanonicalName() + "." + value);
  }
}
