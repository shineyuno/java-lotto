package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ticket;

import java.util.List;

public class ResultView {
    public static void printTicketCount(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public static void printTickeList(List<Ticket> ticketList) {
        ticketList.forEach(t -> System.out.println(t.getLottoNumbers()));
    }

    public static void printLottoResult(Lotto lotto) {
        System.out.println("\n당첨 통계\n---------");
        System.out.printf("3개 일치 (%d원) = %d개\n",Lotto.THREE_MATCH_RANK_REWARD, lotto.getThreeMatchRankCount());
        System.out.printf("4개 일치 (%d원) = %d개\n",Lotto.THREE_MATCH_RANK_REWARD, lotto.getFourMatchRankCount());
        System.out.printf("5개 일치 (%d원) = %d개\n",Lotto.THREE_MATCH_RANK_REWARD, lotto.getFiveMatchRankCount());
        System.out.printf("6개 일치 (%d원) = %d개\n",Lotto.THREE_MATCH_RANK_REWARD, lotto.getSixMatchRankCount());

    }
}
