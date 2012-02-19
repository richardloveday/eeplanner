package com.eeplanner.web;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.validation.BindException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.datastructures.Contact;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 07-Dec-2009
 * Time: 13:52:08
 * To change this template use File | Settings | File Templates.
 */
public class ContactController extends SimpleFormController {

    Logger log  = Logger.getLogger(ContactController.class);

    private ContactDao contactDao;

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return super.onSubmit(request, response, command, errors);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        Contact contact = new Contact();
        if(ServletRequestUtils.getIntParameter(request, "id")!=null){
            contact = contactDao.getContactByID(ServletRequestUtils.getIntParameter(request, "id"));    
        }
        return contact;
    }

   /* protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.fatal("I am some debugging");

        int count = contactDao.getContactCount();

        System.out.println("contact count..."+count);


        return null;
    }*/
}