/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suber.Models;

/**
 *
 * @author sunyifei
 */
public class Member {
    
    private String lastMatchDate;
    private String[] offerList;
    private String[] seekList;
    private String[] agreementList;
    private double/** Vector? **/payment;
    private int commissionRate;
    private CorporateMember corporateMem;
    private MembershipPayment membershioPayment;
    private String creditCard;
    private String accountExpiry;
    private String accountOwnerName;
    private String paymentMedia;
    private String passward;

    
    public Member(String lastMatchDate, String[] offerList, String[] seekList, 
            String[] agreementList, double payment, int commissionRate, 
            CorporateMember corporateMem, MembershipPayment membershioPayment, 
            String creditCard, String accountExpiry, String accountOwnerName, 
            String paymentMedia, String passward) {
        this.lastMatchDate = lastMatchDate;
        this.offerList = offerList;
        this.seekList = seekList;
        this.agreementList = agreementList;
        this.payment = payment;
        this.commissionRate = commissionRate;
        this.corporateMem = corporateMem;
        this.membershioPayment = membershioPayment;
        this.creditCard = creditCard;
        this.accountExpiry = accountExpiry;
        this.accountOwnerName = accountOwnerName;
        this.paymentMedia = paymentMedia;
        this.passward = passward;
    }

    public String getLastMatchDate() {
        return lastMatchDate;
    }

    public void setLastMatchDate(String lastMatchDate) {
        this.lastMatchDate = lastMatchDate;
    }

    public String[] getOfferList() {
        return offerList;
    }

    public void setOfferList(String[] offerList) {
        this.offerList = offerList;
    }

    public String[] getSeekList() {
        return seekList;
    }

    public void setSeekList(String[] seekList) {
        this.seekList = seekList;
    }

    public String[] getAgreementList() {
        return agreementList;
    }

    public void setAgreementList(String[] agreementList) {
        this.agreementList = agreementList;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(int commissionRate) {
        this.commissionRate = commissionRate;
    }

    public CorporateMember getCorporateMem() {
        return corporateMem;
    }

    public void setCorporateMem(CorporateMember corporateMem) {
        this.corporateMem = corporateMem;
    }

    public MembershipPayment getMembershioPayment() {
        return membershioPayment;
    }

    public void setMembershioPayment(MembershipPayment membershioPayment) {
        this.membershioPayment = membershioPayment;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getAccountExpiry() {
        return accountExpiry;
    }

    public void setAccountExpiry(String accountExpiry) {
        this.accountExpiry = accountExpiry;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public void setAccountOwnerName(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
    }

    public String getPaymentMedia() {
        return paymentMedia;
    }

    public void setPaymentMedia(String paymentMedia) {
        this.paymentMedia = paymentMedia;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
    
    
    
    
    
      
}
