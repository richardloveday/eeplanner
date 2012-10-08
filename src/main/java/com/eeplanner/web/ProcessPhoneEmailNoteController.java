package com.eeplanner.web;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.note.NoteDao;
import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.Email;
import com.eeplanner.datastructures.Note;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessPhoneEmailNoteController extends MultiActionController{

    private PhoneDao phoneDao;
    private EmailDao emailDao;
    private NoteDao noteDao;

    public ModelAndView storePhoneNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        int phoneID = 0;
        Phone phone = new Phone();
        if (ServletRequestUtils.getIntParameter(request, "phoneNumber") != null) {
            if (ServletRequestUtils.getIntParameter(request, "phoneID")!=null){
                phoneID = ServletRequestUtils.getIntParameter(request, "phoneID");
            }
            phone.setID(phoneID);
            phone.setContactID(ServletRequestUtils.getIntParameter(request, "contactID"));
            phone.setName(ServletRequestUtils.getStringParameter(request, "phoneName"));
            phone.setNumber(ServletRequestUtils.getStringParameter(request, "phoneNumber"));
            phoneDao.storePhoneNumber(phone);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public ModelAndView storeEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        int emailID = 0;
        Email email = new Email();
        if (ServletRequestUtils.getIntParameter(request, "emailAddress") != null) {
            if (ServletRequestUtils.getIntParameter(request, "emailID")!=null){
                emailID = ServletRequestUtils.getIntParameter(request, "emailID");
            }
            email.setID(emailID);
            email.setContactID(ServletRequestUtils.getIntParameter(request, "contactID"));
            email.setName(ServletRequestUtils.getStringParameter(request, "emailName"));
            email.setAddress(ServletRequestUtils.getStringParameter(request, "emailAddress"));
            emailDao.storeEmail(email);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public ModelAndView storeNote(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        int noteID = 0;
        Note note = new Note();
        if (ServletRequestUtils.getIntParameter(request, "noteText") != null) {
            if (ServletRequestUtils.getIntParameter(request, "noteID")!=null){
                noteID = ServletRequestUtils.getIntParameter(request, "noteID");
            }
            note.setID(noteID);
            note.setContactID(ServletRequestUtils.getIntParameter(request, "contactID"));
            note.setName(ServletRequestUtils.getStringParameter(request, "noteName"));
            note.setText(ServletRequestUtils.getStringParameter(request, "noteText"));
            noteDao.storeNote(note);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public ModelAndView removePhone(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        if (ServletRequestUtils.getIntParameter(request, "phoneID") != null) {
            int phoneID = ServletRequestUtils.getIntParameter(request, "phoneID");
            phoneDao.removePhoneNumber(phoneID);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public ModelAndView removeEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        if (ServletRequestUtils.getIntParameter(request, "phoneID") != null) {
            int emailID = ServletRequestUtils.getIntParameter(request, "emailID");
            emailDao.removeEmail(emailID);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public ModelAndView removeNote(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirectPath = ServletRequestUtils.getStringParameter(request, "redirectPath");
        int redirectID = ServletRequestUtils.getIntParameter(request, "redirectID");
        if (ServletRequestUtils.getIntParameter(request, "phoneID") != null) {
            int noteID = ServletRequestUtils.getIntParameter(request, "noteID");
            noteDao.removeNote(noteID);
        }
        return new ModelAndView("redirect:"+redirectPath+"?id="+redirectID);
    }

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }
}

