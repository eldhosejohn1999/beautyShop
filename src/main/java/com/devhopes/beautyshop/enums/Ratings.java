package com.devhopes.beautyshop.enums;

public enum Ratings {

    BAD("Bad"),
    AVERAGE("Average"),
    GOOD("Good"),
    VERYGOOD("It was very good"),
    EXPENSIVE("Its too expensive"),
    CHEAP("Its too cheap and good"),
    VALUE_FOR_MONEY("Value for money"),
    HEALTHY("Its very healthy"),
    OTHER("Others");

    String value;

    Ratings(String value) {
        this.value = value;
    }
}
