package com.quantum_magnus.dnd;

import com.quantum_magnus.dnd.DnDKeywords.Abilities;
import com.quantum_magnus.dnd.DnDKeywords.Background;
import com.quantum_magnus.dnd.DnDKeywords.Species;
import com.vaadin.flow.component.html.Image;

public class DnDOrigins {
	
	public static String assignAbilities(DnDKeywords.Background background) {
		String result = "";
		
		if (background == Background.Acolyte) {
			result = Abilities.Intelligence.name() + ", " + Abilities.Wisdom.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Artisan) {
			result = Abilities.Strength.name() + ", " + Abilities.Dexterity.name() + 
					", " + DnDKeywords.Abilities.Intelligence.name();
		} else if (background == Background.Charlatan) {
			result = Abilities.Dexterity.name() + ", " + Abilities.Constitution.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Criminal) {
			result = Abilities.Dexterity.name() + ", " + Abilities.Constitution.name() + 
					", " + Abilities.Intelligence.name();
		} else if (background == Background.Entertainer) {
			result = Abilities.Strength.name() + ", " + Abilities.Dexterity.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Farmer) {
			result = Abilities.Strength.name() + ", " + Abilities.Constitution.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Guard) {
			result = Abilities.Strength.name() + ", " + Abilities.Intelligence.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Guide) {
			result = Abilities.Dexterity.name() + ", " + Abilities.Constitution.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Hermit) {
			result = Abilities.Constitution.name() + ", " + Abilities.Wisdom.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Merchant) {
			result = Abilities.Constitution.name() + ", " + Abilities.Intelligence.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Noble) {
			result = Abilities.Strength.name() + ", " + Abilities.Intelligence.name() + 
					", " + Abilities.Charisma.name();
		} else if (background == Background.Sage) {
			result = Abilities.Constitution.name() + ", " + Abilities.Intelligence.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Sailor) {
			result = Abilities.Strength.name() + ", " + Abilities.Dexterity.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Scribe) {
			result = Abilities.Dexterity.name() + ", " + Abilities.Intelligence.name() + 
					", " + Abilities.Wisdom.name();
		} else if (background == Background.Soldier) {
			result = Abilities.Strength.name() + ", " + Abilities.Dexterity.name() + 
					", " + Abilities.Constitution.name();
		} else { // if background == Wayfarer
			result = Abilities.Dexterity.name() + ", " + Abilities.Wisdom.name() + 
					", " + Abilities.Charisma.name();
		}
		
		return result;
	}
	
	
	public static Background getBackgroundName(String background) {
		Background result = null;
		
		if (background.equals(Background.Acolyte.name())) {
			result = Background.Acolyte;
		} else if (background.equals(Background.Artisan.name())) {
			result = Background.Artisan;
		} else if (background.equals(Background.Charlatan.name())) {
			result = Background.Charlatan;
		} else if (background.equals(Background.Criminal.name())) {
			result = Background.Criminal;
		} else if (background.equals(Background.Entertainer.name())) {
			result = Background.Entertainer;
		} else if (background.equals(Background.Farmer.name())) {
			result = Background.Farmer;
		} else if (background.equals(Background.Guard.name())) {
			result = Background.Guard;
		} else if (background.equals(Background.Guide.name())) {
			result = Background.Guide;
		} else if (background.equals(Background.Hermit.name())) {
			result = Background.Hermit;
		} else if (background.equals(Background.Merchant.name())) {
			result = Background.Merchant;
		} else if (background.equals(Background.Noble.name())) {
			result = Background.Noble;
		} else if (background.equals(Background.Sage.name())) {
			result = Background.Sage;
		} else if (background.equals(Background.Sailor.name())) {
			result = Background.Sailor;
		} else if (background.equals(Background.Scribe.name())) {
			result = Background.Scribe;
		} else if (background.equals(Background.Soldier.name())) {
			result = Background.Soldier;
		} else { // if background == Wayfarer
			result = Background.Wayfarer;
		}
		
		return result;
	}
	
	public static Image getBackgroundImage(String background) {
		Image image = null;
		
		if (background.equals(Background.Acolyte.name())) {
			image = new Image("backgrounds/acolyte.jpg", "Acolyte");
		} else if (background.equals(Background.Artisan.name())) {
			image = new Image("backgrounds/artisan.jpg", "Artisan");
		} else if (background.equals(Background.Charlatan.name())) {
			image = new Image("backgrounds/charlatan.jpg", "Charlatan");
		} else if (background.equals(Background.Criminal.name())) {
			image = new Image("backgrounds/criminal.jpg", "Criminal");
		} else if (background.equals(Background.Entertainer.name())) {
			image = new Image("backgrounds/entertainer.jpg", "Entertainer");
		} else if (background.equals(Background.Farmer.name())) {
			image = new Image("backgrounds/farmer.jpg", "Farmer");
		} else if (background.equals(Background.Guard.name())) {
			image = new Image("backgrounds/guard.jpg", "Guard");
		} else if (background.equals(Background.Guide.name())) {
			image = new Image("backgrounds/guide.jpg", "Guide");
		} else if (background.equals(Background.Hermit.name())) {
			image = new Image("backgrounds/hermit.jpg", "Hermit");
		} else if (background.equals(Background.Merchant.name())) {
			image = new Image("backgrounds/merchant.jpg", "Merchant");
		} else if (background.equals(Background.Noble.name())) {
			image = new Image("backgrounds/noble.jpg", "Noble");
		} else if (background.equals(Background.Sage.name())) {
			image = new Image("backgrounds/sage.jpg", "Sage");
		} else if (background.equals(Background.Sailor.name())) {
			image = new Image("backgrounds/sailor.jpg", "Sailor");
		} else if (background.equals(Background.Scribe.name())) {
			image = new Image("backgrounds/scribe.jpg", "Scribe");
		} else if (background.equals(Background.Soldier.name())) {
			image = new Image("backgrounds/soldier.jpg", "Soldier");
		} else { // if background == Wayfarer
			image = new Image("backgrounds/wayfarer.jpg", "Wayfarer");
		}
		
		return image;
	}
	
	public static String[] backgroundDetails(String background) {
		String[] result = new String[2];
		Background backgroundEnum = getBackgroundName(background);
		String abilities = assignAbilities(backgroundEnum);
		
		if (backgroundEnum == Background.Acolyte) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Magic Initiate (Cleric)<br/>
		     	            <b>Skill Proficiencies:</b> Insight and Religion<br/>
		     	            <b>Tool Proficiencies:</b> Calligrapher's Supplies<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Calligrapher's Supplies, Book (prayers), 
		     	            Holy Symbol, Parchment (10 sheets), Robe, 8 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You devoted yourself to service in a temple, either nestled in a town or secluded in a 
		     	            sacred grove. There you performed rites in honor of aa god or pantheon. You served 
		     	            under a priest and studied religion. Thanks to your priest's instruction and you own 
		     	            devotion, you also learned how to channel a modicum of divine power in service to your 
		     	            place of worship and the people who have prayed there.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Artisan) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Crafter<br/>
		     	            <b>Skill Proficiencies:</b> Investigation and Persuasion<br/>
		     	            <b>Tool Proficiencies:</b> <i>Choose one kind of Artisan's Tools</i><br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Artisan's Tools (same as above), 2 Pouches, 
		     	            Traveler's Clothes, 32 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You began mopping floors and scrubbing counters in an artisan's workshop for a few 
		     	            coppers per day as soons as you were strong enough to carry a bucket. When you were 
		     	            old enough to apprentice, you learned to create basic crafts of your own, as well as 
		     	            how to sweet-talk the occassional demanding customer. Your trade has also given you a 
		     	            keen eye for detail.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Charlatan) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Skilled<br/>
		     	            <b>Skill Proficiencies:</b> Deception and Sleight of Hand<br/>
		     	            <b>Tool Proficiencies:</b> Forgery Kit<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Forgery Kit, Costume, Fine Clothes, 15 GP; 
		     	            or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            Once you were old enough to order and ale, you soon had a favorite stool in every 
		     	            tavern within ten miles of where you were born. As you traveled the circuit from 
		     	            public house to watering hole, you learned to prey on unfortunates who were in the 
		     	            market for a comforting lie or two—perhaps a sham potion or forged ancestry records.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Criminal) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Alert<br/>
		     	            <b>Skill Proficiencies:</b> Sleight of Hand and Stealth<br/>
		     	            <b>Tool Proficiencies:</b> Thieves' Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) 2 Daggers, Thieves' Tools, Crowbar, 2 
		     	            Pouches, Traveler's Clothes, 16 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You eked out a living in dark alleyways, cutting purses or burgling shops. Perhaps you 
		     	            were a part of a small gang of like-minded wrongdoers who looked out for each other. 
		     	            Or maybe you were a lone wolf, fending for yourself against the local thieves' guild 
		     	            and more fearsome lawbreakers.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Entertainer) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Musician<br/>
		     	            <b>Skill Proficiencies:</b> Acrobatics and Performance<br/>
		     	            <b>Tool Proficiencies:</b> <i>Choose one kind of Musical Instrument</i><br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Musical Instrument (same as above), 2 
		     	            Costumes, Mirror, Perfume, Traveler's Clothes, 11 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You spent much of your youth following roving fairs and carnivals, performing odd jobs 
		     	            for musicians and acrobats in exchange for lessons. You may have learned how to walk on
		     	            a tightrope, how to play a lute in a distinct style, or how to recite poetry with 
		     	            impeccable diction. To this day, you thrive on applause and long for the stage.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Farmer) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Tough<br/>
		     	            <b>Skill Proficiencies:</b> Animal Handling and Nature<br/>
		     	            <b>Tool Proficiencies:</b> Carpenter's Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Sickle, Carpenter's Tools, Healer's Kit, 
		     	            Iron Pot, Shovel, Traveler's Clothes, 30 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You grew up close to the land. Years tending animals and cultivating the earth 
		     	            rewarded you with patience and good health. You have a keen appreciation for nature's 
		     	            bounty alongside a healthy respect for nature's wrath.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Guard) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Alert<br/>
		     	            <b>Skill Proficiencies:</b> Athletics and Perception<br/>
		     	            <b>Tool Proficiencies:</b> <i>Choose one kind of Gaming Set</i><br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Spear, Light Crossbow, 20 Bolts, Gaming 
		     	            Set (same as above), Hooded Lantern, Manacles, Quiver, Traveler's Clothes, 12 GP; or 
		     	            (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            Your feet ache when you remember the countless hours you spent at your post in the 
		     	            tower. You were trained to keep one eye looking outside the wall, watching for 
		     	            marauders sweeping from the nearby forest, and your other eye looking inside the wall, 
		     	            searching for cutpurses and troublemakers.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Guide) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Magic Initiate (Druid)<br/>
		     	            <b>Skill Proficiencies:</b> Stealth and Survival<br/>
		     	            <b>Tool Proficiencies:</b> Cartographer's Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Shotrbow, 20 Arrows, Cartographer's Tools, 
		     	            Bedroll, Quiver, Tent, Traveler's Clothes, 3 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You came of age outdoors, far from the settled lands. Your home was anywhere you chose 
		     	            to spread your bedroll. There are wonders in the wilderness—strange monsters, pristine 
		     	            forests and streams, overgrown ruins of great halls once trod by giants—and you 
		     	            learned to fend for yourself as you explored them. From time to time, you guided 
		     	            friendly nature priests who instructed you in the fundamentals of channeling the magic 
		     	            of the wild.
		     	        </p>
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Hermit) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Healer<br/>
		     	            <b>Skill Proficiencies:</b> Medicine and Religion<br/>
		     	            <b>Tool Proficiencies:</b> Herbalism Kit<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Quarterstaff, Herbalism Kit, Bedroll, 
		     	            Book (philosophy), Lamp, Oil (3 flasks), Traveler's Clothes, 16 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You spent your early years secluded in a hut or monestary located well beyond the 
		     	            outskirts of the nearest settlement. In those days, your only companions were the 
		     	            creatures of the forest and those who would occasionally visit to bring news of the 
		     	            outside world and supplies. The solitude allowed you to spend many hours pondering the 
		     	            mysteries of creation.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Merchant) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Lucky<br/>
		     	            <b>Skill Proficiencies:</b> Animal Handling and Persuasion<br/>
		     	            <b>Tool Proficiencies:</b> Navigator's Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Navigator's Tools, 2 Pouches, Traveler's 
		     	            Clothes, 22 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You were apprenticed to a trader, caravan master, or shopkeeper, learning the 
		     	            fundamentals of commerce. You traveled broadly, and you earned a living by buying and 
		     	            selling the raw materials artisans need to practice their craft or finished works from 
		     	            such crafters. You might have transported goods from one place to another (by ship, 
		     	            wagon, or caravan) or bought them from traveling traders and sold them in your own 
		     	            shop.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Noble) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Skilled<br/>
		     	            <b>Skill Proficiencies:</b> History and Persuasion<br/>
		     	            <b>Tool Proficiencies:</b> <i>Choose one kind of Gaming Set</i><br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Gaming Set (same as above), Fine Clothes, 
		     	            Perfume, 29 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You were raised in a castle, surrounded by wealth, power, and privilege. Your family 
		     	            of minor aristocrats ensured that you received a first-class education, some of which 
		     	            you appreciated and some of which you resented. Your time in the castle, especially 
		     	            the many hours you spent in observing your family at court, also taught you a great 
		     	            deal about leadership.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Sage) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Magic Iniate (Wizard)<br/>
		     	            <b>Skill Proficiencies:</b> Arcana and History<br/>
		     	            <b>Tool Proficiencies:</b> Calligrapher's Supplies<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Quarterstaff, Calligrapher's Supplies, 
		     	            Book (history), Parchment (8 sheets), Robe, 8 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You spent your formative years traveling between manors and monasteries, performing 
		     	            various odd jobs and services in exchange for access to their libraries. You whiled 
		     	            away many a long evening studying books and scrolls, learning the lore of the 
		     	            multiverse—even the rudiments of magic—and your mind yearns for more.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Sailor) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Tavern Brawler<br/>
		     	            <b>Skill Proficiencies:</b> Acrobatics and Perception<br/>
		     	            <b>Tool Proficiencies:</b> Navigator's Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Dagger, Navigator's Tools, Rope, 
		     	            Traveler's Clothes, 20 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You lived as a seafarer, wind at your back and decks swaying beneath your feet. 
		     	            You've perched on barstools in more ports of call than you can remember, faced mighty 
		     	            storms, and swapped stories with folk who live beneath the waves.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Scribe) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Skilled<br/>
		     	            <b>Skill Proficiencies:</b> Investigation and Perception<br/>
		     	            <b>Tool Proficiencies:</b> Calligrapher's Supplies<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Calligrapher's Supplies, Fine Clothes, 
		     	            Lamp, Oil (3 flasks), Parchment (12 sheets), 23 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You spent formative years in a scriptorium, a monastery dedicated to the preservation 
		     	            of knowledge, or a government agency, where you learned to write with a clear hand and 
		     	            produce finely written texts. Perhaps you scribed government documents or copied tomes 
		     	            of literature. You might have some skill as a writer of poetry, narrative, or 
		     	            scholarly research. Above all, you have a careful attention to detail, helping you 
		     	            avoid introducing mistakes to the documents you copy and create.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Soldier) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Savage Attacker<br/>
		     	            <b>Skill Proficiencies:</b> Athletics and Intimidation<br/>
		     	            <b>Tool Proficiencies:</b> <i>Choose one kind of Gaming Set</i><br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) Spear, Shortbow, 20 Arrows, Gaming Set 
		     	            (same as above), Healer's Kit, Quiver, Traveler's Clothes, 14 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You began training for war as soon as you reached adulthood and carry precious few 
		     	            memories of life before you took up arms. Battle is in your blood. Sometimes you catch 
		     	            yourself reflexively performing the basic fighting exercises you learned first. 
		     	            Eventually, you put that traaining to use on the battlefield, protecting the realm by 
		     	            waging war.
		     	    </div>
		     	""";
		} else if (backgroundEnum == Background.Wayfarer) {
	        result[0] = String.format("""
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            <b>Ability Scores:</b> %s<br/>
		     	            <b>Feat:</b> Lucky<br/>
		     	            <b>Skill Proficiencies:</b> Insight and Stealth<br/>
		     	            <b>Tool Proficiencies:</b> Thieves' Tools<br/>
		     	            <b>Equipment:</b> <i>Choose A or B:</i> (A) 2 Daggers, Thieves' Tools, Gaming Set 
		     	            (any) Bedroll, 2 Pouches, Traveler's Clothes, 16 GP; or (B) 50 GP
		     	        </p>
		     	    </div>
		     	""", abilities);
	        result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            You grew up on the streets surroudned by similarly ill-fated castoffs, a few of them 
		     	            friends and a few of them rivals. You slept where you could and did odd jobs for food. 
		     	            At times, when the hunger became unbearable, you resorted to theft. Still, you never 
		     	            lost your pride and never abandoned hope. Fate is not yet finished with you.
		     	    </div>
		     	""";
		}
		
		return result;
	}
	
	public static Species getSpeciesName(String species) {
		Species result = null;
		
		if (species.equals(Species.Aasimar.name())) {
			result = Species.Aasimar;
		} else if (species.equals(Species.Dragonborn.name())) {
			result = Species.Dragonborn;
		} else if (species.equals(Species.Dwarf.name())) {
			result = Species.Dwarf;
		} else if (species.equals(Species.Elf.name())) {
			result = Species.Elf;
		} else if (species.equals(Species.Gnome.name())) {
			result = Species.Gnome;
		} else if (species.equals(Species.Goliath.name())) {
			result = Species.Goliath;
		} else if (species.equals(Species.Halfling.name())) {
			result = Species.Halfling;
		} else if (species.equals(Species.Human.name())) {
			result = Species.Human;
		} else if (species.equals(Species.Orc.name())) {
			result = Species.Orc;
		} else { // if species == Tiefling
			result = Species.Tiefling;
		}
		
		return result;
	}
	
	public static Image getSpeciesImage(String species) {
		Image image = null;
		
		if (species.equals(Species.Aasimar.name())) {
			image = new Image("species/aasimar.jpg", "Aasimar");
		} else if (species.equals(Species.Dragonborn.name())) {
			image = new Image("species/dragonborn.jpg", "Dragonborn");
		} else if (species.equals(Species.Dwarf.name())) {
			image = new Image("species/dwarf.jpg", "Dwarf");
		} else if (species.equals(Species.Elf.name())) {
			image = new Image("species/elf.jpg", "Elf");
		} else if (species.equals(Species.Gnome.name())) {
			image = new Image("species/gnome.jpg", "Gnome");
		} else if (species.equals(Species.Goliath.name())) {
			image = new Image("species/goliath.jpg", "Goliath");
		} else if (species.equals(Species.Halfling.name())) {
			image = new Image("species/halfling.jpg", "Halfling");
		} else if (species.equals(Species.Human.name())) {
			image = new Image("species/human.jpg", "Human");
		} else if (species.equals(Species.Orc.name())) {
			image = new Image("species/orc.jpg", "Orc");
		} else { // if species == Tiefling
			image = new Image("species/tiefling.jpg", "Tiefling");
		}
		
		return image;
	}
		
	public static String[] speciesDetails(String species) {
		String[] result = new String[4];
		Species speciesEnum = getSpeciesName(species);
		
		if (speciesEnum == Species.Aasimar) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            Aasimar (pronounced AH-sih-mar) are mortals who carry a spark of the Upper Planes 
		     	            within their souls. Whether descended from an angelic being or infused with celestial 
		     	            power, they can fan that spark to bring light, healing, and heavenly fury.<br/> 
		     	            &nbsp;&nbsp;Aasimar can arise among any population of mortals. They resemble their 
		     	            parents, but they live for up to 160 years and have features that hint at their 
		     	            celestial heritage, such as metallic freckles, luminous eyes, a halo, or the skin 
		     	            color of an angel (silver, opalescent green, or coppery red). These features start 
		     	            subtle and become obvious when the aasimar learns to reveal their full celestial 
		     	            nature.
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
		     	            <b>Size:</b> Medium (about 4—7 feet tall) or Small (about 2—4 feet tall), chosen when 
		     	            you select this species<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As an Aasimar, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Celestial Resistance.</i></b> You have Resistance to Necrotic damage 
							and Radiant damage.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 60 feet.<br/>
							&nbsp<b><i>Healing Hands.</i></b> As a Magic action, you touch a creature and 
							roll a number of d4s equal to your Proficiency Bonus. The creature regains a number of 
							Hit Points equal to the total rolled. Once you use this trait, you can’t use it again 
							until you finish a Long Rest.<br/>
							&nbsp;&nbsp;<b><i>Light Bearer.</i></b>You know the Light cantrip. Charisma is your 
							spellcasting ability for it.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							&nbsp;&nbsp;<b><i>Celestial Revelation.</i></b> When you reach character level 3, you 
							can transform as a Bonus Action using one of the options below (choose the option each 
							time you transform). The transformation lasts for 1 minute or until you end it (no 
							action required). Once you transform, you can’t do so again until you finish a Long 
							Rest.<br/> 
							Once on each of your turns before the transformation ends, you can deal extra damage 
							to one target when you deal damage to it with an attack or a spell. The extra damage 
							equals your Proficiency Bonus, and the extra damage’s type is either Necrotic for 
							Necrotic Shroud or Radiant for Heavenly Wings and Inner Radiance.<br/>
							&nbsp;&nbsp;Here are the transformation options:<br/>
							<b>Heavenly Wings.</b> Two spectral wings sprout from your back temporarily. Until the 
							transformation ends, you have a Fly Speed equal to your Speed.<br/>
							<b>Inner Radiance.</b> Searing light temporarily radiates from your eyes and mouth. 
							For the duration, you shed Bright Light in a 10-foot radius and Dim Light for an 
							additional 10 feet, and at the end of each of your turns, each creature within 10 feet 
							of you takes Radiant damage equal to your Proficiency Bonus.<br/>
							<b>Necrotic Shroud.</b> Your eyes briefly become pools of darkness, and flightless 
							wings sprout from your back temporarily. Creatures other than your allies within 10 
							feet of you must succeed on a Charisma saving throw (DC 8 plus your Charisma modifier 
							and Proficiency Bonus) or have the Frightened condition until the end of your next 
							turn.
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "59em";
		} else if (speciesEnum == Species.Dragonborn) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
		     	            The ancestors of dragonborn hatched form the eggs of chromatic and metallic dragons. 
		     	            One story holds that these eggs were blessed by the dragon gods Bahamut and Tiamat, 
		     	            who wanted to populate the multiverse with people created in their image. Another 
		     	            story claims that dragons created the first dragonborn without the gods' blessings. 
		     	            Whatever their origin, dragonborn have made homes for themselves on the Material 
		     	            Plane.<br/>
		     	            &nbsp;&nbsp;Dragonborn look like wingless, bipedal dragons—scaly, bright-eyed, and 
		     	            thick-boned with horns on their heads—and their coloration and other features are 
		     	            reminiscent of their draconic ancestors.
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
		     	            <b>Size:</b> Medium (about 5—7 feet tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As a Dragonborn, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Draconic Ancestry.</i></b> Your lineage stems from a dragon 
							progenitor. Choose the kind of dragon from the Draconic Ancestors table. Your choice 
							affects your Breath Weapon and Damage Resistance traits as well as your 
							appearance.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							&nbsp;&nbsp;<b><i>Breath Weapon.</i></b> When you take the Attack action on your turn, 
							you can replace one of your attacks with an exhalation of magical energy in either a 
							15-foot Cone or a 30-foot Line that is 5 feet wide (choose the shape each time). Each 
							creature in that area must make a Dexterity saving throw (DC 8 plus your Constitution 
							modifier and Proficiency Bonus). On a failed save, a creature takes 1d10 damage of the 
							type determined by your Draconic Ancestry trait. On a successful save, a creature 
							takes half as much damage. This damage increases by 1d10 when you reach character 
							levels 5 (2d10), 11 (3d10), and 17 (4d10).<br/>
							&nbsp;&nbspYou can use this Breath Weapon a number of times equal to your Proficiency 
							Bonus, and you regain all expended uses when you finish a Long Rest.<br/>
							&nbsp;&nbsp;<b><i>Damage Resistance.</i></b> You have Resistance to the damage type 
							determined by your Draconic Ancestry trait.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 60 feet.<br/>
							&nbsp;&nbsp;<b><i>Draconic Flight.</i></b> When you reach character level 5, you can 
							channel draconic magic to give yourself temporary flight. As a Bonus Action, you 
							sprout spectral wings on your back that last for 10 minutes or until you retract the 
							wings (no action required) or have the Incapacitated condition. During that time, you 
							have a Fly Speed equal to your Speed. Your wings appear to be made of the same energy 
							as your Breath Weapon. Once you use this trait, you can’t use it again until you 
							finish a Long Rest.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "63em";
		} else if (speciesEnum == Species.Dwarf) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Dwarves were raised from the earth in the elder days by a deity of the forge. Called by various 
							names on different worlds—Moradin, Reorx, and others—that god gave dwarves an affinity for 
							stone and metal and for living underground. The god also made them resilient like the 
							mountains, with a life span of about 350 years.<br/>
							&nbsp;&nbsp;Squat and often bearded, the original dwarves carved cities and strongholds into 
							mountainsides and under the earth. Their oldest legends tell of conflicts with the monsters of 
							mountaintops and the Underdark, whether those monsters were towering giants or subterranean 
							horrors. Inspired by those tales, dwarves of any culture often sing of valorous 
							deeds—especially of the little overcoming the mighty.<br/>
							&nbsp;&nbsp;On some worlds in the multiverse, the first settlements of dwarves were built in 
							hills or mountains, and the families who trace their ancestry to those settlements call 
							themselves hill dwarves or mountain dwarves, respectively. The Greyhawk and Dragonlance 
							settings have such communities.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 4–5 feet tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As a Dwarf, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 120 feet.<br/>
							&nbsp;&nbsp;<b><i>Dwarven Resilience.</i></b> You have Resistance to Poison damage. You also 
							have Advantage on saving throws you make to avoid or end the Poisoned condition.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							&nbsp;&nbsp;<b><i>Dwarven Toughness.</i></b> Your Hit Point maximum increases by 1, and it 
							increases by 1 again whenever you gain a level.<br/>
							&nbsp;&nbsp;<b><i>Stonecunning.</i></b> As a Bonus Action, you gain Tremorsense with a range of 
							60 feet for 10 minutes. You must be on a stone surface or touching a stone surface to use this 
							Tremorsense. The stone can be natural or worked.<br/>
							&nbsp;&nbsp;You can use this Bonus Action a number of times equal to your Proficiency Bonus, 
							and you regain all expended uses when you finish a Long Rest.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "51em";
		} else if (speciesEnum == Species.Elf) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Created by the god Corellon, the first elves could change their forms at will. They lost this 
							ability when Corellon cursed them for plotting with the deity Lolth, who tried and failed to 
							usurp Corellon’s dominion. When Lolth was cast into the Abyss, most elves renounced her and 
							earned Corellon’s forgiveness, but that which Corellon had taken from them was lost 
							forever.<br/>
							&nbsp;&nbsp;No longer able to shape-shift at will, the elves retreated to the Feywild, where 
							their sorrow was deepened by that plane’s influence. Over time, curiosity led many of them to 
							explore other planes of existence, including worlds in the Material Plane.<br/>
							&nbsp;&nbsp;Elves have pointed ears and lack facial and body hair. They live for around 750 
							years, and they don’t sleep but instead enter a trance when they need to rest. In that state, 
							they remain aware of their surroundings while immersing themselves in memories and 
							meditations.<br/>
							&nbsp;&nbsp;An environment subtly transforms elves after they inhabit it for a millennium or 
							more, and it grants them certain kinds of magic. Drow, high elves, and wood elves are examples 
							of elves who have been transformed thus.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<H3>Drow</H3>
							Drow typically dwell in the Underdark and have been shaped by it. Some drow individuals and 
							societies avoid the Underdark altogether yet carry its magic. In the Eberron setting, for 
							example, drow dwell in rainforests and cyclopean ruins on the continent of Xen’drik.<br/><br/>
							<H3>High Elves</H3>
							High elves have been infused with the magic of crossings between the Feywild and the Material 
							Plane. On some worlds, high elves refer to themselves by other names. For example, they call 
							themselves sun or moon elves in the Forgotten Realms setting, Silvanesti and Qualinesti in the 
							Dragonlance setting, and Aereni in the Eberron setting.<br/><br/>
							<H3>Wood Elves</H3>
							Wood elves carry the magic of primeval forests within themselves. They are known by many other 
							names, including wild elves, green elves, and forest elves. Grugach are reclusive wood elves of 
							the Greyhawk setting, while the Kagonesti and the Tairnadal are wood elves of the Dragonlance 
							and Eberron settings, respectively.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 5–6 feet tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As an Elf, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 60 feet.<br/>
							&nbsp;&nbsp;<b><i>Elven Lineage.</i></b> You are part of a lineage that grants you supernatural 
							abilities. Choose a lineage from the Elven Lineages table. You gain the level 1 benefit of that 
							lineage.<br/>
							&nbsp;&nbsp;When you reach character levels 3 and 5, you learn a higher-level spell, as shown 
							on the table. You always have that spell prepared. You can cast it once without a spell slot, 
							and you regain the ability to cast it in that way when you finish a Long Rest. You can also 
							cast the spell using any spell slots you have of the appropriate level.<br/>
							&nbsp;&nbsp;Intelligence, Wisdom, or Charisma is your spellcasting ability for the spells you 
							cast with this trait (choose the ability when you select the lineage).<br/>
						    &nbsp;&nbsp;<b><i>Fey Ancestry.</i></b> You have Advantage on saving throws you make to avoid 
						    or end the Charmed condition.<br/>
							&nbsp;&nbsp;<b><i>Keen Senses.</i></b> You have proficiency in the Insight, Perception, or 
							Survival skill.<br/>
							&nbsp;&nbsp;<b><i>Trance.</i></b> You don’t need to sleep, and magic can’t put you to sleep. 
							You can finish a Long Rest in 4 hours if you spend those hours in a trancelike meditation, 
							during which you retain consciousness.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "82em";
		} else if (speciesEnum == Species.Gnome) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Gnomes are magical folk created by gods of invention, illusions, and life underground. The 
							earliest gnomes were seldom seen by other folk due to the gnomes' secretive nature and their 
							propensity for living in forests and burrows. What they lacked in size, they make up for in 
							cleverness. They confounded predators with traps and labyrinthine tunnels. They also learned 
							magic from gods like Garl Glittergold, Baervan Wildwanderer, and Baravar Cloakshadow, who 
							visited them in disguise. That magic eventually created the lineages of forest gnomes and rock 
							gnomes.<br/>
							&nbsp;&nbsp;Gnomes are petite folk with big eyes and pointed ears, who live around 425 years. 
							Many gnomes like the feeling of a roof over their head, even if that "roof" is nothing more 
							than a hat.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
					 	    <b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Small (about 3–4 cm tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As a Gnome, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 60 feet.<br/>
							&nbsp;&nbsp;<b><i>Gnomish Cunning.</i></b> You have Advantage on Intelligence, Wisdom, and 
							Charisma saving throws.<br/>
							&nbsp;&nbsp;<b><i>Gnomish Lineage.</i></b> You are part of a lineage that grants you 
							supernatural abilities. Choose one of the following options on the right; whichever one you 
							choose, Intelligence, Wisdom, or Charisma is your spellcasting ability for the spells you cast 
							with this trait (choose the ability when you select the lineage):<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Forest Gnome.</b> You know the Minor Illusion cantrip. You also always have the Speak with 
							Animals spell prepared. You can cast it without a spell slot a number of times equal to your 
							Proficiency Bonus, and you regain all expended uses when you finish a Long Rest. You can also 
							use any spell slots you have to cast the spell.<br/> 
							<b>Rock Gnome.</b> You know the Mending and Prestidigitation cantrips. In addition, you can 
							spend 10 minutes casting Prestidigitation to create a Tiny clockwork device (AC 5, 1 HP), such 
							as a toy, fire starter, or music box. When you create the device, you determine its function by 
							choosing one effect from Prestidigitation; the device produces that effect whenever you or 
							another creature takes a Bonus Action to activate it with a touch. If the chosen effect has 
							options within it, you choose one of those options for the device when you create it. For 
							example, if you choose the spell’s ignite-extinguish effect, you determine whether the device 
							ignites or extinguishes fire; the device doesn’t do both. You can have three such devices in 
							existence at a time, and each falls apart 8 hours after its creation or when you dismantle it 
							with a touch as a Utilize action.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "54em";
		} else if (speciesEnum == Species.Goliath) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Towering over most folk, goliaths are distant descendants of giants. Each goliath bears the 
							favors of the first giants–favors that manifest in various supernatural boons, including the 
							ability to quickly grow and temporarily approach the height of goliaths' gigantic kin.<br/>
							&nbsp;&nbsp;Golaiths have physical characteristics that are reminiscent of the giants in their 
							family lines. For example, some goliaths look like stone giants, while others resemble fire 
							giants. Whatever giants they count as kin, goliaths have forged their own path in the 
							multiverse–unencumbered by the internecine conflicts that have giantkind for ages–and seek 
							heights above those reached by their ancestors.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 7–8 feet tall)<br/>
							<b>Speed:</b> 35 feet<br/><br/>
							As a Goliath, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Giant Ancestry.</i></b> You are descended from Giants. Choose one of the 
							following benefits—a supernatural boon from your ancestry; you can use the chosen benefit a 
							number of times equal to your Proficiency Bonus, and you regain all expended uses when you 
							finish a Long Rest:<br/><br/>
							<b>Cloud’s Jaunt (Cloud Giant).</b> As a Bonus Action, you magically teleport up to 30 feet to 
							an unoccupied space you can see.<br/>
							<b>Fire’s Burn (Fire Giant).</b> When you hit a target with an attack roll and deal damage to 
							it, you can also deal 1d10 Fire damage to that target.<br/>
							<b>Frost’s Chill (Frost Giant).</b> When you hit a target with an attack roll and deal damage 
							to it, you can also deal 1d6 Cold damage to that target and reduce its Speed by 10 feet until 
							the start of your next turn.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Hill’s Tumble (Hill Giant).</b> When you hit a Large or smaller creature with an attack roll 
							and deal damage to it, you can give that target the Prone condition.</br>
							<b>Stone’s Endurance (Stone Giant).</b> When you take damage, you can take a Reaction to roll 
							1d12. Add your Constitution modifier to the number rolled and reduce the damage by that 
							total.<br/>
							<b>Storm’s Thunder (Storm Giant).</b> When you take damage from a creature within 60 feet of 
							you, you can take a Reaction to deal 1d8 Thunder damage to that creature.<br/>
							&nbsp;&nbsp;<b><i>Large Form.</i></b> Starting at character level 5, you can change your size 
							to Large as a Bonus Action if you’re in a big enough space. This transformation lasts for 10 
							minutes or until you end it (no action required). For that duration, you have Advantage on 
							Strength checks, and your Speed increases by 10 feet. Once you use this trait, you can’t use it 
							again until you finish a Long Rest.<br/>
							&nbsp;&nbsp;<b><i>Powerful Build.</i></b> You have Advantage on any ability check you make to 
							end the Grappled condition. You also count as one size larger when determining your carrying 
							capacity.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "56em";
		} else if (speciesEnum == Species.Halfling) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Cherished and guided by gods who value life, home, and hearth, halflings gravitate toward 
							bucolic havens where family and community help shape their lives. That said, many halflings 
							possess a brave and adventurous spirit that leads them on journeys of discovery, affording them 
							the chance to explore a bigger world and make new friends along the way. Their size—similar to 
							that of a human child—helps them pass through crowds unnoticed and slip through tight 
							spaces.<br/>
							&nbsp;&nbsp;Anyone who has spent time around halflings, particularly halfling adventurers, has 
							likely witnessed the storied “luck of the halflings” in action. When a halfling is in mortal 
							danger, an unseen force seems to intervene on the halfling’s behalf. Many halflings believe in 
							the power of luck, and they attribute their unusual gift to one or more of their benevolent 
							gods, including Yondalla, Brandobaris, and Charmalaine. The same gift might contribute to their 
							robust life spans (about 150 years).<br/>
							&nbsp;&nbsp;Halfling communities come in all varieties. For every sequestered shire tucked away 
							in an unspoiled part of the world, there’s a crime syndicate like the Boromar Clan in the 
							Eberron setting or a territorial mob of halflings like those in the Dark Sun setting.<br/>
							&nbsp;&nbsp;Halflings who prefer to live underground are sometimes called strongheart halflings 
							or stouts. Nomadic halflings, as well as those who live among humans and other tall folk, are 
							sometimes called lightfoot halflings or tallfellows.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Small (about 2–3 feet tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As a Halfling, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Brave.</i></b> You have Advantage on saving throws you make to avoid or end 
							the Frightened condition.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							&nbsp;&nbsp;<b><i>Halfling Nimbleness.</i></b> You can move through the space of any creature 
							that is a size larger than you, but you can’t stop in the same space.<br/>
							&nbsp;&nbsp;<b><i>Luck.</i></b> When you roll a 1 on the d20 of a D20 Test, you can reroll the 
							die, and you must use the new roll.<br/>
							&nbsp;&nbsp;<b><i>Naturally Stealthy.</i></b> You can take the Hide action even when you are 
							obscured only by a creature that is at least one size larger than you.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "53em";
		} else if (speciesEnum == Species.Human) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Found throughout the multiverse, humans are as varied as they are numerous, and they endeavor 
							to achieve as much as they can in the years they are given. Their ambition and resourcefulness 
							are commended, respected, and feared on many worlds.<br/>
							&nbsp;&nbsp;Humans are as diverse in appearance as the people of Earth, and they have many 
							gods. Scholars dispute the origin of humanity, but one of the earliest known human gatherings 
							is said to have occurred in Sigil, the torus-shaped city at the center of the multiverse and 
							the place where the Common language was born. From there, humans could have spread to every 
							part of the multiverse, bringing the City of Doors’ cosmopolitanism with them.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 4–7 feet tall) or Small (about 2–4 feet tall), chosen when you 
							select this species<br/>
							<b>Speed:</b> 30 feet<br/><br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							As a Human, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Resourceful.</i></b> You gain Heroic Inspiration whenever you finish a Long 
							Rest.<br/>
							&nbsp;&nbsp;<b><i>Skillful.</i></b> You gain proficiency in one skill of your choice (see the 
							Feats page). Skilled is recommended.<br/>
							&nbsp;&nbsp;<b><i>Versatile.</i></b> You gain an Origin feat of your choice.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "50em";// needs some filler text
		} else if (speciesEnum == Species.Orc) {
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Orcs trace their creation to Gruumsh, a powerful god who roamed the wide open spaces of the 
							Material Plane. Gruumsh equipped his children with gifts to help them wander great plains, vast 
							caverns, and churning seas and to face the monsters that lurk there. Even when they turn their 
							devotion to other gods, orcs retain Gruumsh’s gifts: endurance, determination, and the ability 
							to see in darkness.<br/>
							&nbsp;&nbsp;Orcs are, on average, tall and broad. They have gray skin, ears that are sharply 
							pointed, and prominent lower canines that resemble small tusks. Orc youths on some worlds are 
							told about their ancestors’ great travels and travails. Inspired by those tales, many of those 
							orcs wonder when Gruumsh will call on them to match the heroic deeds of old and if they will 
							prove worthy of his favor. Other orcs are happy to leave old tales in the past and find their 
							own way.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 6–7 feet tall)<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As an Orc, you have these special traits.<br/>
							&nbsp;&nbsp;<b><i>Adrenaline Rush.</i></b> You can take the Dash action as a Bonus Action. When 
							you do so, you gain a number of Temporary Hit Points equal to your Proficiency Bonus.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							&nbsp;&nbsp;You can use Adrenaline Rush a number of times equal to your Proficiency Bonus, and 
							you regain all expended uses when you finish a Short or Long Rest.</br>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 120 feet.<br/>
							&nbsp;&nbsp;<b><i>Relentless Endurance.</i></b> When you are reduced to 0 Hit Points but not 
							killed outright, you can drop to 1 Hit Point instead. Once you use this trait, you can’t do so 
							again until you finish a Long Rest.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "51em";
		} else { // if speciesEnum == Tiefling
			result[0] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							Tieflings are either born in the Lower Planes or have fiendish ancestors who originated there. 
							A tiefling (pronounced TEE-fling) is linked by blood to a devil, a demon, or some other Fiend. 
							This connection to the Lower Planes is the tiefling’s fiendish legacy, which comes with the 
							promise of power yet has no effect on the tiefling’s moral outlook.<br/>
							&nbsp;&nbsp;A tiefling chooses whether to embrace or lament their fiendish legacy. The three 
							legacies are described below.<be/>
		     	        </p>
		     	    </div>
		     	""";
			result[1] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<H3>Abyssal</H3>
							The entropy of the Abyss, the chaos of Pandemonium, and the despair of Carceri call to 
							tieflings who have the abyssal legacy. Horns, fur, tusks, and peculiar scents are common 
							physical features of such tieflings, most of whom have the blood of demons coursing through 
							their veins.<br/><br/>
							<H3>Chthonic</H3>
							Tieflings who have the chthonic legacy feel not only the tug of Carceri but also the greed of 
							Gehenna and the gloom of Hades. Some of these tieflings look cadaverous. Others possess the 
							unearthly beauty of a succubus, or they have physical features in common, with a night hag, a 
							yugoloth, or some other Neutral Evil fiendish ancestor.<br/><br/>
							<H3>Infernal</H3>
							The infernal legacy connects tieflings not only to Gehenna but also the Nine Hells and the 
							raging battlefields of Acheron. Horns, spines, tails, golden eyes, and a faint odor of sulfur 
							or smoke are common physical features of such tieflings, most of who trace their ancestry to 
							devils.<br/>
						</p>
		     	    </div>
		     	""";
			result[2] = """
	         	    <div style="overflow: hidden;">
		     	        <p style='text-align: justify; font-size: 15px;'>
							<b>Creature Type:</b> Humanoid<br/>
							<b>Size:</b> Medium (about 4–7 feet tall) or Small (about 3–4 feet tall), chosen when you 
							select this species<br/>
							<b>Speed:</b> 30 feet<br/><br/>
							As a Tiefling, you have the following special traits.<br/>
							&nbsp;&nbsp;<b><i>Darkvision.</i></b> You have Darkvision with a range of 60 feet.<br/>
							&nbsp;&nbsp;<b><i>Fiendish Legacy.</i></b> You are the recipient of a legacy that grants you 
							supernatural abilities. Choose a legacy from the Fiendish Legacies table. You gain the level 1 
							benefit of the chosen legacy.<br/>
							&nbsp;&nbsp;When you reach character levels 3 and 5, you learn a higher-level spell, as shown 
							on the table. You always have that spell prepared. You can cast it once without a spell slot, 
							and you regain the ability to cast it in that way when you finish a Long Rest. You can also 
							cast the spell using any spell slots you have of the appropriate level. Intelligence, Wisdom, 
							or Charisma is your spellcasting ability for the spells you cast with this trait (choose the 
							ability when you select the legacy).<br/>
						    &nbsp;&nbsp;<b><i>Otherworldly Presence.</i></b> You know the Thaumaturgy cantrip. When you 
						    cast it with this trait, the spell uses the same spellcasting ability you use for your Fiendish 
						    Legacy Trait.<br/>
		     	        </p>
		     	    </div>
		     	""";
			result[3] = "75em";
		}
		
		return result;
	}
	
}