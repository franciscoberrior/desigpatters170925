package patterns.domain.enums;

public enum BookTypeEnum {
  FICTION,
  NOT_FICTION;

  public static BookTypeEnum fromString(String value) {
    for (BookTypeEnum type : BookTypeEnum.values()) {
      if (type.name().equalsIgnoreCase(value)) {
        return type;
      }
    }
    throw new IllegalArgumentException("No enum constant " + BookTypeEnum.class.getCanonicalName() + "." + value);
  }
}
