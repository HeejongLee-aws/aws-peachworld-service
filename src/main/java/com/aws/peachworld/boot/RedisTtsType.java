package com.aws.peachworld.boot;

public enum RedisTtsType {
    TTS_1(1),
    TTS_2(2),
    TTS_5(5),
    TTS_10(10),
    TTS_15(15),
    TTS_30(30),
    TTS_60(60),
    TTS_H12(12),
    TTS_D1(1),
    TTS_D7(7);

    private final long value;

    RedisTtsType(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
