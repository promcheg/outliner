package promcheg.outliner.contoller.desc;

/**
 * 
 * @author waldemar
 *
 */
public enum KeyMapDesc {
	KEY_AT("@", 64),
	KEY_SQUARE_BRACKET_LEFT("[", 91),
	KEY_BACKSLASH("\\", 92),
	KEY_SQUARE_BRACKET_RIGHT("]", 93),
	KEY_CIRCUMFLEX_ACCENT("^", 94),
	KEY_UNDERSCORE("_", 95),
	KEY_GRAVE_ACCENT("`", 96),
	KEY_A("a", 97),
	KEY_B("b", 98),
	KEY_C("c", 99),
	KEY_D("d", 100),
	KEY_E("e", 101),
	KEY_F("f", 102),
	KEY_G("g", 103),
	KEY_H("h", 104),
	KEY_I("i", 105),
	KEY_J("j", 106),
	KEY_K("k", 107),
	KEY_L("l", 108),
	KEY_M("m", 109),
	KEY_N("n", 110),
	KEY_O("o", 111),
	KEY_P("p", 112),
	KEY_Q("q", 113),
	KEY_R("r", 114),
	KEY_S("s", 115),
	KEY_T("t", 116),
	KEY_U("u", 117),
	KEY_V("v", 118),
	KEY_W("w", 119),
	KEY_X("x", 120),
	KEY_Y("y", 121),
	KEY_Z("z", 122),
	KEY_LEFT_CURLY_BRACKET("{", 123),
	KEY_VERTICAL_BAR("|", 124),
	KEY_RIGHT_CURLY_BRACKET("}", 125);
	
	public String stringValue;
	public int intValue;

	KeyMapDesc(String stringValue, int intValue) {
		this.stringValue = stringValue;
		this.intValue = intValue;
	}
}
