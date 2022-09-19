package com.navi;

import com.navi.model.Assets;
import com.navi.model.Debt;
import com.navi.model.Equity;
import com.navi.model.Gold;

public class AssetsCalculatoHelper {
	public static Assets getAssetsAfterChanges(Assets preAssets, float equityChange, float debtChange,
			float goldChange) {

		int preEquity = preAssets.getEquity().getAmount();
		int updatedEquityAmount = valueChange(preEquity, equityChange);

		int preDebt = preAssets.getDebt().getAmount();
		int updatedDebtAmount = valueChange(preDebt, debtChange);

		int preGold = preAssets.getGold().getAmount();
		int updatedGoldAmount = valueChange(preGold, goldChange);

		Assets assets = new Assets(
				new Debt(updatedDebtAmount, preAssets.getDebt().getPercentage(), preAssets.getDebt().getSip()),
				new Equity(updatedEquityAmount, preAssets.getEquity().getPercentage(), preAssets.getEquity().getSip()),
				new Gold(updatedGoldAmount, preAssets.getGold().getPercentage(), preAssets.getGold().getSip()));

		return assets;
	}

	public static void getAssetsAfterRebalancing(Assets preAssets) {

		int totalInvest = preAssets.getTotalAssetsValue();
		float equityPercent = preAssets.getEquity().getPercentage();
		float debtPercent = preAssets.getDebt().getPercentage();
		float goldPercent = preAssets.getGold().getPercentage();

		int updatedEquityAmount = valueChange(totalInvest, equityPercent);

		int updatedDebtAmount = valueChange(totalInvest, debtPercent);

		int updatedGoldAmount = valueChange(totalInvest, goldPercent);

		preAssets.getEquity().setAmount(updatedEquityAmount);
		preAssets.getDebt().setAmount(updatedDebtAmount);
		preAssets.getGold().setAmount(updatedGoldAmount);

	}

	public static int valueChange(int prevValue, float change) {

		int valueChange = (int) (prevValue * Math.abs(change) / 100);
		int updatedValue = 0;
		if (change < 0) {
			updatedValue = prevValue - valueChange;
		} else {
			updatedValue = prevValue + valueChange;
		}
		return updatedValue;
	}

	public static Assets getAssetsAfterSIP(Assets currentAssets) {
		Assets assetsAfterSIP = new Assets(
				new Debt(currentAssets.getDebt().getAmount() + currentAssets.getDebt().getSip(),
						currentAssets.getDebt().getPercentage(), currentAssets.getDebt().getSip()),
				new Equity(currentAssets.getEquity().getAmount() + currentAssets.getEquity().getSip(),
						currentAssets.getEquity().getPercentage(), currentAssets.getEquity().getSip()),
				new Gold(currentAssets.getGold().getAmount() + currentAssets.getGold().getSip(),
						currentAssets.getGold().getPercentage(), currentAssets.getGold().getSip()));

		return assetsAfterSIP;
	}
}
