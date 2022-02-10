package ir.maktab.homeserviceprovider.model;

public enum UserModelStatus {
    NEW(1),
    AWAITING_APPROVAL(2),
    CONFIRMED(3);

    private int value;

    private UserModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}