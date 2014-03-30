package br.com.futbid.domain.enumeration;

public enum PositionStyle {
    All("all", "All", 0), LWB_LB("LWB%2DLB", "LWB>>LB", 91), LB_LWB("LB%2DLWB", "LB>>LWB", 92), RWB_RB("RWB%2DRB",
	    "RWB>>RB", 93), RB_RWB("RB%2DRWB", "RB>>RwB", 94), LM_LW("LM%2DLW", "LM>>LW", 95), LW_LM("LW%2DLM",
	    "LW>>LM", 97), RM_RW("RM%2DRW", "RM>>RW", 96), RW_RM("RW%2DRM", "RW>>RM", 98), LW_LF("LW%2DLF", "LW>>LF",
	    99), LF_LW("LF%2DLW", "LF>>LW", 101), RW_RF("RW%2DRF", "RW>>RF", 100), RF_RW("RF%2DRW", "RF>>RW", 102), CM_CAM(
	    "CM%2DCAM", "CM>>CAM", 103), CAM_CM("CAM%2DCM", "CAM>>CM", 104), CM_CDM("CM%2DCDM", "CM>>CDM", 106), CDM_CM(
	    "CDM%2DCM", "CDM>>CM", 105), CAM_CF("CAM%2DCF", "CAM>>CF", 107), CF_CAM("CF%2DCAM", "CF>>CAM", 108), CF_ST(
	    "CF%2DST", "CF>>ST", 109), ST_CF("ST%2DCF", "ST>>CF", 110);

    private String value;
    private String display;
    private int cardSubTypeId;

    private PositionStyle(String value, String display, int cardSubTypeId) {
	this.value = value;
	this.display = display;
	this.cardSubTypeId = cardSubTypeId;
    }

    public String getValue() {
	return this.value;
    }

    public int getCardSubTypeId() {
	return this.cardSubTypeId;
    }

    public String toString() {
	return this.display;
    }

    public static PositionStyle getByValue(String value) {
	for (PositionStyle position : values()) {
	    if (position.getValue().equals(value)) {
		return position;
	    }
	}
	return All;
    }
}
