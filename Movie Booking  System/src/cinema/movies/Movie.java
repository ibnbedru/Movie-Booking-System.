package cinema.movies;


public abstract class Movie {
        private String title;
        private int duration ;
        private double ticketPrice;

        public Movie(String title,int duration,double ticketPrice){
            this.title= title;
            this.duration= duration;
            this.ticketPrice= ticketPrice;
         }

        public String getTitle(){
            return title;
        }
        public int getDuration(){
            return duration;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }
// I Just write the setter because it's asked for the project but i didn"t use any of this setters 
        public void setTitle(String title) {
            this.title = title;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
        public void setTicketPrice(double ticketPrice){
            this.ticketPrice = ticketPrice;
        }
        public abstract  void showDetails();

    }


