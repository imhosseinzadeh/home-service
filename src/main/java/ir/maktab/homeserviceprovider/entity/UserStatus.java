package ir.maktab.homeserviceprovider.entity;

public enum UserStatus {
    NEW(1),
    AWAITING_APPROVAL(2),
    CONFIRMED(3);

    private int value;

    private UserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}