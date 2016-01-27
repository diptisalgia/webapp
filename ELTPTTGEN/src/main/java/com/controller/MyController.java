package com.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bean.Batch;
import com.bean.Session;
import com.bean.Trainer;
import com.bean.User;
import com.bean.User_type;
import com.dao.TrainerDao;
import com.service.AddBatchAndCreateTTwithSubPriority;
import com.service.BatchService;
import com.service.CheckLogin;



@Controller
public class MyController {

	private static boolean flag=false;

	@RequestMapping("welcome")
	public ModelAndView method1() throws Exception {
		if(flag==false){
			User u = new User("admin", "admin", User_type.ADMIN);
			new CheckLogin().create_user(u);
			flag=true;
		}
		return new ModelAndView("login");
	}


	@RequestMapping("next")
	public ModelAndView method2(HttpServletRequest request, ModelMap map)
			throws Exception {

		String un = request.getParameter("Username");
		String pw = request.getParameter("Password");

		CheckLogin checkLogin = new CheckLogin();
		User result = checkLogin.checkLogin(un, pw);
		if (result != null) {
			map.addAttribute(result);
			return new ModelAndView("index_manager", "result", result);

		} else {
			return new ModelAndView("login");
		}

	}


	@RequestMapping("index_manager")// changed
	public ModelAndView dashboard() throws Exception {

		return new ModelAndView("index_manager");
		// pass trainer and batch details on every call to inndex_manager
	}


	//deleted create user
	@RequestMapping("create_user")
	public ModelAndView create(ModelMap map)throws Exception{

		User user = new User();
		map.addAttribute(user);

		//pass trainer and batch details on every call to inndex_manager

		return new ModelAndView("index_manager");
	}


	@RequestMapping("create_user_1")
	public ModelAndView create_1(@ModelAttribute("user")User user,HttpServletRequest request)throws Exception{	

		user.setUser_type(User_type.MANAGER);
		//System.out.println(user);
		CheckLogin cc=new CheckLogin();
		cc.create_user(user);
		return new ModelAndView("index_manager");
	}


	@ModelAttribute("user")
	public User createModel() {
		return new User();
	}


	@RequestMapping("logout")
	public ModelAndView logout() throws Exception {

		return new ModelAndView("login");
	}


	@RequestMapping("add_batch")
	public ModelAndView add_batch(HttpServletRequest request, ModelMap map)
			throws Exception {
		Batch batch = new Batch();
		map.addAttribute(batch);

		return new ModelAndView("batch_new");
	}


	@RequestMapping("add_batch_1")
	public ModelAndView add_batch_1(@ModelAttribute("batch") Batch batch,
			HttpServletRequest request) throws Exception {
		//System.out.println(batch);
		// batch.setBatch_id(0);
		AddBatchAndCreateTTwithSubPriority tt = new AddBatchAndCreateTTwithSubPriority();
		tt.addBatch(batch);

		return new ModelAndView("index_manager");
	}

	
//is it used anywhere?????????????????????????????????????????????????????????
	@RequestMapping("show_trainer")
	public ModelAndView show_internal() throws Exception {

		//System.out.println("hi");

		// Get_Trainer trainer= new Get_Trainer();
		List<Trainer> trainer_list = new TrainerDao().GetInternalTrainers();
		//System.out.println("**");
		for (Trainer t1 : trainer_list) {
			System.out.println(t1);
		}
		int i = 1;
		Map<String, Object> model = new HashMap<String, Object>();
		for (Trainer t : trainer_list) {
			model.put("t" + i, t);
			i++;

		}

		return new ModelAndView("index_manager", "model", model);
	}


	@RequestMapping(value = "downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@ModelAttribute("batch")Batch batch,HttpServletRequest request) {
		//Batch b= new Batch("b", Batch_type.DEVELOPMENT, "Nagpur", "a",15, new Date());//will get this object from request
		List<Batch> batches=new BatchService().getbatchlist();
		List<Session> sessions=null;;
		for (Batch batche : batches) {
			if(batche.getBatch_name().equalsIgnoreCase(batch.getBatch_name())){
				sessions=batche.getSessions();
				break;
			}
		}
		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("excelView", "sessions", sessions);
	}


	@RequestMapping(value = "downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadPDF(@ModelAttribute("batch")Batch batch,HttpServletRequest request) {
		// create some sample data
		//Batch b= new Batch("b", Batch_type.DEVELOPMENT, "Nagpur", "a",15, new Date());//will get this object from request
		List<Batch> batches=new BatchService().getbatchlist();
		List<Session> sessions=null;;
		for (Batch batche : batches) {
			if(batche.getBatch_name().equalsIgnoreCase(batch.getBatch_name())){
				sessions=batche.getSessions();
				break;
			}
		}
		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "sessions", sessions);
	}


	@RequestMapping("download")
	public ModelAndView download(HttpServletRequest request,Model map) throws Exception {
		Batch batch = new Batch();
		map.addAttribute(batch);
		return new ModelAndView("download");
	}

}
