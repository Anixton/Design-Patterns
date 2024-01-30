public abstract class AbstractContent implements Content { 
    protected String title;

    public AbstractContent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void display() {
        System.out.println("Title: " + title);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}