package ir.maktab.homeserviceprovider.model;

public enum OrderModelStatus {
    WAITING_FOR_EXPERTS_SUGGESTIONS(1),
    WAITING_FOR_CHOICE_EXPERT(2),
    WAITING_FOR_EXPERT_TO_COME_TO_YOUR_PLACE(3),
    STARTED(3),
    DONE(4),
    PAID(5);

    private int value;

    private OrderModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}