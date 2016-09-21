package com.spiders_skeletons_shenanigans.game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextChoice
{

	public static String findOption(String option) 
	{
		String choice = "";
		switch (option)
		{
			case "INTROtoGAME":
			{
				choice = setLine(1);
				return choice;
			}
			case "OUTCOMEofNAME":
			{
				choice = setLine(4);
				return choice;
			}
			case "O1CA":
			{
				choice = setLine(7);
				return choice;
			}
			case "O1CB":
			{
				choice = setLine(9);
				return choice;
			}
			case "O1CC":
			{
				choice = setLine(11);
				return choice;
			}
			case "INTROtoO2p1":
			{
				choice = setLine(14);
				return choice;
			}
			case "INTROtoO2p2":
			{
				choice = setLine(16);
				return choice;
			}
			case "O2CA":
			{
				choice = setLine(19);
				return choice;
			}
			case "O2CB":
			{
				choice = setLine(21);
				return choice;
			}
			case "OUTCOMEofO2CB":
			{
				choice = setLine(24);
				return choice;
			}
			case "INTROtoO3":
			{
				choice = setLine(27);
				return choice;
			}
			case "O3CA":
			{
				choice = setLine(30);
				return choice;
			}
			case "O3CB":
			{
				choice = setLine(32);
				return choice;
			}
			case "INTROtoO4":
			{
				choice = setLine(35);
				return choice;
			}
			case "O4CA":
			{
				choice = setLine(38);
				return choice;
			}
			case "O4CB":
			{
				choice = setLine(40);
				return choice;
			}
			case "OUTCOMEofO4CA":
			{
				choice = setLine(43);
				return choice;
			}
			case "OUTCOMEofO4CB":
			{
				choice = setLine(45);
				return choice;
			}
			case "TRANSITIONfrom4TO5p1":
			{
				choice = setLine(48);
				return choice;
			}
			case "TRANSITIONfrom4TO5p2":
			{
				choice = setLine(50);
				return choice;
			}
			case "TRANSITIONfrom4TO5p3":
			{
				choice = setLine(52);
				return choice;
			}
			case "TRANSITIONfrom4TO5p4":
			{
				choice = setLine(54);
				return choice;
			}
			case "TRANSITIONfrom4TO5p5":
			{
				choice = setLine(56);
				return choice;
			}
			case "TRANSITIONfrom4TO5p6":
			{
				choice = setLine(58);
				return choice;
			}
			case "TRANSITIONfrom4TO5p7":
			{
				choice = setLine(60);
				return choice;
			}
			case "INTROtoO5":
			{
				choice = setLine(63);
				return choice;
			}
			case "O5CA":
			{
				choice = setLine(66);
				return choice;
			}
			case "O5CB":
			{
				choice = setLine(68);
				return choice;
			}
			case "OUTCOMEofO5CA":
			{
				choice = setLine(71);
				return choice;
			}
			case "OUTCOMEofO5CB":
			{
				choice = setLine(73);
				return choice;
			}
			case "TRANSITIONfrom5TO6p1":
			{
				choice = setLine(76);
				return choice;
			}
			case "TRANSITIONfrom5TO6p2":
			{
				choice = setLine(78);
				return choice;
			}
			case "INTROtoO6":
			{
				choice = setLine(81);
				return choice;
			}
			case "O6CA":
			{
				choice = setLine(84);
				return choice;
			}
			case "O6CB":
			{
				choice = setLine(86);
				return choice;
			}
			case "O6CC":
			{
				choice = setLine(88);
				return choice;
			}
			case "OUTCOMEofO6CA":
			{
				choice = setLine(91);
				return choice;
			}
			case "OUTCOMEofO6CB":
			{
				choice = setLine(93);
				return choice;
			}
			case "OUTCOMEofO6CC":
			{
				choice = setLine(95);
				return choice;
			}
			case "FAILUREofO6":
			{
				choice = setLine(97);
				return choice;
			}
			case "INTROtoO7":
			{
				choice = setLine(100);
				return choice;
			}
			case "O7CA":
			{
				choice = setLine(103);
				return choice;
			}
			case "O7CB":
			{
				choice = setLine(105);
				return choice;
			}
			case "O7CC":
			{
				choice = setLine(107);
				return choice;
			}
			case "OUTCOMEofO7CA":
			{
				choice = setLine(110);
				return choice;
			}
			case "OUTCOMEofO7CB":
			{
				choice = setLine(112);
				return choice;
			}
			case "OUTCOMEofO7CC":
			{
				choice = setLine(114);
				return choice;
			}
			case "TRANSITIONfrom7TO8p1":
			{
				choice = setLine(117);
				return choice;
			}
			case "TRANSITIONfrom7TO8p2":
			{
				choice = setLine(119);
				return choice;
			}
			case "TRANSITIONfrom7TO8p3":
			{
				choice = setLine(121);
				return choice;
			}
			case "TRANSITIONfrom7TO8p4":
			{
				choice = setLine(123);
				return choice;
			}
			case "TRANSITIONfrom7TO8p5":
			{
				choice = setLine(125);
				return choice;
			}
			case "TRANSITIONfrom7TO8p6":
			{
				choice = setLine(127);
				return choice;
			}
			case "TRANSITIONfrom7TO8p7":
			{
				choice = setLine(129);
				return choice;
			}
			case "TRANSITIONfrom7TO8p8":
			{
				choice = setLine(131);
				return choice;
			}
			case "TRANSITIONfrom7TO8p9":
			{
				choice = setLine(133);
				return choice;
			}
			case "TRANSITIONfrom7TO8p10":
			{
				choice = setLine(135);
				return choice;
			}
			case "INTROtoO8":
			{
				choice = setLine(138);
				return choice;
			}
			case "O8CA":
			{
				choice = setLine(141);
				return choice;
			}
			case "O8CB":
			{
				choice = setLine(143);
				return choice;
			}
			case "O8CC":
			{
				choice = setLine(145);
				return choice;
			}
			case "OUTCOMEofO8CA":
			{
				choice = setLine(148);
				return choice;
			}
			case "OUTCOMEofO8CB":
			{
				choice = setLine(143);
				return choice;
			}
			case "OUTCOMEofO8CC":
			{
				choice = setLine(152);
				return choice;
			}
			case "INTROtoO9":
			{
				choice = setLine(157);
				return choice;
			}
			case "O9CA":
			{
				choice = setLine(160);
				return choice;
			}
			case "O9CB":
			{
				choice = setLine(162);
				return choice;
			}
			case "TRANSITIONfrom9TO10p1":
			{
				choice = setLine(165);
				return choice;
			}
			case "TRANSITIONfrom9TO10p2":
			{
				choice = setLine(167);
				return choice;
			}
			case "TRANSITIONfrom9TO10p3":
			{
				choice = setLine(169);
				return choice;
			}
			case "TRANSITIONfrom9TO10p4":
			{
				choice = setLine(171);
				return choice;
			}
			case "TRANSITIONfrom9TO10p5":
			{
				choice = setLine(173);
				return choice;
			}
			case "INTROtoO10":
			{
				choice = setLine(176);
				return choice;
			}
			case "O10CA":
			{
				choice = setLine(179);
				return choice;
			}
			case "O10CB":
			{
				choice = setLine(181);
				return choice;
			}
			case "OUTCOMEofO10CA":
			{
				choice = setLine(184);
				return choice;
			}
			case "OUTCOMEofO10CBsucceed":
			{
				choice = setLine(186);
				return choice;
			}
			case "OUTCOMEofO10CBfail":
			{
				choice = setLine(188);
				return choice;
			}
			case "TRANSITIONfrom10TO11p1":
			{
				choice = setLine(191);
				return choice;
			}
			case "TRANSITIONfrom10TO11p2":
			{
				choice = setLine(193);
				return choice;
			}
			case "INTROtoO11":
			{
				choice = setLine(196);
				return choice;
			}
			case "O11CA":
			{
				choice = setLine(199);
				return choice;
			}
			case "O11CB":
			{
				choice = setLine(201);
				return choice;
			}
			case "O11CC":
			{
				choice = setLine(203);
				return choice;
			}
			case "OUTCOMEofO11CAfail":
			{
				choice = setLine(206);
				return choice;
			}
			case "OUTCOMEofO11CA":
			{
				choice = setLine(208);
				return choice;
			}
			case "OUTCOMEofO11CB":
			{
				choice = setLine(210);
				return choice;
			}
			case "OUTCOMEofO11CBfail":
			{
				choice = setLine(1);
				return choice;
			}
			case "OUTCOMEofO11CC":
			{
				choice = setLine(212);
				return choice;
			}
			case "INTROtoO12":
			{
				choice = setLine(215);
				return choice;
			}
			case "O12CA":
			{
				choice = setLine(218);
				return choice;
			}
			case "O12CB":
			{
				choice = setLine(220);
				return choice;
			}
			case "O12CC":
			{
				choice = setLine(222);
				return choice;
			}
			case "OUTCOMEofO12CA":
			{
				choice = setLine(225);
				return choice;
			}
			case "OUTCOMEofO12CB":
			{
				choice = setLine(227);
				return choice;
			}
			case "OUTCOMEofO12CCp1":
			{
				choice = setLine(229);
				return choice;
			}
			case "OUTCOMEofO12CCp2":
			{
				choice = setLine(231);
				return choice;
			}
			case "TRANSITIONfrom12TO13p1":
			{
				choice = setLine(234);
				return choice;
			}
			case "TRANSITIONfrom12TO13p2":
			{
				choice = setLine(236);
				return choice;
			}
			case "TRANSITIONfrom12TO13p3":
			{
				choice = setLine(238);
				return choice;
			}
			case "TRANSITIONfrom12TO13p4":
			{
				choice = setLine(243);
				return choice;
			}
			case "TRANSITIONfrom12TO13p5":
			{
				choice = setLine(245);
				return choice;
			}
			case "INTROtoO13p1":
			{
				choice = setLine(248);
				return choice;
			}
			case "INTROtoO13p2":
			{
				choice = setLine(250);
				return choice;
			}
			case "O13CA":
			{
				choice = setLine(309);
				return choice;
			}
			case "INTROtoO13CA":
			{
				choice = setLine(253);
				return choice;
			}
			case "OUTCOMEofO13CAsucceed":
			{
				choice = setLine(255);
				return choice;
			}
			case "OUTCOMEofO13CAfail":
			{
				choice = setLine(257);
				return choice;
			}
			case "O13CB":
			{
				choice = setLine(312);
				return choice;
			}
			case "OUTCOMEofO13CB":
			{
				choice = setLine(259);
				return choice;
			}
			case "OUTCOMEofO13CBsucceed":
			{
				choice = setLine(261);
				return choice;
			}
			case "OUTCOMEofO13CBfail":
			{
				choice = setLine(263);
				return choice;
			}
			case "TRANSITIONfrom13TO14p1":
			{
				choice = setLine(266);
				return choice;
			}
			case "TRANSITIONfrom13TO14p2":
			{
				choice = setLine(268);
				return choice;
			}
			case "TRANSITIONfrom13TO14p3":
			{
				choice = setLine(270);
				return choice;
			}
			case "TRANSITIONfrom13TO14p4TRUE":
			{
				choice = setLine(272);
				return choice;
			}
			case "TRANSITIONfrom13TO14p4FALSE":
			{
				choice = setLine(274);
				return choice;
			}
			case "TRANSITIONfrom13TO14p5":
			{
				choice = setLine(276);
				return choice;
			}
			case "TRANSITIONfrom13TO14p6TRUE":
			{
				choice = setLine(278);
				return choice;
			}
			case "TRANSITIONfrom13TO14p6FALSE":
			{
				choice = "The blade creeps slightly closer to your heart when the spider’s voice"
						+ " blazes across your mind \"You will not come this far only to fail!\" it"
						+ " screeches \"Rise! Rise you pathetic mortal and claim the throne that I "
						+ "deserve!\" You struggle with all your might, but you have been in combat "
						+ "since dawn and you feel your arm beginning to give out. You glare up at"
						+ " Lord Drake, defiant to the end. Then something unexpected happens. Drake "
						+ "steps away from you, mouth agape and a look of utter shock on his face, \"It cannot be!\""
						+ " he shouts. Before you lose your chance, you lunge forward, rip the dagger "
						+ "from his hand and plunge it into the gap of his armor beneath his armpit, "
						+ "surely a killing blow; you now lean over the mighty Drake, Lord of Markaze, "
						+ "as he coughs blood over himself. You are utterly confused as you see a look "
						+ "of recognition and utter sorrow in his dying eyes. Almost gently, he uses a "
						+ "blood soaked hand to cover the scarred half of your face and, with tears in "
						+ "his eyes, mutters a single word, \"Son...\"";
				return choice;
			}
			case "TRANSITIONfrom13TO14p7":
			{
				choice = setLine(282);
				return choice;
			}
			case "TRANSITIONfrom13TO14p8":
			{
				choice = setLine(284);
				return choice;
			}
			case "INTROtoO14":
			{
				choice = setLine(287);
				return choice;
			}
			case "O14CA":
			{
				choice = setLine(290);
				return choice;
			}
			case "O14CB":
			{
				choice = setLine(292);
				return choice;
			}
			case "O14CC":
			{
				choice = setLine(294);
				return choice;
			}
			case "OUTCOMEofO14CA":
			{
				choice = setLine(297);
				return choice;
			}
			case "OUTCOMEofO14CB":
			{
				choice = setLine(299);
				return choice;
			}
			case "OUTCOMEofO14CCp1":
			{
				choice = setLine(301);
				return choice;
			}
			case "OUTCOMEofO14CCp2":
			{
				choice = setLine(303);
				return choice;
			}
			case "TRANSITIONfrom14":
			{
				choice = setLine(306);
				return choice;
			}
			case "OUTCOMEofO12fail":
			{
				choice = setLine(315);
				return choice;
			}
		}

		return choice;
	}

	public static String setLine(int i)
	{
		try
		{
			String choice = "";
			FileInputStream fs = new FileInputStream("Choices.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for (int x = 0; x < i; ++x)
				br.readLine();
			choice = br.readLine();
			return choice;
		} catch (IOException e)
		{
			return ("There has been an error! Java IO Exception");
		}
	}
}