package com.game.src.enums;

public enum Drop {
	
	
	
	LetterE(0),
	LetterX(1),
	LetterT(2),
	LetterR(3),
	LetterA(4),
	ExtraBullet(5),
	ExtraSpeed(6),
	TripleShot(7),
	SingleShot(8),
	PurpleRankMarker(9),
	RedRankMarker(10),
	BlueRankMarker(11),
	GreenRankMarker(12),
	YellowRankMarker(13),
	OrangeRankMarker(14),
	TenDollarCoin(15),
	FiftyDollarCoin(16),
	HundredDollarCoin(17),
	TwoHundredDollarCoin(18);
	
	private int drop;

	Drop(int drop) {
		// TODO Auto-generated constructor stub
		this.drop=drop;
	}

	public int getDrop() {
		return drop;
	}

	public void setDrop(int drop) {
		this.drop = drop;
	}
	
	public static Drop fromId(int drop) {
        for (Drop type : values()) {
            if (type.getDrop() == drop) {
                return type;
            }
        }
        return null;
    }
	
	
	

}
