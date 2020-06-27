package サンプル;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// 実行不要になったら @Disabled を有効にする
//@Disabled
public class サンプルテスト {

    サンプル サンプル;

    @BeforeEach
    public void それぞれのテストが実行される前に行われる前処理() {
        サンプル = new サンプル();
    }

    @Test
    void 加算のテスト_1足す1は2のはず() {
        int 実測値 = サンプル.加算する(1, 1);
        int 期待値 = 2;
        assertThat(実測値, is(期待値));
    }

    @DisplayName("失敗するテストのサンプル")
    @Test
    void 加算のテスト_2足す3は5のはず() {
        assertThat(サンプル.加算する(2, 3), is(4));
    }

    static Stream<Arguments> 加算のテスト_パラメタライズテスト_入力() {
        return Stream.of(
                arguments(0, 1, 1),
                arguments(11, 58, 69),
                arguments(11, -58, -47)
        );
    }

    @ParameterizedTest(name = "{0} と {1} を加算すると {2} になるはず")
    @MethodSource("加算のテスト_パラメタライズテスト_入力")
    void 加算のテスト_パラメタライズテスト(int a, int b, int c) {
        assertThat(サンプル.加算する(a, b), is(c));
    }

    @Nested
    class 減算のテスト {
        @Test
        void _13引く27はマイナス14のはず() {
            assertThat(サンプル.減算する(13, 27), is(-14));
        }
    }
}
