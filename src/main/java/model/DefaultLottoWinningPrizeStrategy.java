package model;

import java.util.HashMap;
import java.util.Map;

public class DefaultLottoWinningPrizeStrategy implements WinningPrizeStrategy {

    private static final Map<Integer, WinningPrize> MATCH_COUNT_WINNING_PRIZE_INFO = new HashMap<>() {{
        put(6, WinningPrize.FIRST);
        put(5, WinningPrize.THIRD);
        put(4, WinningPrize.FOURTH);
        put(3, WinningPrize.FIFTH);
    }};

    private static final Map<WinningPrize, Integer> WINNING_PRIZE_MATCH_COUNT_INFO = new HashMap<>() {{
        put(WinningPrize.FIRST, 6);
        put(WinningPrize.SECOND, 5);
        put(WinningPrize.THIRD, 5);
        put(WinningPrize.FOURTH, 4);
        put(WinningPrize.FIFTH, 3);
    }};

    @Override
    public WinningPrize winningPrize(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return WinningPrize.SECOND;
        }
        return MATCH_COUNT_WINNING_PRIZE_INFO.get(matchCount);
    }

    @Override
    public int matchCount(WinningPrize winningPrize) {
        return WINNING_PRIZE_MATCH_COUNT_INFO.get(winningPrize);
        /*if (winningPrize.equals(WinningPrize.SECOND)) {
            return 5;
        }
        return MATCH_COUNT_WINNING_PRIZE_INFO.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(winningPrize))
                .map(Entry::getKey)
                .findAny()
                .orElse(0);*/
    }

    @Override
    public boolean matchBonus(WinningPrize winningPrize) {
        return winningPrize.equals(WinningPrize.SECOND);
    }
}
