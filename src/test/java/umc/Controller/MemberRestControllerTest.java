package umc.Controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import umc.study.service.MemberService.MemberCommandService;
import umc.study.web.controller.MemberRestController;

@WebMvcTest(MemberRestController.class)
public class MemberRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberCommandService memberCommandService;

    @Test
    public void whenPostRequestToYourControllerAndInValidRequest_thenCorrectResponse() throws Exception {
        String jsonContent = "{\"missionId\": 1,\n \"memberId\": 1,\n \"missionStatus\": \"CHALLENGING\"\n}";

        mockMvc.perform(MockMvcRequestBuilders.post("/members/missions")
                        .contentType("application/json")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()); // 또는 다른 적절한 상태 코드
    }
}
