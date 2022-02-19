package ir.maktab.homeserviceprovider.domain.model.user;

public enum UserModelStatus {
    NEW(1),
    AWAITING_APPROVAL(2),
    CONFIRMED(3);

    private final int value;

    UserModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}