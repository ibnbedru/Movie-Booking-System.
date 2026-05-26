package cinema.movies;


public class ActionMovie extends Movie {
    private String  movieType;
    public ActionMovie(String title, int duration,double ticketPrice,String movieType){
        super(title, duration, ticketPrice);
        this.movieType= movieType;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void showDetails(){
        System.out.println("-----Alem cinema------ ");
        System.out.println("******ACTION MOVIE******");

        System.out.println("movie title "+ getTitle());
        System.out.println("duration "+ getDuration());
        System.out.println("movie type"+ getMovieType());
        System.out.println("ticketPrice" + getTicketPrice());
    }

}
