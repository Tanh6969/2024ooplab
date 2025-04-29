
public class Cart {
    public static final int MAX_NUMBER_ORDERD =20;
    private DigitalVideoDisc itemsOrdered[]= new DigitalVideoDisc[MAX_NUMBER_ORDERD];
    
    private int qtyOrder=0;
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc)
    {
            if(qtyOrder< MAX_NUMBER_ORDERD)
            {
                itemsOrdered[qtyOrder]=disc;
                qtyOrder++;
                //System.out.println("San pham da duoc them vao gio hang");
            }
            else System.out.println("Qua so luong roi");
    }           
    public void addDigitalVideoDisc(DigitalVideoDisc []dvdList)
    {
        
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 )
    {
            if(qtyOrder< MAX_NUMBER_ORDERD)
            {
                itemsOrdered[qtyOrder]=dvd1;
                qtyOrder++;
                itemsOrdered[qtyOrder]=dvd2;
                qtyOrder++;
            }
            else System.out.println("Qua so luong roi");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc)
    {
        for(int i=0;i<qtyOrder;i++)
        {
            if(itemsOrdered[i]==disc)
            {
                for(int j=i;j<qtyOrder-1;j++)
                {
                    itemsOrdered[j]=itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrder-1] =null;
                qtyOrder--;
                System.out.println("Deleted");
                break;
            }
        }
    }
    public float totalCost()
    {
        float total=0;
        for(int i=0;i<qtyOrder;i++)
        {
            total+=itemsOrdered[i].getCost();
        }
        return total;
    }            
    
}
