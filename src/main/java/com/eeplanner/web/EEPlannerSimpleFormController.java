package com.eeplanner.web;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.bind.ServletRequestUtils;
import com.eeplanner.datastructures.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EEPlannerSimpleFormController extends SimpleFormController {

    protected Date getDateFromString(String date) throws Exception {
        if(date.length()>0){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate = dateFormat.parse(date);
        return convertedDate;
        }
        return null;
    }

    protected Date getDateTimeFromString(String date) throws Exception {
    	SimpleDateFormat dateFormat;
    	if(date.length()>10){
    		dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    	    Date convertedDate = dateFormat.parse(date);
            return convertedDate;
        }
    	else if(date.length()>0){
    		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date convertedDate = dateFormat.parse(date);
            return convertedDate;
        }
        return null;
    }

    protected Contact buildContactNumbersEmailsNotes(Contact contact, HttpServletRequest request) throws Exception {

        List<Phone> phoneNumbers = new ArrayList<Phone>();
        List<Email> emails = new ArrayList<Email>();
        List<Note> notes = new ArrayList<Note>();

        int count1 = 0, count2 = 0, count3 = 0;
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            if (name.contains("phoneName")) {
                Phone p = new Phone();
                if (contact.getPhoneNumbers()!=null && contact.getPhoneNumbers().size() > count1) p = contact.getPhoneNumbers().get(count1);
                else {
                    p.setID(ServletRequestUtils.getIntParameter(request, "phoneID" + count1) != null ?
                            ServletRequestUtils.getIntParameter(request, "phoneID" + count1) :
                            0
                    );
                }
                p.setName(request.getParameter("phoneName" + count1));
                p.setNumber(request.getParameter("phoneNumber" + count1));
                phoneNumbers.add(p);
                count1++;
            } else if (name.contains("emailName")) {
                Email email = new Email();
                if (contact.getEmails()!=null&&contact.getEmails().size() > count2) email = contact.getEmails().get(count2);
                else {
                    email.setID(ServletRequestUtils.getIntParameter(request, "emailID" + count2) != null ?
                            ServletRequestUtils.getIntParameter(request, "emailID" + count2) :
                            0
                    );
                }
                email.setName(request.getParameter("emailName" + count2));
                email.setAddress(request.getParameter("emailAddress" + count2));
                emails.add(email);
                count2++;
            } else if (name.contains("noteName")) {
                Note n = new Note();
                if (contact.getNotes()!=null&&contact.getNotes().size() > count3) n = contact.getNotes().get(count3);
                else {
                    n.setID(ServletRequestUtils.getIntParameter(request, "noteID" + count3) != null ?
                            ServletRequestUtils.getIntParameter(request, "noteID" + count3) :
                            0
                    );
                }
                n.setName(request.getParameter("noteName" + count3));
                n.setText(request.getParameter("noteText" + count3));
                notes.add(n);
                count3++;
            }
        }

        contact.setEmails(emails);
        contact.setNotes(notes);
        contact.setPhoneNumbers(phoneNumbers);

        return contact;
    }

    protected Contact buildSchoolContactNumbersEmailsNotes(Contact schoolContact, HttpServletRequest request) throws Exception {

        List<Phone> phoneNumbers = new ArrayList<Phone>();
        List<Email> emails = new ArrayList<Email>();
        List<Note> notes = new ArrayList<Note>();

        int count1 = 0, count2 = 0, count3 = 0;
        for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String name = (String) e.nextElement();
            if (name.contains("schoolPhoneName")) {
                Phone p = new Phone();
                if (schoolContact.getPhoneNumbers()!=null && schoolContact.getPhoneNumbers().size() > count1) p = schoolContact.getPhoneNumbers().get(count1);
                else {
                    p.setID(ServletRequestUtils.getIntParameter(request, "schoolPhoneID" + count1) != null ?
                            ServletRequestUtils.getIntParameter(request, "schoolPhoneID" + count1) :
                            0
                    );
                }
                p.setName(request.getParameter("schoolPhoneName" + count1));
                p.setNumber(request.getParameter("schoolPhoneNumber" + count1));
                phoneNumbers.add(p);
                count1++;
            } else if (name.contains("schoolEmailName")) {
                Email email = new Email();
                if (schoolContact.getEmails()!=null&&schoolContact.getEmails().size() > count2) email = schoolContact.getEmails().get(count2);
                else {
                    email.setID(ServletRequestUtils.getIntParameter(request, "schoolEmailID" + count2) != null ?
                            ServletRequestUtils.getIntParameter(request, "schoolEmailID" + count2) :
                            0
                    );
                }
                email.setName(request.getParameter("schoolEmailName" + count2));
                email.setAddress(request.getParameter("schoolEmailAddress" + count2));
                emails.add(email);
                count2++;
            } else if (name.contains("schoolNoteName")) {
                Note n = new Note();
                if (schoolContact.getNotes()!=null&&schoolContact.getNotes().size() > count3) n = schoolContact.getNotes().get(count3);
                else {
                    n.setID(ServletRequestUtils.getIntParameter(request, "schoolNoteID" + count3) != null ?
                            ServletRequestUtils.getIntParameter(request, "schoolNoteID" + count3) :
                            0
                    );
                }
                n.setName(request.getParameter("schoolNoteName" + count3));
                n.setText(request.getParameter("schoolNoteText" + count3));
                notes.add(n);
                count3++;
            }
        }

        schoolContact.setEmails(emails);
        schoolContact.setNotes(notes);
        schoolContact.setPhoneNumbers(phoneNumbers);

        return schoolContact;
    }
}
