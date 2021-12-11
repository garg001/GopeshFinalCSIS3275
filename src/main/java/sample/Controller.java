package sample;

//github link:https://github.com/garg001/GopeshFinalCSIS3275

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"id","name","errMsg","ans","deposit","years"})
@RequestMapping
@org.springframework.stereotype.Controller
public class Controller {
    DAO_Implementation service1;
    @Autowired
    CustomerService service;
    @Autowired
    Connection123 connect;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showCustomerpage(ModelMap model) throws ClassNotFoundException, SQLException {

        service1=new DAO_Implementation(connect.connect());
        model.addAttribute("todos",service1.display());


        List<Customer> filteredTodos = new ArrayList<Customer>();

        filteredTodos = (List) model.get("todos");


        if(filteredTodos.size()>0) {
            model.put("id", filteredTodos.get(0).getCustno());


            model.put("name", filteredTodos.get(0).getCustname());
            model.put("deposit", filteredTodos.get(0).getCdep());
            model.put("years", filteredTodos.get(0).getNyears());
            model.put("type", filteredTodos.get(0).getSavtype());
        }
        return "customer";


    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCustomerPage2(ModelMap model) throws ClassNotFoundException, SQLException {

        service1=new DAO_Implementation(connect.connect());
        model.addAttribute("todos",service1.display());


        List<Customer> filteredTodos = new ArrayList<Customer>();

        filteredTodos = (List) model.get("todos");


        if(filteredTodos.size()>0) {

            model.put("id", filteredTodos.get(0).getCustno());


            model.put("name", filteredTodos.get(0).getCustname());
            model.put("deposit", filteredTodos.get(0).getCdep());
            model.put("years", filteredTodos.get(0).getNyears());
            model.put("type", filteredTodos.get(0).getSavtype());

        }
        return "customer";


    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.GET)
    public String showtodopage(){
        return "custer";
    }


    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String custno, @RequestParam String custname,@RequestParam Double cdep,@RequestParam int nyears,@RequestParam String savtype) throws SQLException, ClassNotFoundException {

        if(!((service1.search(custno))==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/customer";
        }

        Customer c=new Customer(custno,custname,cdep,nyears,savtype);
        service1.add(c);
        model.clear();
        return "redirect:/customer";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        model.put("id", id);


        Customer x = service1.search(id);

        model.put("id", x.getCustno());


        model.put("name", x.getCustname());
        model.put("deposit",x.getCdep());
        model.put("years",x.getNyears());
        model.put("type",x.getSavtype());


        return "custedit";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String custno, @RequestParam String custname,@RequestParam Double cdep,@RequestParam int nyears,@RequestParam String savtype) throws SQLException, ClassNotFoundException {

        String iid = (String) model.get("id");

        Customer cc=new Customer(custno,custname,cdep,nyears,savtype);
        service1.edit(cc,iid);


        return "redirect:/";

    }


    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id ) throws SQLException, ClassNotFoundException {



        service1.delete(id);
        model.clear();
        return "redirect:/";
    }


}
