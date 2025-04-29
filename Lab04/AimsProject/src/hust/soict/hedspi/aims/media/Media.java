package hust.soict.hedspi.aims.media;
import java.util.*;

public abstract class Media {
	
	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media(String title){
		nbMedia += 1;
		this.id = nbMedia;
		this.title = title;
	}
	
	public Media(String title, String category, float cost) {
		nbMedia += 1;
		this.id = nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		try {
			Media media = (Media) obj;
			return media.getTitle().equals(title);
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean isMatch(int id) {
		return getId() == id;
	}
	
	public boolean isMatch(String title) {
		String s1 = title.toLowerCase();
		String s2 = getTitle().toLowerCase();
		for (int i = 0; i < s1.length(); ++i)
			for (int j = 0; j < s2.length(); ++j)
				if (s1.charAt(i) == s2.charAt(j))
					return true;
		return false;
	}
	
}