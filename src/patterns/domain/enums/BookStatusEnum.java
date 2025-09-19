package patterns.domain.enums;

public enum BookStatusEnum {
  AVAILABLE,
  BORROWED;

  public static BookStatusEnum fromString(String value) {
    for (BookStatusEnum status : BookStatusEnum.values()) {
      if (status.name().equalsIgnoreCase(value)) {
        return status;
      }
    }
    throw new IllegalArgumentException("No enum constant " + BookStatusEnum.class.getCanonicalName() + "." + value);
  }
}
