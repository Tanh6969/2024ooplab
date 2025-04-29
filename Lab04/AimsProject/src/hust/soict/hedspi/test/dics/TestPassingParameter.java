package hust.soict.hedspi.test.dics;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;


public class TestPassingParameter {
        public static void main(String[] args)
        {
            DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
            DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella"); 
            
            swap(jungleDVD, cinderellaDVD);
            System.out.println("Jungle dvd title: "+ jungleDVD.getTitle());
            System.out.println("Cinderella dvd title: "+ cinderellaDVD.getTitle());
            
            changeTitle(jungleDVD, cinderellaDVD.getTitle());
            System.out.println("Jungle dvd title: "+ jungleDVD.getTitle());
        }
        public static void swap(Object o1, Object o2)
        {
            Object tmp = o1;
            o1=o2;
            o2= tmp;
        }
        public static void changeTitle(DigitalVideoDisc dvd, String title)
        {
            String oldTitle = dvd.getTitle();
            dvd.setTitle(title);
            dvd = new DigitalVideoDisc(oldTitle);
        }
}
