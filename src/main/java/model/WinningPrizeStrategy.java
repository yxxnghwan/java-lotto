package model;

public interface WinningPrizeStrategy {
    WinningPrize findWinningPrize(int matchCount, boolean matchBonus);

    int findMatchCount(WinningPrize winningPrize);

    boolean findMatchBonus(WinningPrize winningPrize);
}
