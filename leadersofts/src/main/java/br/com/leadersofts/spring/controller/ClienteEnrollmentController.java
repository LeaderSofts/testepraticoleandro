package br.com.leadersofts.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.leadersofts.spring.dao.ClienteDAO;
import br.com.leadersofts.spring.model.Cliente;

@Controller

public class ClienteEnrollmentController {
	
	 @Autowired
	private ClienteDAO clienteDao;
	
	@RequestMapping(value ="/enroll",method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "enroll";
	}
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveRegistration(@Valid Cliente cliente,
			BindingResult result, ModelMap model,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "enroll";
		}
		clienteDao.save(cliente);				
		return "redirect:/viewclientes/1";
	}
	
	@RequestMapping("/viewclientes")  
    public ModelAndView viewclientes(){  
        List<Cliente> list=clienteDao.listaClientes();
        return new ModelAndView("viewclientes","list",list);  
    } 
	
	/* It opens the client list for the given page id */
	@RequestMapping(value="/viewclientes/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=2;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Cliente> list=clienteDao.getclientesByPage(pageid,total);            
        return new ModelAndView("viewclientes","list",list);  
    }
	
	/* It opens the record for the given id in editcliente page */
	 @RequestMapping(value="/editcliente/{id}")  
	    public String edit(@PathVariable int id,ModelMap model){  
	       Cliente cliente=clienteDao.getClienteById(id);  
	       model.addAttribute("cliente", cliente);
			return "editcliente";
	        
	        
	    } 
	 
	 /* It updates record for the given id in editcliente page and redirects to /viewclientes */  
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("cliente") Cliente cli){  
	    	System.out.println("id is"+cli.getId_cliente() );
	    	clienteDao.update(cli);  
	        return new ModelAndView("redirect:/viewclientes/1");  
	    }  
	 
	 /* It deletes record for the given id  and redirects to /viewclientes */  
	    @RequestMapping(value="/deletecliente/{id}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int id){  
	    	clienteDao.delete();  
	        return new ModelAndView("redirect:/viewclientes/1");  
	    }  
	    
	    /* It deletes record for the given id  and redirects to /viewclientes */  
	    @RequestMapping(value="/delete",method = RequestMethod.GET)  
	    public ModelAndView delete(){  
	    	clienteDao.delete();  
	        return new ModelAndView("redirect:/enroll");  
	    }  
	
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Research");
		return sections;
	}

	/*
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}

	/*
	 * Method used to populate the subjects list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {

		List<String> subjects = new ArrayList<String>();
		subjects.add("Physics");
		subjects.add("Chemistry");
		subjects.add("Life Science");
		subjects.add("Political Science");
		subjects.add("Computer Science");
		subjects.add("Mathmatics");
		return subjects;
	}
	
	/*
	 * Method used to populate the Section list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	 @ModelAttribute("pageCount")
		public List<String> initializePageCount() {
		    int total=2;  
			List<String> pageCount = new ArrayList<String>();
			int count=clienteDao.count(); 
			int result=((count/total)+ (count%total));
			for(int k=0;k<result;k++) {
				pageCount.add(new Integer(k).toString());
			}
			
			return pageCount;
		}

}
