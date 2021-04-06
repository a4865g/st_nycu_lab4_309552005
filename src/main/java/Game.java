public class Game {
    public void Check_input(String user_input) throws IllegalArgumentException{
        if(!(user_input.equals("rock")||user_input.equals("paper")||user_input.equals("scissors")))
            throw new IllegalArgumentException("Bad Choice!");
    }
    public String Result(String p1_input, String p2_input){
        String result="";
        switch (p1_input){
            case "rock":
                if(p2_input.equals("rock")) result = "Draw!";
                if(p2_input.equals("paper")) result = "Player 2 win!";
                if(p2_input.equals("scissors")) result = "Player 1 win!";
                break;
            case "paper":
                if(p2_input.equals("rock")) result = "Player 1 win!";
                if(p2_input.equals("paper")) result = "Draw!";
                if(p2_input.equals("scissors")) result = "Player 2 win!";
                break;
            case "scissors":
                if(p2_input.equals("rock")) result = "Player 2 win!";
                if(p2_input.equals("paper")) result = "Player 1 win!";
                if(p2_input.equals("scissors")) result = "Draw!";
                break;
        }
        return result;
    }
}
