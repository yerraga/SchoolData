package com.schooldata.restapi.schoolData;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.schooldata.restapi.schoolData.Controller.FeeController;
import com.schooldata.restapi.schoolData.Entity.Fee;
import com.schooldata.restapi.schoolData.Enum.Standard;
import com.schooldata.restapi.schoolData.Enum.StudentType;
import com.schooldata.restapi.schoolData.RequestDTO.FeeRequestDTO;
import com.schooldata.restapi.schoolData.Service.FeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class FeeControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private FeeService feeService;

    @InjectMocks
    private FeeController feeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(feeController).build();
    }

    @Test
    public void feeList_success() throws Exception {
        Fee feeResponse1 = new Fee(1L,
                Standard.ONE,
                StudentType.HOSTLER,
                100000,
                150000,
                10000,
                0,
                75000,
                100000,
                335000L,
                435000L);
        Fee feeResponse2 = new Fee(2L, Standard.ONE,
                StudentType.DAYS_SCHOLAR,
                100000,
                0,
                10000,
                50000,
                75000,
                100000,
                335000L,
                435000L);
        List<Fee> feeResponseList = Arrays.asList(feeResponse1, feeResponse2);
        Mockito.when(feeService.getFeeList()).thenReturn(feeResponseList);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/V1/fee/getFeeList")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveFee_Success() throws Exception {
        Fee fee = new Fee(1L, Standard.ONE, StudentType.HOSTLER, 100000, 150000, 10000, 0, 75000, 100000, 335000L, 435000L);
        FeeRequestDTO feeRequestDTO = FeeRequestDTO.builder()
                .standard(Standard.ONE)
                .studentType(StudentType.HOSTLER)
                .schoolFee(100000)
                .hostelFee(150000)
                .uniformFee(10000)
                .busFee(0)
                .examinationFee(75000)
                .tuitionFee(100000)
                .daysScholarFee(335000L)
                .hostlerFee(435000L)
                .build();

        Mockito.when(feeService.saveFee(feeRequestDTO)).thenReturn(fee);

        String content = objectMapper.writeValueAsString(feeRequestDTO);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/api/V1/fee/saveFee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id").value(fee.getId()))
                .andExpect(jsonPath("$.standard").value(fee.getStandard().toString()))
                .andExpect(jsonPath("$.studentType").value(fee.getStudentType().toString()));
    }
}