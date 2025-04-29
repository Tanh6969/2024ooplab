/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hust.soict.hedspi.aims.media;
import java.util.*;
/**
 *
 * @author Admin
 */
public class MediaComparatorByTitleCost implements Comparator<Media>{
    public int compare(Media o1, Media o2) {
		int res = o1.getTitle().compareTo(o2.getTitle());
		if (res != 0)
			return res;
		if (o1.getCost() == o2.getCost())
			return 0;
		return o1.getCost() > o2.getCost() ? -1 : 1;
	}
}
