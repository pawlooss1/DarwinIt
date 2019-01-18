package agh.cs.projekt2;

public enum Gender {
    FEMALE,
    MALE;

    @Override
    public String toString() {
        switch (this) {
            case FEMALE:
                return "F";
            case MALE:
                return "M";
        }
        return "";
    }
}
