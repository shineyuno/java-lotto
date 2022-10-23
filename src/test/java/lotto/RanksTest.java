package lotto;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @Test
    void rankedWinningNumbers() {
        List<Ticket> ticketList = new ArrayList<>();
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(ticketNumbers);
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        List<Integer> lottoWinnigNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        lotto.rankedWinningNumbers(lottoWinnigNumbers);

        Ranks ranks = lotto.rankedWinningNumbers(lottoWinnigNumbers);
        EnumMap<Rank, Integer> rankMap = ranks.getRanks();

        assertThat(rankMap.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankMap.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankMap.get(Rank.SECOND)).isEqualTo(0);
        assertThat(rankMap.get(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    void getTotalWinningAmount() {
        List<Ticket> ticketList = new ArrayList<>();
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(ticketNumbers);
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        List<Integer> lottoWinnigNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        lotto.rankedWinningNumbers(lottoWinnigNumbers);

        Ranks ranks = lotto.rankedWinningNumbers(lottoWinnigNumbers);
        assertThat(ranks.getTotalWinningAmount()).isEqualTo(50000);

    }

    @ParameterizedTest(name = "{index}. 번호매칭 - args : [{arguments}]")
    @CsvSource(value = {"1,2,3,4,5,6:2000000000",
            "2,3,4,5,6,7:1500000",
            "3,4,5,6,7,8:50000",
            "4,5,6,7,8,9:5000",
            "5,6,7,8,9,10:0"}, delimiter = ':')
    void getTotalWinningAmount(String ticketNumberText, int expected) {

        String[] tokens = ticketNumberText.split(",");
        List<Integer> ticketNumbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Ticket ticket = new Ticket(ticketNumbers);

        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        List<Integer> lottoWinnigNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lotto.rankedWinningNumbers(lottoWinnigNumbers);

        Ranks ranks = lotto.rankedWinningNumbers(lottoWinnigNumbers);
        assertThat(ranks.getTotalWinningAmount()).isEqualTo(expected);
    }

    @Test
    void caculateIncomePercentage() {
        List<Ticket> ticketList = new ArrayList<>();
        List<Integer> ticketNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Ticket ticket = new Ticket(ticketNumbers);
        ticketList.add(ticket);

        Lotto lotto = new Lotto(ticketList);

        List<Integer> lottoWinnigNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        lotto.rankedWinningNumbers(lottoWinnigNumbers);


        Ranks ranks = lotto.rankedWinningNumbers(lottoWinnigNumbers);
        assertThat(ranks.caculateIncomePercentage()).isEqualTo(50);
    }
}
