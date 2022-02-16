package ir.maktab.homeserviceprovider.model.user;

public enum UserModelStatus {
    NEW(1),
    AWAITING_APPROVAL(2),
    CONFIRMED(3);

    private int value;

    UserModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}