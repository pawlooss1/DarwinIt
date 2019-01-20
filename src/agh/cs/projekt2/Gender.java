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

    public boolean isOppositeGender(Gender gender) {
        switch (this) {
            case MALE:
                if (gender == MALE)
                    return false;
                else
                    return true;
            case FEMALE:
                if (gender == FEMALE)
                    return false;
                else
                    return true;
        }
        return false;
    }
}
