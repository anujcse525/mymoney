package com.navi;

import java.util.LinkedHashMap;

import com.navi.exception.InvalidOptionException;
import com.navi.model.Assets;
import com.navi.utility.Months;

/*
 * This is the main class which is performing all the business logic operations
 */
public class AssetsCalculator {
	private static Assets assets = null;
	private static LinkedHashMap<String, Assets> monthAssetsMap = null;
	private static LinkedHashMap<String, Assets> monthAssetsMapAfterChanges = null;

	private AssetsCalculator() {
		monthAssetsMap = new LinkedHashMap<String, Assets>();
		monthAssetsMapAfterChanges = new LinkedHashMap<String, Assets>();
	}

	public static void initInstance() {
		if (monthAssetsMap == null) {
			synchronized (AssetsCalculator.class) {
				if (monthAssetsMap == null) {
					new AssetsCalculator();
				}
			}
		}
	}

	public static boolean allocation(String[] invest) {

		if (invest.length != 4) {
			return false;
		}

		assets = new Assets(Integer.parseInt(invest[1]), Integer.parseInt(invest[2]), Integer.parseInt(invest[3]));
		monthAssetsMap.put("JANUARY", assets);
		return true;

	}

	public static boolean sip(String[] sips) {
		if (sips.length != 4) {
			return false;
		}
		Assets assets = monthAssetsMap.get("JANUARY");
		assets.getEquity().setSip(Integer.parseInt(sips[1]));
		assets.getDebt().setSip(Integer.parseInt(sips[2]));
		assets.getGold().setSip(Integer.parseInt(sips[3]));
		return true;
	}

	public static boolean change(String[] changes) throws InvalidOptionException {
		if (changes.length != 5) {
			return false;
		}

		float equityChange = Float.parseFloat(changes[1].substring(0, changes[1].length() - 1));
		float debtChange = Float.parseFloat(changes[2].substring(0, changes[2].length() - 1));
		float goldChange = Float.parseFloat(changes[3].substring(0, changes[3].length() - 1));

		String month = changes[4];

		switch (Months.valueOf(month)) {
		case JANUARY:
			Assets assets = monthAssetsMap.get("JANUARY");
			Assets assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assets, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("JANUARY", assetsAfterChange);
			monthAssetsMap.put("FEBRUARY", assetsAfterChange);
			break;

		case FEBRUARY:
			Assets temp_assets = monthAssetsMap.get("FEBRUARY");
			Assets assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("FEBRUARY", assetsAfterChange);
			monthAssetsMap.put("MARCH", assetsAfterChange);
			break;

		case MARCH:
			temp_assets = monthAssetsMap.get("MARCH");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("MARCH", assetsAfterChange);
			monthAssetsMap.put("APRIL", assetsAfterChange);
			break;

		case APRIL:
			temp_assets = monthAssetsMap.get("APRIL");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("APRIL", assetsAfterChange);
			monthAssetsMap.put("MAY", assetsAfterChange);
			break;

		case MAY:
			temp_assets = monthAssetsMap.get("MAY");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("MAY", assetsAfterChange);
			monthAssetsMap.put("JUNE", assetsAfterChange);
			break;

		case JUNE:
			temp_assets = monthAssetsMap.get("JUNE");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			AssetsCalculatoHelper.getAssetsAfterRebalancing(assetsAfterChange);
			monthAssetsMapAfterChanges.put("JUNE", assetsAfterChange);
			monthAssetsMap.put("JULY", assetsAfterChange);
			break;

		case JULY:
			temp_assets = monthAssetsMap.get("JULY");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("JULY", assetsAfterChange);
			monthAssetsMap.put("AUGUST", assetsAfterChange);
			break;

		case AUGUST:
			temp_assets = monthAssetsMap.get("AUGUST");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("AUGUST", assetsAfterChange);
			monthAssetsMap.put("SEPTEMBER", assetsAfterChange);
			break;

		case SEPTEMBER:
			temp_assets = monthAssetsMap.get("SEPTEMBER");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("MARCH", assetsAfterChange);
			monthAssetsMap.put("OCTOBER", assetsAfterChange);
			break;

		case OCTOBER:
			temp_assets = monthAssetsMap.get("OCTOBER");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("MARCH", assetsAfterChange);
			monthAssetsMap.put("NOVEMBER", assetsAfterChange);
			break;

		case NOVEMBER:
			temp_assets = monthAssetsMap.get("NOVEMBER");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			monthAssetsMapAfterChanges.put("NOVEMBER", assetsAfterChange);
			monthAssetsMap.put("DECEMBER", assetsAfterChange);
			break;

		case DECEMBER:
			temp_assets = monthAssetsMap.get("DECEMBER");
			assetsAfterSIP = AssetsCalculatoHelper.getAssetsAfterSIP(temp_assets);
			assetsAfterChange = AssetsCalculatoHelper.getAssetsAfterChanges(assetsAfterSIP, equityChange, debtChange, goldChange);
			AssetsCalculatoHelper.getAssetsAfterRebalancing(assetsAfterChange);
			monthAssetsMapAfterChanges.put("DECEMBER", assetsAfterChange);
			monthAssetsMap.put("JANUARY", assetsAfterChange);
			break;

		default:
			throw new InvalidOptionException("Wrong option");

		}
		return true;
	}

	public static void balance(String[] month) {
		if (month.length != 2) {
			return;
		}
		Assets assets = monthAssetsMapAfterChanges.get(month[1]);
		System.out.println(assets);
	}

	public static void rebalance() {
		if (monthAssetsMapAfterChanges.size() >= 6) {
			if (monthAssetsMapAfterChanges.size() < 12) {
				Assets assets = monthAssetsMapAfterChanges.get("JUNE");
				System.out.println(assets);
			} else {
				Assets assets = monthAssetsMapAfterChanges.get("DECEMBER");
				System.out.println(assets);
			}
		} else {
			System.out.println("");
		}

	}

}
