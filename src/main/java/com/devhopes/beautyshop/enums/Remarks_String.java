package com.devhopes.beautyshop.enums;

public enum Remarks_String {
    NO_MORE_SLOTS("No more slots available for this item"),
    ITEM_NOT_AVAILABLE("Item not available"),
    ITEM_NOT_FOUND("Item not found"),
    THANKS_REMARKS("Thanks for booking, will see you in the shop"),
    SLOT_ALREADY_BOOKED("Slot is already booked"),
    THANKS_WAIT_FOR_CALL("Thanks for the booking and please wait for the call.");

    public String value;

    Remarks_String(String value) {
        this.value = value;
    }
}
