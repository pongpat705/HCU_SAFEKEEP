package th.ac.hcu.constant;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static class PARAMETER_GROUP_NAME {
    	public static List<String> GROUPS() {
    		List<String> list = new ArrayList<>();
    		list.add(GE_QUESTION);
    		list.add(Q_01);
    		list.add(Q_02);
    		list.add(Q_03);
    		list.add(Q_04);
    		list.add(Q_05);
    		list.add(Q_06);
    		list.add(Q_07);
    		list.add(Q_08);
    		list.add(Q_09);
			return list;
    	}
    	public static List<String> COMBOS() {
    		List<String> list = new ArrayList<>();
    		list.add(COMBO_SELF_HELP);
    		list.add(COMBO_SPECIAL_TOOL);
    		list.add(COMBO_RESIDENCE);
    		list.add(COMBO_DRUG_ALLERGY);
    		list.add(COMBO_DRUG_USING);
    		list.add(COMBO_DRUG_PROBLEM);
			return list;
    	}
		public static final String COMBO_SELF_HELP = "COMBO_SELF_HELP";
		public static final String COMBO_SPECIAL_TOOL = "COMBO_SPECIAL_TOOL";
		public static final String COMBO_RESIDENCE = "COMBO_RESIDENCE";
		public static final String COMBO_DRUG_ALLERGY = "COMBO_DRUG_ALLERGY";
		public static final String COMBO_DRUG_USING = "COMBO_DRUG_USING";
		public static final String COMBO_DRUG_PROBLEM = "COMBO_DRUG_PROBLEM";
		public static final String GE_QUESTION = "GE_QUESTION";
		public static final String Q_01 = "Q_01";
		public static final String Q_02 = "Q_02";
		public static final String Q_03 = "Q_03";
		public static final String Q_04 = "Q_04";
		public static final String Q_05 = "Q_05";
		public static final String Q_06 = "Q_06";
		public static final String Q_07 = "Q_07";
		public static final String Q_08 = "Q_08";
		public static final String Q_09 = "Q_09";
		
	}
}
