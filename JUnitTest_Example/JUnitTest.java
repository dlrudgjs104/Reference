import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.awt.Color;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class JUnitTest {

    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            MovableBall ball = new MovableBall(100, 100, 100, Color.BLACK);

            assertEquals(MovableBall.DEFAULT_DX, ball.getDX());
            assertEquals(MovableBall.DEFAULT_DY, ball.getDY());

        });
    }

    @ParameterizedTest
    @MethodSource("deltaProvider")
    void testDeltaXY(int x, int y, int radius, int dx, int dy) {
        assertDoesNotThrow(() -> {
            MovableBall ball = new MovableBall(x, y, radius, Color.RED);

            ball.setDX(dx);
            ball.setDX(dy);
            assertEquals(dx, ball.getDX());
            assertEquals(dy, ball.getDY());
        });
    }

    static Stream<Arguments> deltaProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 10, 0, 0),
                Arguments.arguments(0, 0, 10, 1, -1),
                Arguments.arguments(0, 0, 10, 1, 1),
                Arguments.arguments(0, 0, 10, -1, 1),
                Arguments.arguments(0, 0, 10, -1, -1),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, 0),
                Arguments.arguments(0, 0, 10, 0, Integer.MAX_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MIN_VALUE, 0),
                Arguments.arguments(0, 0, 10, 0, Integer.MIN_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }
}
