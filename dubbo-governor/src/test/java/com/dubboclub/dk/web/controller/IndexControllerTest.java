package com.dubboclub.dk.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;

@Ignore
public class IndexControllerTest extends SetUp{

    @Test
    public void testIndex() throws Exception {
        this.mockMvc.perform(get("/index.htm")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_XHTML_XML)).andReturn();
    }
}