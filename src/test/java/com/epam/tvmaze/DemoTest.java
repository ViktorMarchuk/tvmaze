package com.epam.tvmaze;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class DemoTest{
    @Test
    public void testDemo(){
        assertThat("Demo").isEqualTo("Demo");
    }
    @Test
    public void testDemo1(){
        assertThat(4).isEqualTo(4);
    }
}

