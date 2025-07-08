package MailService;

import ShipmentService.Shipment;

import java.util.ArrayList;

public class PendingMails {
    private ArrayList<Mail> mails;
    private int mailCount;
    public PendingMails(){
        mails = new ArrayList<Mail>();
        mailCount=0;
    }
    public ArrayList<Mail> getBooks() {
        return mails;
    }
    public void addMail(Mail mail) {
        mails.add(mail);
        mailCount++;
    }
    public void removeShipment(Mail mail) {
        mails.remove(mail);
        mailCount--;
    }
}
