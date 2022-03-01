package ir.maktab.homeserviceprovider.domain.model.order;

public enum OrderModelStatus {
    WAIT_FOR_EXPERTS_SUGGESTIONS(1),
    WAIT_FOR_ACCEPT_EXPERT_OFFER(2),
    WAIT_FOR_EXPERT_TO_COME_TO_YOUR_PLACE(3),
    STARTED(4),
    DONE(5),
    PAID(6);

    private final int value;

    OrderModelStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}