package com.eitax.recall.front.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eitax.recall.front.domain.Lambda;
import com.eitax.recall.front.domain.Profile;
import com.eitax.recall.front.service.AWSMasterDataService;
import com.eitax.recall.front.service.LambdaService;
import com.eitax.recall.front.service.ProfileService;
import com.eitax.recall.front.service.impl.LoginUserDetails;

import jp.co.eitan.cloud.itool.api.model.ApiProfile;

@Controller
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private ApiProfile apiProfile;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private LambdaService lambdaService;
	@Autowired
	private AWSMasterDataService awsMasterDataService;

    @ModelAttribute
    private CustomerForm setUpForm() {
        return new CustomerForm();
    }
	
    @RequestMapping( method = RequestMethod.GET)
    private String list(@AuthenticationPrincipal LoginUserDetails userDetails,Model model) {
        Profile profiile = profileService.findOne(userDetails.getUsername());
//        List<Lambda> lambdaList = lambdaService.retrieveLambda(profiile);
//        model.addAttribute("lambdaList", lambdaList);
        this.apiProfile.setAccessKey(profiile.getAccessKey());
        this.apiProfile.setSecretKey(profiile.getSecretKey());
        model.addAttribute("profile", apiProfile);
        model.addAttribute("awsNames", awsMasterDataService.retrieveAwsNames());
        model.addAttribute("actionNames", awsMasterDataService.retrieveActions());
        model.addAttribute("regionNames", awsMasterDataService.retrieveRegions());
        model.addAttribute("triggerNames", awsMasterDataService.retrieveLambdaTriggers());
        CustomerForm form = new CustomerForm ();
        for (GrantedAuthority ga : userDetails.getAuthorities()){
        	String auth = ga.getAuthority();
        	if (auth.equals("ROLE_ADMIN")){
        		form.setAdmin(true);
                model.addAttribute("role", "ROLE_ADMIN");
        	}
        }
        model.addAttribute("customerForm",form);
//        
        return "customers/list";
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    String search(@Validated CustomerForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
    	this.list(userDetails,model);
        return "redirect:/customers";
    }

    
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    String create(@Validated CustomerForm form, BindingResult result, Model model,
//                  @AuthenticationPrincipal LoginUserDetails userDetails) {
//        if (result.hasErrors()) {
//            return list(userDetails,model);
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(form, customer);
////        customerService.create(customer, userDetails.getUser());
//        return "redirect:/customers";
//    }
//
//    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
//    String editForm(@RequestParam Integer id, CustomerForm form) {
//        Customer customer = customerService.findOne(id);
//        BeanUtils.copyProperties(customer, form);
//        return "customers/edit";
//    }
//
//    @RequestMapping(value = "edit", method = RequestMethod.POST)
//    String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result,
//                @AuthenticationPrincipal LoginUserDetails userDetails) {
//        if (result.hasErrors()) {
//            return editForm(id, form);
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(form, customer);
//        customer.setId(id);
////        customerService.update(customer, userDetails.getUser());
//        return "redirect:/customers";
//    }
//
//    @RequestMapping(value = "edit", params = "goToTop")
//    String goToTop() {
//        return "redirect:/customers";
//    }
//
//    @RequestMapping(value = "delete", method = RequestMethod.POST)
//    String delete(@RequestParam Integer id) {
//        customerService.delete(id);
//        return "redirect:/customers";
//    }
}
