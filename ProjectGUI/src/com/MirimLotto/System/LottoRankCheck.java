package com.MirimLotto.System;

import java.util.*;

public class LottoRankCheck {
	static int getLottoRank(int[] userNumbers, int[] winningNumbers) {
        // 당첨 번호를 Set으로 변환
		int bonusNumber = winningNumbers[6];
        Set<Integer> winningSet = new HashSet<>();
        for (int i = 0; i<winningNumbers.length-1; i++) {
            winningSet.add(winningNumbers[i]);
        }

        int matchCount = 0;
        for (int num : userNumbers) {
            if (winningSet.contains(num)) {
                matchCount++;
            }
        }

        boolean bonusMatch = false;
        for (int num : userNumbers) {
            if (num == bonusNumber) {
                bonusMatch = true;
                break;
            }
        }

        // 등수 판별
        switch (matchCount) {
            case 6:
                return 1; // 1등
            case 5:
                return bonusMatch ? 2 : 3; // 2등 또는 3등
            case 4:
                return 4; // 4등
            case 3:
                return 5; // 5등
            default:
                return 0; // 낙첨
        }
    }
}
