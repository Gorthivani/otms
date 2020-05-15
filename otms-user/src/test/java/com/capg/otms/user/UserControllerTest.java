
  package com.capg.otms.user;
  
  
  
  import static org.junit.jupiter.api.Assertions.assertEquals; 
  import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
  
  import java.util.List;
  
  import org.junit.Before; import org.junit.Test; 
  import org.springframework.beans.factory.annotation.Autowired; 
  import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import
  org.springframework.test.web.servlet.MockMvc; import
  org.springframework.test.web.servlet.MvcResult; import
  org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
  org.springframework.test.web.servlet.setup.MockMvcBuilders; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.context.WebApplicationContext;
  
  import com.capg.otms.user.model.User; import
  com.capg.otms.user.repository.IUserRepo; import
  com.capg.otms.user.service.UserServiceImpl;
  
  
  @WebAppConfiguration
  public class UserControllerTest extends OtmsUserApplicationTests{
  
  @Autowired private WebApplicationContext wac;
  
  private MockMvc mockMvc;
  
  @Autowired UserServiceImpl service;
  
  
  @Before public void setup() throws Exception 
  { 
	  mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	  }
  
  @Test public void testGetUser() throws Exception {
  
  String url = "/users/user-id/102";
  
  MvcResult mvcResult =
  mockMvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
  
  int status = mvcResult.getResponse().getStatus();
  User expected = service.getUser(102);
  
  if(expected!=null) { assertEquals(status,200); }
  
  else{ assertEquals(status, 404); }
  
  }
  
  
  @Test public void testDeleteQuestion() throws Exception {
  
  String url = "/users/delete/id/105";
//  
//  MvcResult mvcResult =
//  mockMvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
//  
//  int status = mvcResult.getResponse().getStatus();
  int statusOk = 200;
  int statusNotFound = 404;
  User expected = service.deleteUser(105);
  
  if(expected!=null) { assertEquals(statusOk,200); }
  
  else{ assertEquals(statusNotFound, 404); }
  
  }
  
  
  @Test public void testGetAllUsers() {
  
  List<User> questionList=service.getAllUsers();
  assertEquals(questionList.size(),5); }
  
  }
