
 public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length ;
    private float cost;
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCatagory()
    {
        return category;
    }
    public String getDirector()
    {
        return director;
    }
    public int getLength()
    {
        return length;
    }
    public float getCost()
    {
        return cost;
    }        
    public DigitalVideoDisc(String title)
    {
        super();
        this.title=title;
    }
    public DigitalVideoDisc(String title, String category, float cost)
    {
        super();
        this.title=title;
        this.category= category;
        this.cost= cost;
    }
    public DigitalVideoDisc(String title, String category,String director, float cost)
    {
        super();
        this.title=title;
        this.director=director;
        this.category= category;
        this.cost= cost;
    }
    public DigitalVideoDisc(String title, String category,String director,int length, float cost)
    {
        super();
        this.title=title;
        this.director=director;
        this.category= category;
        this.length =length;
        this.cost= cost;
    }
    
    
    
}
