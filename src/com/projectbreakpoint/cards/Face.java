package com.projectbreakpoint.cards;

enum Face {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    KING(12),
    QUEEN(13),
    JOKER(14);

    private int value;
    Face(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String face = super.toString().toLowerCase();
        face = face.substring(0, 1).toUpperCase() + face.substring(1);
        return face;
    }

    public static Face getFace(int value) throws Exception {
        for(Face face: Face.values()) {
            if(face.value == value) {
                return face;
            }
        }
        throw new Exception("Invalid numeric face value, must be between 1-14");
    }

}
