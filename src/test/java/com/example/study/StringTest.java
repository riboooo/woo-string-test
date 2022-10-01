package com.example.study;

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


}
