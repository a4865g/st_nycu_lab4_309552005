import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game test_game;

    @BeforeEach
    void setUp(){
        test_game=new Game();
    }

    static Stream<Arguments> Stream_P1W_P2L(){
        return Stream.of(
                arguments("rock","scissors"),
                arguments("paper","rock"),
                arguments("scissors","paper")
        );
    }

    static Stream<Arguments> Stream_P1L_P2W(){
        return Stream.of(
                arguments("rock","paper"),
                arguments("paper","scissors"),
                arguments("scissors","rock")
        );
    }
    static Stream<Arguments> Stream_Draw(){
        return Stream.of(
                arguments("rock","rock"),
                arguments("paper","paper"),
                arguments("scissors","scissors")
        );
    }

    @ParameterizedTest(name="#{index} - Test with Player 1:{0} ; Player 2:{1}")
    @MethodSource("Stream_P1W_P2L")
    public void Player1_win_Player2_lose_case(String p1,String p2){
        String expect="Player 1 win!";
        assertEquals(expect,test_game.Result(p1,p2));
    }
    @ParameterizedTest(name="#{index} - Test with Player 1:{0} ; Player 2:{1}")
    @MethodSource("Stream_P1L_P2W")
    public void Player2_win_Player1_lose_case(String p1,String p2){
        String expect="Player 2 win!";
        assertEquals(expect,test_game.Result(p1,p2));
    }
    @ParameterizedTest(name="#{index} - Test with Player 1:{0} ; Player 2:{1}")
    @MethodSource("Stream_Draw")
    public void Draw_case(String p1,String p2){
        String expect="Draw!";
        assertEquals(expect,test_game.Result(p1,p2));
    }


    @Test
    void Valid_input_case() {
        String string_valid="rock";
        assertDoesNotThrow(()->{test_game.Check_input(string_valid);});
    }

    @Test
    void Invalid_input_case() {
        String string_invalid="setsal";
        assertThrows(IllegalArgumentException.class,()->{
            test_game.Check_input(string_invalid);
        });
    }
}