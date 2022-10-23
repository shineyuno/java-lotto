package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NO_MATCH(0, 0);

    private final int matchCount;
    private final int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findFirst()
                .orElse(NO_MATCH);

    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int calculatePrize(int count) { return money * count; }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

}