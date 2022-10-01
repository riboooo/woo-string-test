package com.example.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    public void splitTest(){
        // given
        String target_1 = "1,2";
        String target_2 = "1";

        // when
        String[] result_1 = target_1.split(",");
        String[] result_2 = target_2.split(",");

        // then
        assertThat(result_1).contains("1","2");
        assertThat(result_2).containsExactly("1");
    }

    @Test
    public void substringTest(){
        // given
        String target = "(1,2)";

        // when
        String result = target.substring(1,4);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    public void charAtTest(){
        // given
        String target = "abc";
        int index = 2;

        // when
        char c = target.charAt(index);

        // then
        assertThat(c).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt assertThatThrownBy Exception 처리 테스트")
    public void charAtExceptionTest(){
        // given
        String target = "abc";
        int index = 30;

        // when && then
        assertThatThrownBy(() -> {
                    char c = target.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }

    @Test
    @DisplayName("charAt assertThatExceptionOfType Exception 처리 테스트")
    public void charAtExceptionOfTypeTest(){
        // given
        String target = "abc";
        int index = 30;

        // when && then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = target.charAt(index);
                    assertThat(c).isEqualTo('c');
                }).withMessageContaining("%d", index);
    }
}
