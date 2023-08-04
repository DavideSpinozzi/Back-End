package davidespinozzi.S5CompitiGiornalieri;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class S5CompitiGiornalieriApplicationTests {

@Autowired 
private MockMvc MockMvc;

@Test
void test() throws Exception {
	
	this.MockMvc.perform(get("localhost:8080/prova/info/italiano"))
	.andDo(print()).andExpect(status().isAccepted())
	.andExpect(content().string(containsString("italiano")));
}

}
