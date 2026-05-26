package cinema.movies;

public class ComedyMovie extends Movie {
    private String comedyType;
    public ComedyMovie(String title,int duration, double ticketPrice,String comedyType){
        super(title, duration, ticketPrice);
        this.comedyType=comedyType;
    }

    public String getComedyType() {
        return comedyType;
    }

    public void setComedyType(String comedyType) {
        this.comedyType = comedyType;
    }

    public void showDetails(){
        System.out.println("-----alem cinema------ ");
        System.out.println("-----comedy movies ------ ");
        System.out.println("movie title "+ getTitle());
        System.out.println("duration "+ getDuration());
        System.out.println("comedy type"+ getComedyType());
        System.out.println("ticketPrice" + getTicketPrice());
    }
//    public void calculatePrice(){  i think i should calculate the price depending on the no of seat the us rwant
//
//    }
}
